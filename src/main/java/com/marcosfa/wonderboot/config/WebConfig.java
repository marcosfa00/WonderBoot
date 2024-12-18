package com.marcosfa.wonderboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Aplica CORS a todos los endpoints
                .allowedOrigins("http://localhost:8080") // Permite solicitudes desde localhost:8080
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS"); // Métodos permitidos
    }
}
