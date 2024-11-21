package top.mcso.sms.controller;


import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.mcso.sms.entity.Teacher;
import top.mcso.sms.entity.User;
import top.mcso.sms.service.StudentService;
import top.mcso.sms.service.TeacherService;
import top.mcso.sms.service.UserService;
import top.mcso.sms.utils.SessionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Resource
    private UserService userService;
    @Resource
    private StudentService studentService;
    @Resource
    private TeacherService teacherService;

    @RequestMapping("user")
    public String user(Model model) {
        if (!SessionUtils.isAdmin()) {
            return "redirect:/login";
        }

        // 设置用户名
        String user = SessionUtils.getName();
        model.addAttribute("user", user);

        // 获得所有用户
        List<Map<String, String>> users = new ArrayList<>();
        int id = 0;
        for (User u : userService.findAllUsers()) {
            Map<String, String> userMap = new HashMap<>();
            userMap.put("id", String.valueOf(++id));
            userMap.put("username", u.getUserNumber());
            userMap.put("role", u.getPriority());
            users.add(userMap);
        }
        model.addAttribute("users", users);

        return "admin/user";
    }

    @RequestMapping("student")
    public String student(Model model) {
        if (!SessionUtils.isAdmin()) {
            return "redirect:/login";
        }

        // 设置用户名
        String user = SessionUtils.getName();
        model.addAttribute("user", user);

        return "admin/student";
    }

    @RequestMapping("teacher")
    public String teacher(Model model) {
        if (!SessionUtils.isAdmin()) {
            return "redirect:/login";
        }

        // 设置用户名
        String user = SessionUtils.getName();
        model.addAttribute("user", user);

        // 获得所有老师
        List<Map<String, String>> teachers = new ArrayList<>();
        for (Teacher t : teacherService.findAll()) {
            Map<String, String> teacherMap = new HashMap<>();
            teacherMap.put("id", t.getJobNumber());
            teacherMap.put("name", t.getTeacherName());
            teacherMap.put("subject", t.getDuty());
            teacherMap.put("contact", String.valueOf(t.getTelephone()));
            teachers.add(teacherMap);
        }
        model.addAttribute("teachers", teachers);

        return "admin/teacher";
    }
}
