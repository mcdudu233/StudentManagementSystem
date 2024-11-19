package top.mcso.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/class")
    public String myCourses(Model model) {
        return "teacher/class";
    }

    @RequestMapping("/grade")
    public String studentManagement() {
        return "teacher/student";
    }

    @RequestMapping("/student")
    public String gradeManagement() {
        return "teacher/grade";
    }
}
