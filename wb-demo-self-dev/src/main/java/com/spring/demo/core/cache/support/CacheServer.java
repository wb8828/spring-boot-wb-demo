package com.spring.demo.core.cache.support;

import java.util.concurrent.TimeUnit;

public interface CacheServer {

    void setObject(String key, Object object);

    void setObject(String key, Object object, int expireTime);

    void setObject(String key, Object object, int expireTime, TimeUnit minutes);

    <T> T getObject(String key);

    boolean deleteObject(String key);

    boolean hasKey(String key);

    /**
     * 设置有效时间
     *
     * @param key     Redis键
     * @param timeout 超时时间
     * @return true=设置成功；false=设置失败
     */
    public boolean expire(final String key, final long timeout);

    /**
     * 设置有效时间
     *
     * @param key     Redis键
     * @param timeout 超时时间
     * @param unit    时间单位
     * @return true=设置成功；false=设置失败
     */
    public boolean expire(final String key, final long timeout, final TimeUnit unit);

    /**
     * 获取有效时间
     *
     * @param key Redis键
     * @return 有效时间
     */
    public long getExpire(final String key);

}