package com.spring.demo.core.cache.support.redis;

import com.spring.demo.core.cache.support.CacheServer;
import com.spring.demo.core.cache.support.redis.condition.RedisCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component(value = "redisServeImpl")
@Conditional({RedisCondition.class})
public class RedisCacheServer implements CacheServer {
    @Autowired
    private RedisUtils redisUtils;

    @Override
    public void setObject(String key, Object object) {
        redisUtils.setCacheObject(key, object);
    }

    @Override
    public void setObject(String key, Object object, int expireTime) {
        setObject(key, object, expireTime, TimeUnit.MILLISECONDS);
    }

    @Override
    public void setObject(String key, Object object, int expireTime, TimeUnit minutes) {
        redisUtils.setCacheObject(key, object, expireTime, minutes);
    }

    @Override
    public <T> T getObject(String key) {
        return redisUtils.getCacheObject(key);
    }

    @Override
    public void deleteObject(String key) {
        redisUtils.deleteObject(key);
    }

    @Override
    public boolean hasKey(String key) {
        return redisUtils.hasKey(key);
    }
}