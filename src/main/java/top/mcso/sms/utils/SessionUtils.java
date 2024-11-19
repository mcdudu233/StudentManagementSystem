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
    public static boolean hasLogin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && authentication.isAuthenticated();
    }

    public static String getName() {
        if (!hasLogin()) {
            return null;
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 获取用户信息
        User principal = (User) authentication.getPrincipal();
        return principal.getUsername();
    }

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
}
