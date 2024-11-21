package top.mcso.sms.controller;


import com.google.gson.Gson;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.mcso.sms.entity.User;
import top.mcso.sms.entity.WebResponse;
import top.mcso.sms.service.StudentService;
import top.mcso.sms.service.TeacherService;
import top.mcso.sms.service.UserService;
import top.mcso.sms.utils.FormatUtils;
import top.mcso.sms.utils.SessionUtils;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
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
    private static Gson gson = new Gson();
    @Resource
    private UserService userService;
    @Resource
    private StudentService studentService;
    @Resource
    private TeacherService teacherService;

    @GetMapping("user")
    public String user(Model model) {
        if (!SessionUtils.isAdmin()) {
            return "redirect:/login";
        }

        // 设置用户名
        String user = SessionUtils.getName();
        model.addAttribute("user", user);

        // 获得所有用户
        model.addAttribute("users", userService.findAllUsers());

        return "admin/user";
    }

    @PostMapping("user")
    public String userPost(@RequestParam Map<String, String> data) {
        WebResponse response = new WebResponse();

        // 判断对用户的操作
        switch (data.getOrDefault("function", "")) {
            case "modify": {
                User user = gson.fromJson(FormatUtils.mapToJson(data), User.class);
                userService.updateUser(user);
                response.setCode(0);
                response.setMsg("更新用户成功！");
                break;
            }
            case "delete": {
                if (data.containsKey("userNumber")) {
                    userService.deleteUserByUserNumber(data.get("userNumber"));
                    response.setCode(0);
                    response.setMsg("删除用户成功！");
                } else {
                    response.setCode(-1);
                    response.setMsg("未指定删除对象！");
                }
                break;
            }
            case "add": {
                User user = gson.fromJson(FormatUtils.mapToJson(data), User.class);
                userService.insertUser(user);
                response.setCode(0);
                response.setMsg("新增用户成功！");
                break;
            }
            default: {
                response.setCode(-1);
                response.setMsg("操作错误！");
                break;
            }
        }

        return "redirect:/admin/user?response=" + URLEncoder.encode(gson.toJson(response), StandardCharsets.UTF_8);
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

    @GetMapping("teacher")
    public String teacher(Model model) {
        if (!SessionUtils.isAdmin()) {
            return "redirect:/login";
        }

        // 设置用户名
        String user = SessionUtils.getName();
        model.addAttribute("user", user);

        // 获得所有老师
        model.addAttribute("teachers", teacherService.getAll());

        return "admin/teacher";
    }

    @PostMapping("teacher")
    public String teacherPost(@RequestParam Map<String, String> data) {
        WebResponse response = new WebResponse();

        // 判断什么操作
        switch (data.getOrDefault("function", "")) {
            case "modify": {

            }
            case "delete": {

            }
            case "add": {

            }
            default: {
                response.setCode(-1);
                response.setMsg("操作错误！");
                break;
            }
        }

        return "redirect:/admin/teacher?response=" + URLEncoder.encode(gson.toJson(response), StandardCharsets.UTF_8);
    }
}
