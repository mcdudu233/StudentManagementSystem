package top.mcso.sms.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.mcso.sms.utils.SessionUtils;

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
    @RequestMapping("select")
    public String select(Model model) {
        if (!SessionUtils.isStudent()) {
            return "redirect:/login";
        }
        String user = SessionUtils.getName();
        return "student/select";
    }

    @RequestMapping("class")
    public String classes() {
        return "student/class";
    }

    @RequestMapping("grade")
    public String grade() {
        return "student/grade";
    }
}
