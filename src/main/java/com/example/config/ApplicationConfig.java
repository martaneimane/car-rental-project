package com.example.config;

import com.example.database.NoSQLDatabaseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApplicationConfig {
    @Bean
    public NoSQLDatabaseService noSQLDatabase() {
        return new NoSQLDatabaseService();
    }


}

