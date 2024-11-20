package top.mcso.sms.controller;


import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.mcso.sms.entity.Course;
import top.mcso.sms.service.CourseService;
import top.mcso.sms.service.GradeService;
import top.mcso.sms.service.StudentService;
import top.mcso.sms.utils.SessionUtils;

import java.util.ArrayList;
import java.util.HashMap;
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
    @Resource
    private StudentService studentService;
    @Resource
    private CourseService courseService;
    @Resource
    private GradeService gradeService;

    @GetMapping("select")
    public String select(Model model) {
        if (!SessionUtils.isStudent()) {
            return "redirect:/login";
        }

        // 设置用户名
        String user = SessionUtils.getName();
        model.addAttribute("user", user);

        // 获取所有课程并设置
        ArrayList<Map<String, String>> courseList = new ArrayList<>();
        for (Course course : courseService.getAllCourses()) {
            Map<String, String> courseMap = new HashMap<>();
            courseMap.put("courseNumber", course.getCourseNumber());
            courseMap.put("courseName", course.getCourseName());
            courseMap.put("teacherName", course.getTeacherNumber());
            courseMap.put("credit", String.valueOf(course.getCredit()));
            courseList.add(courseMap);
        }
        model.addAttribute("courseList", courseList);

        return "student/select";
    }

    @PostMapping("select")
    public String select(@RequestParam("course") String course, @RequestParam("student") String student) {
        if (!SessionUtils.isStudent()) {
            return "redirect:/login";
        }

        return "ok";
    }

    @RequestMapping("class")
    public String classes(Model model) {
        if (!SessionUtils.isStudent()) {
            return "redirect:/login";
        }

        // 设置用户名
        String user = SessionUtils.getName();
        model.addAttribute("user", user);

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

        return "student/grade";
    }
}
