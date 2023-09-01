package com.spring.demo.core.cache.support.ehcache;

import lombok.extern.slf4j.Slf4j;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import java.util.concurrent.TimeUnit;

/**
 * ehcache缓存操作工具类
 */
@Slf4j
public final class EhCacheUtils {
    private static final String CACHE_NAME = "myCache";
    private static Cache cache;

    static {
        CacheManager cacheManager = CacheManager.getInstance();
        cacheManager.addCacheIfAbsent(CACHE_NAME);
        cache = cacheManager.getCache(CACHE_NAME);
    }

    /**
     * 添加缓存数据
     */
    public static void put(String key, Object value) {
        Element element = new Element(key, value);
        cache.put(element);
    }

    public static void put(String key, Object value, int timeout) {
        Element element = new Element(key, value);
        element.setEternal(false);
        element.setTimeToLive(timeout);
        element.setTimeToIdle(timeout);

        cache.put(element);
    }

    public static void put(String key, Object value, long timeToLive, TimeUnit timeUnit) {
        Element element = new Element(key, value);
        long timeToLiveSeconds = TimeUnit.SECONDS.convert(timeToLive, timeUnit);
        element.setTimeToLive((int) timeToLiveSeconds);
        cache.put(element);
    }

    /**
     * 获取缓存数据
     */
    public static <T> T get(String key) {
        Element element = cache.get(key);
        return element != null ? (T) element.getObjectValue() : null;
    }

    /**
     * 删除缓存数据
     */
    public static boolean delete(String key) {
        return cache.remove(key);
    }

    public static void deleteAll() {
        cache.removeAll();
    }

    public static int getSize() {
        return cache.getSize();
    }

    public static void dispose() {
        CacheManager.getInstance().shutdown();
    }

    /**
     * 判断是否有次缓存
     */
    public static boolean hasKey(String key) {
        return cache.isKeyInCache(key);
    }
}