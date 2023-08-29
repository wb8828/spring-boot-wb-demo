package com.spring.demo.config;

import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: wb
 * @description:
 * @date: 2023-04-19 13:44
 */
public class WebConfig implements WebMvcConfigurer {

    // 所有的接口添加 api 前缀
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix("api", c -> true);
    }
}