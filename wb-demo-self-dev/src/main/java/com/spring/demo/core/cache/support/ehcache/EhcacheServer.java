package com.spring.demo.core.cache.support.ehcache;

import com.spring.demo.core.cache.support.CacheServer;
import com.spring.demo.core.cache.support.ehcache.condition.EhcacheCondition;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component(value = "ehcacheServeImpl")
@Conditional({EhcacheCondition.class})
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
    public void deleteObject(String key) {
        EhCacheUtils.delete(key);
    }

    @Override
    public boolean hasKey(String key) {
        return EhCacheUtils.hasKey(key);
    }
}