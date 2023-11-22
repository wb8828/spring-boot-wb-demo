package com.spring.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

//@EnableConfigurationProperties
@ConfigurationPropertiesScan
@SpringBootApplication
public class XXLJobSampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(XXLJobSampleApplication.class, args);
    }
}