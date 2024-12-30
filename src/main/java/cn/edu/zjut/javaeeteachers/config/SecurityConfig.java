package cn.edu.zjut.javaeeteachers.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // 禁用 CSRF 防护
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/register", "/css/**", "/js/**", "/login", "/error", "/api/**").permitAll() // 放行相关资源
                        .anyRequest().authenticated() // 其他请求需要认证
                )
                .formLogin(login -> login
                        .loginPage("/login").permitAll()// 设置登录页面路径
                        .loginProcessingUrl("/login") // 修改默认登录处理路径
                        .defaultSuccessUrl("/success", true) // 登录成功后跳转路径
                        .failureUrl("/login?error=true") // 登录失败后跳转路径
                ); // 这里没有 `httpBasic()`，而是通过 `formLogin()` 来实现登录功能

        return http.build();
    }
}
