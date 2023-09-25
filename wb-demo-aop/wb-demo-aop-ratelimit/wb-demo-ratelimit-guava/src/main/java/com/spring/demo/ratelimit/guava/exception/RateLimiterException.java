package com.spring.demo.ratelimit.guava.exception;

/**
 * 限流自定义异常
 */
public class RateLimiterException extends RuntimeException {
    public RateLimiterException(String message) {
        super(message,null,false,false);
    }
}