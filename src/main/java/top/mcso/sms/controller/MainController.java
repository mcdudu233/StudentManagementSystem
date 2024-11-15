package top.mcso.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    // 主页面
    @RequestMapping("/")
    public String home(Model model) {
        String role = "ROLE_TEACHER";
        // 根据角色加载不同的数据
        model.addAttribute("role", role);
        if ("ROLE_ADMIN".equals(role)) {
            model.addAttribute("dashboardData", getAdminDashboardData());
        } else if ("ROLE_TEACHER".equals(role)) {
            model.addAttribute("dashboardData", getTeacherDashboardData());
        } else if ("ROLE_STUDENT".equals(role)) {
            model.addAttribute("dashboardData", getStudentDashboardData());
        }
        return "index";
    }

    private Map<String, Object> getAdminDashboardData() {
        Map<String, Object> data = new HashMap<>();
        data.put("studentCount", 1200);
        data.put("courseCount", 50);
        data.put("attendanceRate", "5%");
        return data;
    }

    private Map<String, Object> getTeacherDashboardData() {
        Map<String, Object> data = new HashMap<>();
        data.put("classCount", 5);
        data.put("studentCount", 100);
        data.put("avgGrade", "85");
        return data;
    }

    private Map<String, Object> getStudentDashboardData() {
        Map<String, Object> data = new HashMap<>();
        data.put("currentCourses", List.of("数据结构", "操作系统"));
        data.put("attendance", "良好");
        data.put("averageGrade", "90");
        return data;
    }
}
