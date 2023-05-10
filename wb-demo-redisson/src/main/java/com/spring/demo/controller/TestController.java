package com.spring.demo.controller;

import com.spring.demo.util.RedisLockUtil;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author: wb
 * @description:
 * @date: 2023-04-10 15:43
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private RedisLockUtil redisLockUtil;


    @GetMapping("/getIcode/{id}")
    public String getIcode(@PathVariable(value = "id") String id) {
        RLock icode = redisLockUtil.lock(id, "icode", 50000, 50, 10000);
        boolean locked = icode.isLocked();
        System.out.println("是否有进程正在获取实物ID" + locked);


        for (int i = 0; i < 200 ; i++) {

        }
        redisLockUtil.unlock(id, "icode");;
        return "1";
    }

    @GetMapping("/getF")
    public String getF() {
        return "F";
    }
}