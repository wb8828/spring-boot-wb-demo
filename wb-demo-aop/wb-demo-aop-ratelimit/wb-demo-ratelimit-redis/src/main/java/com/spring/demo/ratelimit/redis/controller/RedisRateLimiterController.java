package com.spring.demo.ratelimit.redis.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/redis_rateLimiter")
public class  RedisRateLimiterController {
}