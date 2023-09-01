package com.spring.demo.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @GetMapping("/test")
    public Map<String,String> test(){
        return new HashMap<String,String>(){{
            put("q2w", "sf");
        }};
    }
}