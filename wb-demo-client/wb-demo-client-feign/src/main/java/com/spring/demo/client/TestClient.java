package com.spring.demo.client;

import com.spring.demo.interceptor.TokenInterceptor;
import com.spring.demo.support.AjaxResult;
import com.spring.demo.support.Params;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

@FeignClient(name = "test", url = "http://127.0.0.1:8086/wb-demo/test/feign", configuration = {TokenInterceptor.class})
public interface TestClient {
    /**
     * 最简单的请求
     */
    @PostMapping(value = "/test1")
    AjaxResult test1(@RequestBody Map<String, String> map);

    /**
     * 直接在方法中传递请求头
     */
    @PostMapping(value = "/test2", consumes = "application/json")
    AjaxResult test2(@RequestHeader("Authorization") String token, @RequestBody Map<String, String> map);

    /**
     * #a0 代表第一个参数
     * 可以通过spring.cloud.openfeign.cache.enabled=false禁用缓存
     *
     * @param keyParam 参数
     */
    @GetMapping(value = "/test3")
    @Cacheable(cacheNames = "demo-cache", key = "#a0")
    AjaxResult test3(String keyParam);

    /**
     * 注解，用于将POJO或Map参数注解为查询参数map。
     */
    @GetMapping(path = "/test4")
    AjaxResult test4(@SpringQueryMap Params params);
}