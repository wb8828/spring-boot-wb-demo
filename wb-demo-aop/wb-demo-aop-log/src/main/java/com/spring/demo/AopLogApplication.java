package com.spring.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.spring.demo.**.mapper")
public class AopLogApplication {
    public static void main(String[] args) {
        SpringApplication.run(AopLogApplication.class);
    }
}