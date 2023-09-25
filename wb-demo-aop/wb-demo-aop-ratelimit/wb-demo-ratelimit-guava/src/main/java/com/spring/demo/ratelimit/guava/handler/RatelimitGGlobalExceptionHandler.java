package com.spring.demo.ratelimit.guava.handler;

import cn.hutool.core.lang.Dict;
import com.spring.demo.ratelimit.guava.exception.RateLimiterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常拦截
 */
@RestControllerAdvice
public class RatelimitGGlobalExceptionHandler {

    @ExceptionHandler(RateLimiterException.class)
    public Dict handler(RateLimiterException ex) {
        return Dict.create().set("msg", ex.getMessage());
    }
}
