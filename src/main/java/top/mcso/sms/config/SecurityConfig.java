package top.mcso.sms.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 网页安全配置
 * 用于不同用户的登录和注销
 *
 * @author dudu233
 * @create: 2024-11-15 16:24
 * @version: 1.0
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // 配置每个页面的权限
        http.authorizeHttpRequests((requests) -> {
            requests.requestMatchers("/login", "/logout").permitAll();                   // 不需要认证的资源
            requests.requestMatchers("/css/*.css", "/js/*.js", "/img/**").permitAll(); // 静态资源不需要认证
            requests.anyRequest().authenticated();                                           // 其他所有资源要认证
        });
        // 登录页面
        http.formLogin((form) -> form
                .loginPage("/login")    // 登录页面
                .successForwardUrl("/") // 登录成功跳转的页面
        );
        // 登出页面
        http.logout((logout) -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
        );
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        // 添加用户
        manager.createUser(User.withUsername("user").password("password").roles("USER").build());
        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // 密码编码器 暂时为明文保存
        return NoOpPasswordEncoder.getInstance();
    }
}

