package com.spring.demo.prop;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("yy")
public class YYProp {
    private String personPath;
    private String sendMes;

}