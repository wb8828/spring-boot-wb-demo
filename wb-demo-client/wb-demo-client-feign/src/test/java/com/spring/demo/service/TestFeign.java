package com.spring.demo.service;

import com.spring.demo.SpringBootTests;
import com.spring.demo.client.TestClient;
import com.spring.demo.support.AjaxResult;
import com.spring.demo.support.Params;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class TestFeign extends SpringBootTests {

    private static final Map<String, String> map = new HashMap<String, String>() {{
        put("code", "book_0");
    }};
    @Autowired
    private TestClient testClient;

    @Test
    public void test1() {
        AjaxResult result = testClient.test1(map);
        log.info("返回值:{}", result);
    }

    @Test
    public void test2() {

        AjaxResult result = testClient.test2("sdfasdfasfa", map);
        log.info("返回值:{}", result);
    }

    @Test
    public void test3() {

        AjaxResult result = testClient.test3("sdfasdfasfa");
        log.info("返回值:{}", result);
    }

    @Test
    public void test4() {
        Params params = Params.builder().params1("1").params2("2").params4("4").build();
        AjaxResult result = testClient.test4(params);
        log.info("返回值:{}", result);
    }
}