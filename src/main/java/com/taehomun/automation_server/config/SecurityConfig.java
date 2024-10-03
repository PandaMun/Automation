package com.taehomun.automation_server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()  // CSRF 보호 비활성화 (개발 환경에서만 사용)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/member/**").permitAll()  // 특정 경로에 대한 접근 허용
                        .anyRequest().authenticated()  // 그 외의 요청은 인증 필요
                )
                .formLogin(login -> login  // 폼 기반 로그인 설정
                        .loginPage("/login")  // 사용자 정의 로그인 페이지 경로
                        .permitAll()
                )
                .logout(logout -> logout  // 로그아웃 설정
                        .logoutUrl("/logout")
                        .permitAll()
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
