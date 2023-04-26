package com.spring.demo.system.dict.controller;

import com.spring.demo.AjaxResult;
import com.spring.demo.BaseController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字典服务控制器
 */

@RestController
@RequestMapping("/system/dict")
public class DictController extends BaseController {


    @GetMapping("/data/type/{dictType}")
    public AjaxResult dictType(@PathVariable String dictType) {
        if (StringUtils.equals("openLombok", dictType)) {

        }
        Map<String, String> map = new HashMap<>();
        map.put("value", "121");
        map.put("label", "正式");
        List<Map<String, String>> RE = new ArrayList<>();
        RE.add(map);
        return AjaxResult.success(RE);
    }
}