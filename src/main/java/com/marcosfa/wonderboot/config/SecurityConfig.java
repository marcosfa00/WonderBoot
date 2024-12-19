package com.marcosfa.wonderboot.config;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
@ConfigurationPropertiesScan
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(auth -> auth
                        .requestMatchers("/css/**").permitAll()
                        .requestMatchers("/img/**").permitAll()
                        .requestMatchers("/api/**").permitAll()
                        .requestMatchers("actuator/prometheus").permitAll()
                        .requestMatchers("actuator/**").hasRole("ADMIN")
                        .requestMatchers("/admin").hasRole("ADMIN")
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/signup").permitAll()
                                        .anyRequest().authenticated())
                .formLogin(security -> security.loginPage("/login").defaultSuccessUrl("/trips").permitAll())
                .build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }
}
