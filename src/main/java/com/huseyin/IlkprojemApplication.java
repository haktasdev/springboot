package com.huseyin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class IlkprojemApplication {

    public static void main(String[] args) {
        SpringApplication.run(IlkprojemApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/api/**")
                    .allowedOrigins("*")  // Tüm originlere izin ver (sadece geliştirme için)
                    .allowedMethods("*");  // GET, POST, PUT, DELETE hepsi için
        }
    };
    }
}
