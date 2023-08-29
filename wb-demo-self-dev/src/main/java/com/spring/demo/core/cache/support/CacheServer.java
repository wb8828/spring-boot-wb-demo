package com.spring.demo.core.cache.support;

import java.util.concurrent.TimeUnit;

public interface CacheServer {

    void setObject(String key, Object object);

    void setObject(String key, Object object, int expireTime);

    void setObject(String key, Object object, int expireTime, TimeUnit minutes);

    <T> T getObject(String key);

    void deleteObject(String key);

    boolean hasKey(String key);
}