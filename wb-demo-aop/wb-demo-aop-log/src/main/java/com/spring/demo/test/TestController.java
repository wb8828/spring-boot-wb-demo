package com.spring.demo.test;

import com.spring.demo.annotation.Log;
import com.spring.demo.support.enums.BusinessType;
import com.spring.demo.support.enums.OperatorType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test/log")
public class TestController {

    @GetMapping()
    @Log(title = "测试", businessType = BusinessType.QUERY, operatorType = OperatorType.OTHER)
    public void test1() {
        log.info("进入接口");
    }
}