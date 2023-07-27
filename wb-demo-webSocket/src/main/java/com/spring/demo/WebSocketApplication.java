package com.spring.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication(scanBasePackages = {"com.spring.demo"})
@ConfigurationPropertiesScan
public class WebSocketApplication {
    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(WebSocketApplication.class);
    }
}