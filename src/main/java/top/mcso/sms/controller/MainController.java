package top.mcso.sms.controller;

import com.google.gson.Gson;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.mcso.sms.entity.*;
import top.mcso.sms.service.*;
import top.mcso.sms.utils.FormatUtils;
import top.mcso.sms.utils.SessionUtils;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
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
    private static Gson gson = new Gson();
    @Resource
    private UserService userService;
    @Resource
    private StudentService studentService;
    @Resource
    private TeacherService teacherService;
    @Resource
    private CourseService courseService;
    @Resource
    private ClassesService classesService;
    @Resource
    private AnnouncementService announcementService;
    @Resource
    private ScheduleService scheduleService;
    @Resource
    private GradeService gradeService;

    // 主页面
    @RequestMapping({"/", "index", "home", "index.html"})
    public String home(Model model) {
        // 未登录则跳转到登录页面
        if (!SessionUtils.hasLogin()) {
            return "redirect:/login";
        }

        String role = SessionUtils.getRole();
        model.addAttribute("role", role);
        model.addAttribute("user", SessionUtils.getName());
        // 设置面板数据
        if ("ROLE_admin".equals(role)) {
            model.addAttribute("dashboardData", getAdminDashboardData());
        } else if ("ROLE_teacher".equals(role)) {
            model.addAttribute("dashboardData", getTeacherDashboardData());
        } else if ("ROLE_student".equals(role)) {
            model.addAttribute("dashboardData", getStudentDashboardData());
        }
        // 设置公告
        model.addAttribute("announcements", getAnnouncements());

        return "index";
    }

    // 设置页面
    @GetMapping("settings")
    public String settings(Model model) {
        if (!SessionUtils.hasLogin()) {
            return "redirect:/login";
        }

        String name = SessionUtils.getName();
        String role = SessionUtils.getRole();

        model.addAttribute("name", name);
        model.addAttribute("role", role);
        model.addAttribute("password", userService.findUserByUserNumber(name).getPassword());

        // 不同用户设置不同数据
        if ("ROLE_admin".equals(role)) {
            model.addAttribute("admin", "admin");
        } else if ("ROLE_teacher".equals(role)) {
            model.addAttribute("teacher", teacherService.getByJobNumber(name));
        } else if ("ROLE_student".equals(role)) {
            model.addAttribute("student", studentService.getStudentByNumber(name));
        }

        return "settings";
    }

    @PostMapping("settings")
    public String settingsPost(@RequestParam Map<String, String> data) {
        if (!SessionUtils.hasLogin()) {
            return "redirect:/login";
        }

        WebResponse response = new WebResponse();
        String name = SessionUtils.getName();
        String role = SessionUtils.getRole();

        // 区分不同数据
        if ("ROLE_admin".equals(role)) {
            if (data.containsKey("password")) {
                User user = userService.findUserByUserNumber(name);
                user.setPassword(data.get("password"));
                userService.updateUser(user);
                response.setCode(0);
                response.setMsg("更新信息成功！");
            } else {
                response.setCode(-1);
                response.setMsg("未设置密码！");
            }
        } else if ("ROLE_teacher".equals(role)) {
            if (data.containsKey("password") && data.containsKey("address") && data.containsKey("telephone")) {
                User user = userService.findUserByUserNumber(name);
                user.setPassword(data.get("password"));
                userService.updateUser(user);
                Teacher teacher = teacherService.getByJobNumber(name);
                teacher.setAddress(data.get("address"));
                teacher.setTelephone(Long.valueOf(data.get("telephone")));
                teacherService.updateTeacher(teacher);
                response.setCode(0);
                response.setMsg("更新信息成功！");
            } else {
                response.setCode(-1);
                response.setMsg("未设置密码！");
            }
        } else if ("ROLE_student".equals(role)) {
            if (data.containsKey("password") && data.containsKey("address") && data.containsKey("telephone")) {
                User user = userService.findUserByUserNumber(name);
                user.setPassword(data.get("password"));
                userService.updateUser(user);
                Student student = studentService.getStudentByNumber(name);
                student.setAddress(data.get("address"));
                student.setTelephone(Long.valueOf(data.get("telephone")));
                studentService.updateStudent(student);
                response.setCode(0);
                response.setMsg("更新信息成功！");
            } else {
                response.setCode(-1);
                response.setMsg("未设置密码！");
            }
        }

        return "redirect:/settings?response=" + URLEncoder.encode(gson.toJson(response), StandardCharsets.UTF_8);
    }

    private Map<String, Object> getAdminDashboardData() {
        Map<String, Object> data = new HashMap<>();
        data.put("studentCount", studentService.getAll().size());
        data.put("teacherCount", teacherService.getAll().size());
        data.put("courseCount", courseService.getAllCourses().size());
        return data;
    }

    private Map<String, Object> getTeacherDashboardData() {
        String name = SessionUtils.getName();

        // 获取所教的班级
        List<String> classes = new ArrayList<>();
        List<Integer> allClasses = new ArrayList<>();
        for (Classes c : classesService.getAllClasses()) {
            if (c.getTeacherNumber().equals(name)) {
                classes.add(c.getNumber() + "班");
                allClasses.add(c.getNumber());
            }
        }

        // 获取所教课程
        List<String> courses = new ArrayList<>();
        for (Course c : courseService.getAllCourses()) {
            if (c.getTeacherNumber().equals(name)) {
                courses.add(c.getCourseName());
            }
        }

        // 获取所教学生
        int sum = 0;
        List<Student> allStudent = studentService.getAll();
        for (Student s : allStudent) {
            if (allClasses.contains(s.getClasses())) {
                sum++;
            }
        }

        Map<String, Object> data = new HashMap<>();
        data.put("class", classes);
        data.put("course", courses);
        data.put("student", sum);
        return data;
    }

    private Map<String, Object> getStudentDashboardData() {
        String user = SessionUtils.getName();

        // 获取成绩
        double avgGrade = gradeService.getStatisticsByStudentNumber(user).getAvgGrade();

        // 获取课程
        List<String> classes = new ArrayList<>();
        for (Schedule s : scheduleService.getScheduleByStudentNumber(user)) {
            classes.add(courseService.getCourseByCourseNumber(s.getCourseNumber()).getCourseName());
        }

        Map<String, Object> data = new HashMap<>();
        data.put("currentCourses", classes);
        data.put("gradeLevel", FormatUtils.getLevel(avgGrade));
        data.put("averageGrade", avgGrade);
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
