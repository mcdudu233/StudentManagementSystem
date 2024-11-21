package top.mcso.sms.utils;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/**
 * 会话信息工具
 * 提供网页各种会话信息的方法
 *
 * @author dudu233
 * @create: 2024-11-19 20:01
 * @version: 1.0
 */

public class SessionUtils {
    /**
     * 判断用户是否登录
     *
     * @return boolean
     */
    public static boolean hasLogin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && authentication.isAuthenticated();
    }

    /**
     * 获取登录的用户名
     *
     * @return String:用户名，未登录返回null
     */
    public static String getName() {
        if (!hasLogin()) {
            return null;
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 获取用户信息
        User principal = (User) authentication.getPrincipal();
        return principal.getUsername();
    }

    /**
     * 获取用户角色
     *
     * @return String:返回用户角色，未登录返回null
     */
    public static String getRole() {
        if (!hasLogin()) {
            return null;
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String role = "ROLE_null";
        for (GrantedAuthority ga : authentication.getAuthorities()) {
            role = ga.getAuthority();
        }
        return role;
    }

    /**
     * 获取登录的密码
     *
     * @return String:密码，未登录返回null
     */
    public static String getPassword() {
        if (!hasLogin()) {
            return null;
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 获取用户信息
        User principal = (User) authentication.getPrincipal();
        return principal.getPassword();
    }

    /**
     * 判断登录的用户是否为学生
     *
     * @return boolean
     */
    public static boolean isStudent() {
        return hasLogin() && "ROLE_student".equals(getRole());
    }

    /**
     * 判断登录的用户是否为老师
     *
     * @return boolean
     */
    public static boolean isTeacher() {
        return hasLogin() && "ROLE_teacher".equals(getRole());
    }

    /**
     * 判断登录的用户是否为管理员
     *
     * @return boolean
     */
    public static boolean isAdmin() {
        return hasLogin() && "ROLE_admin".equals(getRole());
    }
}
