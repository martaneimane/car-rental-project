package com.example.config;

import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;

public class ApplicationConfig {
    @Value("${property.environemt}")
    private String env;


    @PostConstruct
    private void init() {
        System.out.println("\n \n \n ENV VAL " + env + "\n \n \n");
    }

}
