package com.spring.demo.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.spring.demo.pojo.entity.TestUser;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: wb
 * @description: 测试redis注解服务层
 */
@Service
public class DemoRedisService {
    /**
     * 模拟数据库
     */
    private static final Map<Long, TestUser> DATABASES = Maps.newConcurrentMap();
    private static final List<Map<String, String>> SEX = Lists.newArrayList();

    // 初始化数据
    static {
        DATABASES.put(1L, new TestUser(1L, "user1"));
        DATABASES.put(2L, new TestUser(2L, "user2"));
        DATABASES.put(3L, new TestUser(3L, "user3"));

        SEX.add(new HashMap<String, String>() {{
            put("LABEL", "男");
            put("VALUE", "0");
        }});
        SEX.add(new HashMap<String, String>() {{
            put("LABEL", "女");
            put("VALUE", "1");
        }});
        SEX.add(new HashMap<String, String>() {{
            put("LABEL", "其他");
            put("VALUE", "3");
        }});
    }

    public Map<Long, TestUser> query() {
        return DATABASES;
    }

    /**
     * 获取性别下拉框
     */
    @Cacheable(value = "getSexBox", keyGenerator = "normalKeyGenerator", cacheManager = "normalCacheManager")
    public List<Map<String, String>> getSexBox() {
        return SEX;
    }


    /**
     * 保存或修改用户
     */
    @CachePut(value = "user", key = "#user.id", cacheManager = "normalCacheManager")
    public TestUser saveOrUpdate(TestUser user) {
        DATABASES.put(user.getId(), user);
        return user;
    }

    /**
     * 获取用户
     */
    @Cacheable(value = "user", key = "#id", cacheManager = "normalCacheManager")
    public TestUser get(Long id) {
        // 我们假设从数据库读取
        return DATABASES.get(id);
    }

    /**
     * 删除用户
     */
    @CacheEvict(value = "user", key = "#id", cacheManager = "normalCacheManager")
    public void delete(Long id) {
        DATABASES.remove(id);
    }
}