package com.spring.demo.service;

import com.spring.demo.SpringBootTests;
import com.spring.demo.pojo.entity.TestUser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: 自己的名字
 * @description:
 * @date: 2023-04-21 17:22
 */
public class DemoRedisServiceTest extends SpringBootTests {

    @Autowired
    private DemoRedisService demoRedisService;

    @Test
    public void getSex() {
        demoRedisService.getSexBox();
    }

    @Test
    public void saveOrUpdate() {
        TestUser testUser = new TestUser(4L, "user4");
        demoRedisService.saveOrUpdate(testUser);
    }

    @Test
    public void delete() {
        demoRedisService.delete(4L);
    }

}