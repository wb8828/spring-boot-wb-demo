package com.spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication(exclude = {}, scanBasePackages = {"com.spring.demo"})
public class FlywayApplication {
    public static void main(String[] args) {
        SpringApplication.run(FlywayApplication.class);
    }
}