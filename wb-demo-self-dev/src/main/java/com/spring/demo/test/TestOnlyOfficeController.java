package com.spring.demo.test;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: 自己的名字
 * @description:
 * @date: 2023-09-28 15:46
 */
public class TestOnlyOfficeController {


    @PostMapping(value = "/geDayPlan")
    public Map get(@RequestBody Map map) {
        List<Map<String, String>> result = new ArrayList<>();

        Map<String, String> stringStringMap = new HashMap<String, String>() {{
            put("110000", "641");
        }};

        return stringStringMap;
    }
}