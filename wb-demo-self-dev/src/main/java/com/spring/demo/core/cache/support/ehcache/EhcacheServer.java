package com.spring.demo.core.cache.support.ehcache;

import com.spring.demo.core.cache.support.CacheServer;
import com.spring.demo.core.cache.support.ehcache.condition.EhcacheCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service(value = "ehcacheServeImpl")
//@Conditional({EhcacheCondition.class})
@RequiredArgsConstructor
public class EhcacheServer implements CacheServer {

    @Override
    public void setObject(String key, Object value) {
        EhCacheUtils.put(key, value);
    }

    @Override
    public void setObject(String key, Object value, int expireTime) {
        EhCacheUtils.put(key, value, expireTime);
    }

    @Override
    public void setObject(String key, Object value, int expireTime, TimeUnit minutes) {
        EhCacheUtils.put(key, value, expireTime, minutes);
    }

    @Override
    public <T> T getObject(String key) {
        return EhCacheUtils.get(key);
    }

    @Override
    public boolean deleteObject(String key) {
        return EhCacheUtils.delete(key);
    }

    @Override
    public boolean hasKey(String key) {
        return EhCacheUtils.hasKey(key);
    }

    @Override
    public boolean expire(String key, long timeout) {
        return false;
    }

    @Override
    public boolean expire(String key, long timeout, TimeUnit unit) {
        return false;
    }

    @Override
    public long getExpire(String key) {
        return 0;
    }
}