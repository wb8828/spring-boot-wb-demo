package com.spring.demo.easyexcel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication(exclude = {}, scanBasePackages = {"com.spring.demo"})
public class EasyexcelApplication {
    public static void main(String[] args) {
        SpringApplication.run(EasyexcelApplication.class);
    }
}