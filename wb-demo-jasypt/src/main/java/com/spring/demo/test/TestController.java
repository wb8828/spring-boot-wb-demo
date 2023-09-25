package com.spring.demo.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试
 */
@RestController
@RequestMapping(value = "/test/jasypt")
public class TestController {

    @Value("${test.v1}")
    private String v1;

    @GetMapping("/get")
    public Map<String, String> get() {
        return new HashMap<String, String>() {{
            put("获取的未解密后的配置文件", v1);
        }};
    }
}