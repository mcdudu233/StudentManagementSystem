package top.mcso.sms.controller;


import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.mcso.sms.entity.Course;
import top.mcso.sms.service.CourseService;
import top.mcso.sms.service.GradeService;
import top.mcso.sms.service.StudentService;
import top.mcso.sms.utils.SessionUtils;

import java.util.List;

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

    @RequestMapping("select")
    public String select(Model model) {
        if (!SessionUtils.isStudent()) {
            return "redirect:/login";
        }

        // 设置用户名
        String user = SessionUtils.getName();
        model.addAttribute("user", user);

        // 获取所有课程并设置
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courseList", courses);

        return "student/select";
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
