package top.mcso.sms.controller;

import jakarta.annotation.Resource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.mcso.sms.entity.Announcement;
import top.mcso.sms.service.AnnouncementService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 主页控制器
 * 处理主页的内容
 *
 * @author dudu233
 * @create: 2024-11-15 16:24
 * @version: 1.0
 */

@Controller
public class MainController {
    @Resource
    AnnouncementService announcementService;

    // 主页面
    @RequestMapping("/")
    public String home(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 未登录则跳转到登录页面
        if (authentication == null) {
            return "redirect:/login";
        }

        // 获取用户信息
        User principal = (User) authentication.getPrincipal();
        String role = "ROLE_null";
        for (GrantedAuthority ga : principal.getAuthorities()) {
            role = ga.getAuthority();
        }

        model.addAttribute("role", role);
        model.addAttribute("user", principal.getUsername());
        // 设置面板数据
        if ("ROLE_admin".equals(role)) {
            model.addAttribute("dashboardData", getAdminDashboardData());
        } else if ("ROLE_teacher".equals(role)) {
            model.addAttribute("dashboardData", getTeacherDashboardData());
        } else if ("ROLE_student".equals(role)) {
            model.addAttribute("dashboardData", getStudentDashboardData());
        } else {
            model.addAttribute("dashboardData", getAdminDashboardData());
        }
        // 设置公告
        model.addAttribute("announcements", getAnnouncements());

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

    private List<String> getAnnouncements() {
        List<Announcement> all = announcementService.getAllAnnouncements();
        List<String> announcements = new ArrayList<>();
        for (Announcement a : all) {
            announcements.add(a.getAnnouncement());
        }
        return announcements;
    }
}
