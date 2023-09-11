package com.spring.demo.ratelimit.redis.handler;

import cn.hutool.core.lang.Dict;
import com.spring.demo.ratelimit.redis.exception.RateLimiterException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常拦截
 */
@Slf4j
@RestControllerAdvice
@Order(value = -111)
public class RedisRateLimiterGlobalExceptionHandler {

    @ExceptionHandler(RateLimiterException.class)
    public Dict handler(RateLimiterException ex) {
        return Dict.create().set("msg", ex.getMessage());
    }
}
