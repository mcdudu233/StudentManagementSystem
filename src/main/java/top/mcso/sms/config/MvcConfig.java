package top.mcso.sms.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * MVC配置文件
 * 用于添加视图和控制器的绑定
 *
 * @author dudu233
 * @create: 2024-11-15 16:31
 * @version: 1.0
 */

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 访问 /login（控制器） 页面返回 login.html（视图）
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/logout").setViewName("logout");
    }
}
