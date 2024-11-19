package top.mcso.sms.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 处理管理员页面
 *
 * @author dudu233
 * @create: 2024-11-19 17:14
 * @version: 1.0
 */

@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping("user")
    public String user() {
        return "admin/user";
    }

    @RequestMapping("student")
    public String student() {
        return "admin/student";
    }

    @RequestMapping("teacher")
    public String teacher() {
        return "admin/teacher";
    }
}
