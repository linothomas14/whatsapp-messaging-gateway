package com.linothomas.learn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Disable CSRF untuk testing
                .authorizeHttpRequests((auth) -> auth
                        .anyRequest().permitAll() // Semua request diizinkan tanpa autentikasi
                )
                .httpBasic().disable() // Matikan basic auth
                .formLogin().disable(); // Matikan form login

        return http.build();
    }
}
