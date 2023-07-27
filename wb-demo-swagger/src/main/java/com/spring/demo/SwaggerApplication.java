package com.spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

//@EnableConfigurationProperties
@ConfigurationPropertiesScan
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}, scanBasePackages = {"com.spring.demo"})
public class SwaggerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SwaggerApplication.class);
    }
}