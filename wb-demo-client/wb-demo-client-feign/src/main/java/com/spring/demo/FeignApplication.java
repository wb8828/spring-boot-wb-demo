package com.spring.demo;

import com.spring.demo.client.TestClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 要在 @Configuration 注解的类上使用 @EnableFeignClients 注解，请确保指定客户端的位置，
 * 例如： @EnableFeignClients(basePackages = "com.example.clients")
 * 或明确列出它们： @EnableFeignClients(clients = InventoryServiceFeignClient.class)
 */
//@EnableFeignClients
//@EnableFeignClients(basePackages = {"com.spring.demo.client"})
@EnableFeignClients(clients = {TestClient.class})
@EnableCaching
@ConfigurationPropertiesScan
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}, scanBasePackages = {"com.spring.demo"})
public class FeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class);
    }
}