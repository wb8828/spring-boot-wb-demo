package com.spring.demo.service;

import com.spring.demo.SpringBootTests;
import com.spring.demo.client.TestClient;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class TestFeign extends SpringBootTests {

    @Autowired
    private TestClient testClient;

    @Test
    public void testDynamicUrl() throws URISyntaxException {
//        URI uri = new URI("http://192.168.12.247:8085/wb-demo/getRouters");
        Map<String, String> map = new HashMap<String, String>() {{
            put("code", "book_0");
        }};
        Map result = testClient.testDynamicUrl(map);
        System.out.println(result);
    }
}