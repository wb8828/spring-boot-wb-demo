package com.spring.demo.config.cache;

import com.spring.demo.config.properties.SysConfig;
import com.spring.demo.core.cache.support.CacheServer;
import com.spring.demo.core.cache.support.ehcache.EhcacheServer;
import com.spring.demo.core.cache.support.redis.RedisCacheServer;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

@AllArgsConstructor
@Configuration
public class CacheConfig {

    private final SysConfig sysConfig;

    @Bean
//    @ConditionalOnProperty(name = "type", prefix = "spring.cache", havingValue = "redis")
    public CacheServer redisCacheServer(RedisTemplate redisTemplate) {
        if (StringUtils.equals(sysConfig.getCacheType(), "ehcache")) {
            return new EhcacheServer();
        } else if (StringUtils.equals(sysConfig.getCacheType(), "redis")) {
            return new RedisCacheServer(redisTemplate);
        }
        return null;
    }

//    @Bean
//    @ConditionalOnProperty(name = "type", prefix = "spring.cache", havingValue = "ehcache")
//    public CacheServer ehcacheServer() {
//        return new EhcacheServer();
//    }
}