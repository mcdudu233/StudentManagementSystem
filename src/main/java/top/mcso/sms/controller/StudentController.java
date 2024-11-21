package top.mcso.sms.controller;

import com.google.gson.Gson;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.mcso.sms.entity.Course;
import top.mcso.sms.entity.Grade;
import top.mcso.sms.entity.Schedule;
import top.mcso.sms.entity.WebResponse;
import top.mcso.sms.service.CourseService;
import top.mcso.sms.service.GradeService;
import top.mcso.sms.service.ScheduleService;
import top.mcso.sms.service.TeacherService;
import top.mcso.sms.utils.FormatUtils;
import top.mcso.sms.utils.SessionUtils;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 处理学生页面
 *
 * @author dudu233
 * @create: 2024-11-19 17:13
 * @version: 1.0
 */

@Controller
@RequestMapping("/student")
public class StudentController {
    private static Gson gson = new Gson();
    @Resource
    private TeacherService teacherService;
    @Resource
    private CourseService courseService;
    @Resource
    private GradeService gradeService;
    @Resource
    private ScheduleService scheduleService;

    @GetMapping("select")
    public String select(Model model, @RequestParam Map<String, String> data) {
        if (!SessionUtils.isStudent()) {
            return "redirect:/login";
        }

        // 设置用户名
        String user = SessionUtils.getName();
        model.addAttribute("user", user);

        // 获取所有课程并设置
        List<Map<String, String>> courseList = new ArrayList<>();
        for (Course course : courseService.getAllCourses()) {
            Map<String, String> courseMap = new HashMap<>();
            courseMap.put("courseNumber", course.getCourseNumber());
            courseMap.put("courseName", course.getCourseName());
            courseMap.put("teacherName", teacherService.findByJobNumber(course.getTeacherNumber()).getTeacherName());
            courseMap.put("credit", String.valueOf(course.getCredit()));
            courseMap.put("when", FormatUtils.getClassTime(course.getWeek(), course.getDay()));
            courseMap.put("spot", course.getSpot());
            courseMap.put("priorityCourse", course.getPriorityCourse());
            courseList.add(courseMap);
        }
        model.addAttribute("courseList", courseList);

        // 判断是否已经选课
        if (!data.isEmpty() && data.containsKey("response")) {
            model.addAttribute("response", gson.fromJson(data.get("response"), WebResponse.class));
        }

        return "student/select";
    }

    @PostMapping("select")
    public String selectPost(@RequestParam("course") String courseNumber, @RequestParam("student") String studentNumber) {
        if (!SessionUtils.isStudent()) {
            return "redirect:/login";
        }

        WebResponse response = new WebResponse();
        // 判断学生是否已经选了该课程
        boolean flag = true;
        for (Schedule s : scheduleService.getScheduleByStudentNumber(studentNumber)) {
            if (s.getCourseNumber().equals(courseNumber)) {
                response.setCode(-1);
                response.setMsg("您已经选过该课程了！");
                flag = false;
            }
        }

        // 没有选则选课
        if (flag) {
            scheduleService.insertSchedule(new Schedule(studentNumber, courseNumber));
            response.setCode(0);
            response.setMsg("选课成功！");
        }

        return "redirect:/student/select?response=" + URLEncoder.encode(gson.toJson(response), StandardCharsets.UTF_8);
    }

    @RequestMapping("class")
    public String classes(Model model) {
        if (!SessionUtils.isStudent()) {
            return "redirect:/login";
        }

        // 设置用户名
        String user = SessionUtils.getName();
        model.addAttribute("user", user);

        // 设置课程表
        List<Map<String, String>> schedule = new ArrayList<>();
        // 生成星期一到星期天的11节课的空列表
        for (int i = 1; i <= 11; i++) {
            Map<String, String> scheduleMap = new HashMap<>();
            scheduleMap.put("time", FormatUtils.getDay(i));
            scheduleMap.put("monday", "");
            scheduleMap.put("tuesday", "");
            scheduleMap.put("wednesday", "");
            scheduleMap.put("thursday", "");
            scheduleMap.put("friday", "");
            scheduleMap.put("saturday", "");
            scheduleMap.put("sunday", "");
            schedule.add(scheduleMap);
        }
        // 遍历所有课程并放在课程表中
        for (Schedule s : scheduleService.getScheduleByStudentNumber(user)) {
            Course c = courseService.getCourseByCourseNumber(s.getCourseNumber());
            schedule.get(c.getDay()).put(FormatUtils.getWeekEnglish(c.getWeek()), c.getCourseName());
        }
        model.addAttribute("schedule", schedule);

        return "student/class";
    }

    @RequestMapping("grade")
    public String grade(Model model) {
        if (!SessionUtils.isStudent()) {
            return "redirect:/login";
        }

        // 设置用户名
        String user = SessionUtils.getName();
        model.addAttribute("user", user);

        // 获得每科的成绩
        List<Map<String, String>> grades = new ArrayList<>();
        for (Grade g : gradeService.findGradeByStudentNumber(user)) {
            Course c = courseService.getCourseByCourseNumber(g.getCourseNumber());
            Map<String, String> gradeMap = new HashMap<>();
            gradeMap.put("courseId", c.getCourseNumber());
            gradeMap.put("courseName", c.getCourseName());
            gradeMap.put("teacherName", teacherService.findByJobNumber(c.getTeacherNumber()).getTeacherName());
            gradeMap.put("credits", String.valueOf(c.getCredit()));
            gradeMap.put("score", String.valueOf(g.getGrade()));
            grades.add(gradeMap);
        }
        model.addAttribute("grades", grades);

        return "student/grade";
    }
}
