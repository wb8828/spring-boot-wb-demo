package com.spring.demo.core.cache.support.redis.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class RedisCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata metadata) {
        String cacheType = conditionContext.getEnvironment().getProperty("spring.cache.type");
        return "redis".equals(cacheType);
    }
}