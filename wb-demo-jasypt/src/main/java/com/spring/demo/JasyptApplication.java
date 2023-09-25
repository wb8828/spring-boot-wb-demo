package com.spring.demo;

import com.ulisesbocchio.jasyptspringboot.annotation.EncryptablePropertySource;
import com.ulisesbocchio.jasyptspringboot.annotation.EncryptablePropertySources;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cache.annotation.EnableCaching;


// 指定配置文件作用域，其他配置文件不受影响
@EncryptablePropertySources({
        @EncryptablePropertySource(value = "classpath:application.yml"),
        @EncryptablePropertySource(value = "classpath:test.yml")
})
@ConfigurationPropertiesScan
@EnableCaching
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}, scanBasePackages = {"com.spring.demo"})
public class JasyptApplication {
    public static void main(String[] args) {
        SpringApplication.run(JasyptApplication.class);
    }
}