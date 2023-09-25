package com.spring.demo.test;

import com.alibaba.fastjson.JSON;
import com.spring.demo.demo.Hyposensitization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/test/stu")
public class TestController {

    /**
     * 测试序列化形式脱敏
     */
    @GetMapping("/hyposensitization")
    public List<Hyposensitization> hyposensitization() {
        List<Hyposensitization> hyposensitizations = hyposensitizationData();

        log.info(JSON.toJSONString(hyposensitizations));
        return hyposensitizations;
    }


    private List<Hyposensitization> hyposensitizationData() {
        return new ArrayList<Hyposensitization>() {{
            add(Hyposensitization.builder().name("张三").phone("17862453546").build());
            add(Hyposensitization.builder().name("李四").phone("13954621544").build());
            add(Hyposensitization.builder().name("王五").phone("17745627894").build());
        }};
    }
}