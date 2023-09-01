package com.spring.demo.core.cache.support.redis;

import com.spring.demo.core.cache.support.CacheServer;
import com.spring.demo.core.cache.support.redis.condition.RedisCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@SuppressWarnings(value = {"rawtypes"})
@Service(value = "redisServeImpl")
//@Conditional({RedisCondition.class})
@RequiredArgsConstructor
@Primary
public class RedisCacheServer implements CacheServer {

    private final RedisTemplate redisTemplate;

    @Override
    public void setObject(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void setObject(String key, Object object, int expireTime) {
        setObject(key, object, expireTime, TimeUnit.MILLISECONDS);
    }

    @Override
    public void setObject(String key, Object value, int expireTime, TimeUnit minutes) {
        redisTemplate.opsForValue().set(key, value, expireTime, minutes);
    }

    @Override
    public <T> T getObject(String key) {
        ValueOperations<String, T> operation = redisTemplate.opsForValue();
        return operation.get(key);
    }

    @Override
    public boolean deleteObject(String key) {
        return redisTemplate.delete(key);
    }

    @Override
    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    @Override
    public boolean expire(String key, long timeout) {
        return expire(key, timeout, TimeUnit.SECONDS);
    }

    @Override
    public boolean expire(String key, long timeout, TimeUnit unit) {
        return redisTemplate.expire(key, timeout, unit);
    }

    @Override
    public long getExpire(String key) {
        return redisTemplate.getExpire(key);
    }
}