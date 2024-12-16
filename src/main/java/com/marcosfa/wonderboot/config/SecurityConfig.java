package com.marcosfa.wonderboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(auth -> auth.requestMatchers("actuator/prometheus").permitAll()
                        .requestMatchers("/register").permitAll()
                                        .anyRequest().authenticated())
                .formLogin(security -> security.loginPage("/login").permitAll())
                .build();
    }
}
