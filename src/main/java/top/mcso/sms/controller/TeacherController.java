package top.mcso.sms.controller;

import com.google.gson.Gson;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.mcso.sms.entity.*;
import top.mcso.sms.service.*;
import top.mcso.sms.utils.FormatUtils;
import top.mcso.sms.utils.SessionUtils;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 处理教师页面
 *
 * @author qzn
 * @create: 2024-11-19 17:13
 * @version: 1.0
 */


@Controller
@RequestMapping("/teacher")
public class TeacherController {
    private static Gson gson = new Gson();
    @Resource
    private StudentService studentService;
    @Resource
    private TeacherService teacherService;
    @Resource
    private CourseService courseService;
    @Resource
    private ScheduleService scheduleService;
    @Resource
    private GradeService gradeService;

    @RequestMapping("class")
    public String myCourses(Model model) {
        if (!SessionUtils.isTeacher()) {
            return "redirect:/login";
        }

        // 设置用户名
        String user = SessionUtils.getName();
        model.addAttribute("user", user);

        // 获取所有课程并设置
        List<Map<String, String>> courseList = new ArrayList<>();
        for (Course course : courseService.getAllCourses()) {
            if (course.getTeacherNumber().equals(user)) {
                Map<String, String> courseMap = new HashMap<>();
                courseMap.put("courseNumber", course.getCourseNumber());
                courseMap.put("courseName", course.getCourseName());
                courseMap.put("schedule", FormatUtils.getClassTime(course.getWeek(), course.getDay()));
                courseMap.put("spot", course.getSpot());
                courseMap.put("studentCount", String.valueOf(scheduleService.getSchedulesByCourseNumber(course.getCourseNumber()).size()));
                courseList.add(courseMap);
            }
        }
        model.addAttribute("courses", courseList);

        return "teacher/class";
    }

    @RequestMapping("student")
    public String studentManagement(Model model) {
        if (!SessionUtils.isTeacher()) {
            return "redirect:/login";
        }

        // 设置用户名
        String user = SessionUtils.getName();
        model.addAttribute("user", user);

        // 获取所有学生
        List<Map<String, String>> students = new ArrayList<>();
        for (Course course : courseService.getAllCourses()) {
            if (course.getTeacherNumber().equals(user)) {
                for (Schedule s : scheduleService.getSchedulesByCourseNumber(course.getCourseNumber())) {
                    Student stu = studentService.getStudentByNumber(s.getStudentNumber());
                    Map<String, String> studentMap = new HashMap<>();
                    studentMap.put("id", stu.getStudentNumber());
                    studentMap.put("name", stu.getStudentName());
                    studentMap.put("class", course.getCourseNumber());
                    studentMap.put("age", String.valueOf(stu.getAge()));
                    studentMap.put("telephone", String.valueOf(stu.getTelephone()));
                    students.add(studentMap);
                }
            }
        }
        model.addAttribute("students", students);

        return "teacher/student";
    }

    @GetMapping("grade")
    public String gradeManagement(Model model) {
        if (!SessionUtils.isTeacher()) {
            return "redirect:/login";
        }

        // 设置用户名
        String user = SessionUtils.getName();
        model.addAttribute("user", user);

        // 获得所有学生的成绩
        List<Map<String, String>> grades = new ArrayList<>();
        List<Map<String, String>> courses = new ArrayList<>();
        for (Course c : courseService.getAllCourses()) {
            if (c.getTeacherNumber().equals(user)) {
                // 获得该课程下的所有成绩
                for (Grade g : gradeService.getGradesByCourseNumber(c.getCourseNumber())) {
                    Map<String, String> gradeMap = new HashMap<>();
                    gradeMap.put("studentId", g.getStudentNumber());
                    gradeMap.put("studentName", studentService.getStudentByNumber(g.getStudentNumber()).getStudentName());
                    gradeMap.put("courseId", c.getCourseNumber());
                    gradeMap.put("courseName", c.getCourseName());
                    gradeMap.put("score", String.valueOf(g.getGrade()));
                    grades.add(gradeMap);
                }

                Map<String, String> courseMap = new HashMap<>();
                courseMap.put("courseNumber", c.getCourseNumber());
                courseMap.put("courseName", c.getCourseName());
                List<Student> students = new ArrayList<>();
                // 获得该课程下的所有学生
                for (Schedule s : scheduleService.getSchedulesByCourseNumber(c.getCourseNumber())) {
                    // 如果该学生没有输入成绩才显示
                    boolean flag = true;
                    for (Grade g : gradeService.getGradeByStudentNumber(s.getStudentNumber())) {
                        if (g.getCourseNumber().equals(c.getCourseNumber())) {
                            flag = false;
                        }
                    }
                    if (flag) {
                        students.add(studentService.getStudentByNumber(s.getStudentNumber()));
                    }
                }
                courseMap.put("students", gson.toJson(students));
                courses.add(courseMap);
            }
        }
        model.addAttribute("grades", grades);

        // 获取课程及课程下的学生
        model.addAttribute("courses", courses);

        return "teacher/grade";
    }

    @PostMapping("grade")
    public String gradePost(@RequestParam Map<String, String> data) {
        if (!SessionUtils.isTeacher()) {
            return "redirect:/login";
        }

        WebResponse response = new WebResponse();

        // 判断什么操作
        switch (data.getOrDefault("function", "")) {
            case "update": {
                Grade grade = gson.fromJson(FormatUtils.mapToJson(data), Grade.class);
                gradeService.updateGrade(grade);
                response.setCode(0);
                response.setMsg("更新学生成绩成功！");
                break;
            }
            case "add": {
                Grade grade = gson.fromJson(FormatUtils.mapToJson(data), Grade.class);
                gradeService.insertGrade(grade);
                response.setCode(0);
                response.setMsg("新增学生成绩成功！");
                break;
            }
            default: {
                response.setCode(-1);
                response.setMsg("操作错误！");
                break;
            }
        }

        return "redirect:/teacher/grade?response=" + URLEncoder.encode(gson.toJson(response), StandardCharsets.UTF_8);
    }
}
