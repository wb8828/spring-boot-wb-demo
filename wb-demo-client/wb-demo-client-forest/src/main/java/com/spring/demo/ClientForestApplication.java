package com.spring.demo;


import com.dtflys.forest.springboot.annotation.ForestScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.spring.demo"})
@ForestScan(basePackages = {"com.spring.demo.client"})
public class ClientForestApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientForestApplication.class);
    }
}