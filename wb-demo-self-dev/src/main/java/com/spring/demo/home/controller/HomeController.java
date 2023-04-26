package com.spring.demo.home.controller;

import cn.hutool.core.util.RandomUtil;
import com.spring.demo.AjaxResult;
import com.spring.demo.BaseController;
import com.spring.demo.home.dto.CountDataDTO;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RequestMapping(value = "/home")
@RestController
public class HomeController extends BaseController {


    @ConditionalOnProperty(name = "type", prefix = "int", havingValue = "123")
    @GetMapping("/loginUserInfo")
    public AjaxResult loginUserInfo() {
        Map<String, Object> result = new HashMap<>();
        result.put("name", "Admin");
        result.put("access", "管理员");
        result.put("time", LocalDate.now().toString());
        result.put("addr", "山东省济南市");
        return AjaxResult.success(result);
    }

    @ConditionalOnProperty(name = "type", prefix = "int", havingValue = "456")
    @GetMapping("/loginUserInfo2")
    public AjaxResult loginUserInfo1() {
        Map<String, Object> result = new HashMap<>();
        result.put("name", "Admin");
        result.put("access", "管理员");
        result.put("time", LocalDate.now().toString());
        result.put("addr", "山东省济南市");
        return AjaxResult.success(result);
    }

    @GetMapping("/tableData")
    public AjaxResult tableData() {
        List<Map<String, Object>> result = new ArrayList<>();

        String[] names = {"oppo", "一加", "小米", "魅族", "苹果"};
        Arrays.stream(names).forEach(e -> {
            Map<String, Object> map = new HashMap<>();
            map.put("name", e);
            map.put("todayBuy", RandomUtil.randomInt(0, 100));
            map.put("monthBuy", RandomUtil.randomInt(200, 500));
            map.put("totalBuy", RandomUtil.randomInt(800, 1000));
            result.add(map);
        });
        return AjaxResult.success(result);
    }

    @PostMapping("/countData")
    public AjaxResult countData(@RequestBody CountDataDTO countDataDTO) {
        List<Map<String, Object>> result = new ArrayList<>();

        Map<String, Object> map = new HashMap<>();
        map.put("name", "今日支付订单");
        map.put("value", RandomUtil.randomInt(200, 300));
        map.put("icon", "success");
        map.put("color", "#2ec7c9");
        result.add(map);

        map = new HashMap<>();
        map.put("name", "今日收藏订单");
        map.put("value", RandomUtil.randomInt(200, 300));
        map.put("icon", "star-on");
        map.put("color", "#ffb980");
        result.add(map);

        map = new HashMap<>();
        map.put("name", "今日未支付订单");
        map.put("value", RandomUtil.randomInt(200, 300));
        map.put("icon", "s-goods");
        map.put("color", "#5ab1ef");
        result.add(map);

        map = new HashMap<>();
        map.put("name", "本月支付订单");
        map.put("value", RandomUtil.randomInt(400, 700));
        map.put("icon", "success");
        map.put("color", "#2ec7c9");
        result.add(map);

        map = new HashMap<>();
        map.put("name", "本月收藏订单");
        map.put("value", RandomUtil.randomInt(400, 700));
        map.put("icon", "star-on");
        map.put("color", "#ffb980");
        result.add(map);

        map = new HashMap<>();
        map.put("name", "本月未支付订单");
        map.put("value", RandomUtil.randomInt(400, 800));
        map.put("icon", "s-goods");
        map.put("color", "#5ab1ef");
        result.add(map);
        return AjaxResult.success(result);
    }
}