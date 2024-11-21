package top.mcso.sms.controller;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.mcso.sms.entity.Course;
import top.mcso.sms.entity.Grade;
import top.mcso.sms.entity.Schedule;
import top.mcso.sms.service.*;
import top.mcso.sms.utils.FormatUtils;
import top.mcso.sms.utils.SessionUtils;

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

    @RequestMapping("/class")
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

    @RequestMapping("/student")
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
                    Map<String, String> studentMap = new HashMap<>();
                    studentMap.put("id", s.getStudentNumber());
                    // TODO studentMap.put("name", studentService.getStudentByName());
                    studentMap.put("className", course.getCourseNumber());
                    // studentMap.put("age", course.getCourseName());
                    // studentMap.put("email", String.valueOf(g.getGrade()));
                    students.add(studentMap);
                }
            }
        }
        model.addAttribute("students", students);

        return "teacher/student";
    }

    @RequestMapping("/grade")
    public String gradeManagement(Model model) {
        if (!SessionUtils.isTeacher()) {
            return "redirect:/login";
        }

        // 设置用户名
        String user = SessionUtils.getName();
        model.addAttribute("user", user);

        // 获得所有学生的成绩
        List<Map<String, String>> grades = new ArrayList<>();
        for (Course course : courseService.getAllCourses()) {
            if (course.getTeacherNumber().equals(user)) {
                for (Grade g : gradeService.findGradesByCourseNumber(course.getCourseNumber())) {
                    Map<String, String> gradeMap = new HashMap<>();
                    gradeMap.put("studentId", g.getStudentNumber());
                    // TODO gradeMap.put("studentName", studentService.getStudentByName());
                    gradeMap.put("courseId", course.getCourseNumber());
                    gradeMap.put("courseName", course.getCourseName());
                    gradeMap.put("score", String.valueOf(g.getGrade()));
                    grades.add(gradeMap);
                }
            }
        }
        model.addAttribute("grades", grades);

        return "teacher/grade";
    }
}
