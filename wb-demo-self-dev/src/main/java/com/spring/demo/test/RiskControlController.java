package com.spring.demo.test;


import cn.hutool.core.util.RandomUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.spring.demo.ResponseResult;
import com.spring.demo.core.annotation.Anonymous;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/riskControlApi")
public class RiskControlController {


    @Anonymous
    @PostMapping(value = "/getPlan")
    ResponseResult<List<Map<String, String>>> getRiskControlPlan(@RequestHeader(value = "Authorization", required = false) String Authorization, @RequestHeader(value = "Token", required = false) String Token) {
        List<Map<String, String>> maps = Lists.newArrayList();
        Arrays.asList("110000", "120000", "140000").stream().forEach(e -> {
            Map<String, String> RESULT = Maps.newHashMap();
            RESULT.put("weekPlanNum", String.valueOf(RandomUtil.randomInt(2012, 54454)));
            RESULT.put("dayPlanNum", String.valueOf(RandomUtil.randomInt(5000, 54454)));
            RESULT.put("provinceCode", e);
            maps.add(RESULT);
        });

        return ResponseResult.successResult(maps);
    }

        public static void main(String[] args) {
            double target = 193250.0;

            for (double x = 1.0; x < target; x++) {
                for (double y = 1.0; y < target; y++) {
                    double result = 60.0 * x + 150.0 * y;
                    if (Math.abs(result - target) < 1e-6) {
                        System.out.println("x = " + x + ", y = " + y);
                    }
                }
            }
        }
}