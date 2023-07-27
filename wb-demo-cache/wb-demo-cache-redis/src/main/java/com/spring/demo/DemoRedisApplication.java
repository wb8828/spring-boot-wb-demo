package com.spring.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cache.annotation.EnableCaching;

@ConfigurationPropertiesScan
@EnableCaching
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}, scanBasePackages = {"com.spring.demo"})
public class DemoRedisApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoRedisApplication.class);
    }
}