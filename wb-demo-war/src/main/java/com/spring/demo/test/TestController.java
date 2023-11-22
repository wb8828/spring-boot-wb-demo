package com.spring.demo.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/test/war")
public class TestController {

    @Value(value = "${wb.test}")
    private String test;

    @GetMapping("/get")
    public String get() {
        return "it is war" + LocalDateTime.now().toString();
    }

    @GetMapping("/test")
    public String test() {
        return test;
    }
}