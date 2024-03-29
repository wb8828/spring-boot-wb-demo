package com.spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.spring.demo"})
public class KafkaApplication {
    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class);
    }
}