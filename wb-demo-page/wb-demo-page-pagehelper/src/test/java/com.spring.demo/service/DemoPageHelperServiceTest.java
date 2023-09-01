package com.spring.demo.service;


import com.spring.demo.SpringBootTests;
import com.spring.demo.test.service.ITestPageHelperService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class DemoPageHelperServiceTest extends SpringBootTests {

    @Autowired
    private ITestPageHelperService testPageHelperService;

    @Test
    public void query() {
        List<Map<String, String>> list = testPageHelperService.queryPage(1, 50);
        System.out.println(list);
    }

}