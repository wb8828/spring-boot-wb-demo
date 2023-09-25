package com.spring.demo.config;


import feign.Logger;
import feign.QueryMapEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class FeignConfig {

    /**
     * NONE, 没日志（默认）。
     * BASIC, 只记录请求方法和URL以及响应状态代码和执行时间。
     * HEADERS, 记录基本信息以及请求和响应头。
     * FULL, 记录请求和响应的header、正文和元数据。
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }


//    @Bean
//    public QueryMapEncoder queryMapEncoder() {
//        return new QueryMapEncoder() {
//            @Override
//            public Map<String, Object> encode(Object o) {
//                return null;
//            }
//        };
//    }
}