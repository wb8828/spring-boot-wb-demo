package com.spring.demo;


import cn.hutool.extra.spring.EnableSpringUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(scanBasePackages = {"com.spring.demo"})
@ServletComponentScan
@ConfigurationPropertiesScan
@EnableCaching
@MapperScan("com.spring.demo.**.mapper")
public class SelfDevApplication {
    public static void main(String[] args) {
        SpringApplication.run(SelfDevApplication.class);
    }
}