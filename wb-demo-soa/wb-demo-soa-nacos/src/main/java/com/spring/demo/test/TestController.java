package com.spring.demo.test;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/test/nacos")
@Slf4j
public class TestController {

    @GetMapping(value = "")
    public String test() {
        log.info("微服务调用成功");
        return "微服务调用成功" + LocalDateTime.now();
    }
}