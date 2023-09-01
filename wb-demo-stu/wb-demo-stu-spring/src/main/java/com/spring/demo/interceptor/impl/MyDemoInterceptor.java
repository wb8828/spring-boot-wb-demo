package com.spring.demo.interceptor.impl;

import com.spring.demo.interceptor.MyInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: 拦截器试验类
 * @description:
 * @date: 2023-08-31 10:03
 */
@Component
public class MyDemoInterceptor extends MyInterceptor {

    private static final Logger log = LoggerFactory.getLogger(MyDemoInterceptor.class);

    @Override
    public boolean isPassThrough(HttpServletRequest request, HttpServletResponse response, Object handle) {
        log.info("拦截器逻辑处理");
        return true;
    }
}