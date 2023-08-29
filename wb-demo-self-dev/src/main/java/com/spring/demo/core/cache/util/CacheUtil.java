package com.spring.demo.core.cache.util;

import com.spring.demo.core.cache.support.CacheServer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CacheUtil implements InitializingBean, ApplicationContextAware {

    private static Map<String, CacheServer> cacheServerHashMap = new HashMap<>();
    private ApplicationContext applicationContext;

    public CacheServer cacheManager(String type) {
        String serverName = type.substring(0, 1).toUpperCase() + type.substring(1);
        CacheServer userReader = cacheServerHashMap.get(serverName + "Server");
        if (userReader == null) {
            return cacheServerHashMap.get("RedisCacheServer");
        }
        return userReader;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, CacheServer> beanMap = applicationContext.getBeansOfType(CacheServer.class);
        //遍历该接口的所有实现，将其放入map中
        for (CacheServer serviceImpl : beanMap.values()) {
            cacheServerHashMap.put(serviceImpl.getClass().getSimpleName(), serviceImpl);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}