package com.spring.demo.core.cache.support.ehcache.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class EhcacheCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata metadata) {
        String cacheType = conditionContext.getEnvironment().getProperty("spring.cache.type");
        return "ehcache".equals(cacheType);
    }
}