package top.mcso.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class TeacherController {

    @GetMapping("/my-courses")
    public String myCourses(Model model) {
        return "teacher/class";
    }

    @GetMapping("/student-management")
    public String studentManagement() {
        return "teacher/student";
    }

    @GetMapping("/grade-management")
    public String gradeManagement() {
        return "teacher/grade";
    }
}
