package com.spring.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "test1", url = "http://127.0.0.1:8085/wb-demo")
public interface TestClient {

    @PostMapping(value = "/home/countData")
    Map testDynamicUrl(@RequestBody Map<String, String> map);
}