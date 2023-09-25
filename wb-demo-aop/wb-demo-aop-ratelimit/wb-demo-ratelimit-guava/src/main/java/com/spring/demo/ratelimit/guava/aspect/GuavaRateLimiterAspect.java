package com.spring.demo.ratelimit.guava.aspect;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.spring.demo.ratelimit.guava.annotation.RateLimiter;
import com.spring.demo.ratelimit.guava.exception.RateLimiterException;
import com.spring.demo.ratelimit.guava.util.IpUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 限流切面
 */
@Slf4j
@Aspect
@Component
public class GuavaRateLimiterAspect {
    private final static String SEPARATOR = ":";
    private static final ConcurrentMap<String, com.google.common.util.concurrent.RateLimiter> RATE_LIMITER_CACHE = new ConcurrentHashMap<>();

    @Pointcut("@annotation(com.spring.demo.ratelimit.guava.annotation.RateLimiter)")
    public void guavaRateLimiter() {
    }

    @Around("guavaRateLimiter()")
    public Object pointcut(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        // 通过 AnnotationUtils.findAnnotation 获取 RateLimiter 注解
        RateLimiter rateLimiter = AnnotationUtils.findAnnotation(method, RateLimiter.class);
        if (rateLimiter != null && rateLimiter.qps() > RateLimiter.NOT_LIMITED) {
            double qps = rateLimiter.qps();
            String key = method.getName() + SEPARATOR + IpUtil.getIpAddr();
            if (RATE_LIMITER_CACHE.get(key) == null) {
                // 初始化 QPS
                RATE_LIMITER_CACHE.put(key, com.google.common.util.concurrent.RateLimiter.create(qps));
            }

            log.debug("【{}】的QPS设置为: {}", key, RATE_LIMITER_CACHE.get(key).getRate());
            // 尝试获取令牌
            // 从RateLimiter 获取许可如果该许可可以在不超过timeout的时间内获取得到的话，或者如果无法在timeout 过期之前获取得到许可的话，那么立即返回false（无需等待）
            boolean tryAcquire = RATE_LIMITER_CACHE.get(key).tryAcquire(rateLimiter.timeout(), rateLimiter.timeUnit());
            if (RATE_LIMITER_CACHE.get(key) != null && !tryAcquire) {
                throw new RateLimiterException("手速太快了，慢点儿吧~");
            }
        }
        return point.proceed();
    }
}
