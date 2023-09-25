package com.spring.demo.test;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.spring.demo.AjaxResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping(value = "/test/feign")
public class TestFeignController {


    @PostMapping("/test1")
    public AjaxResult test1(@RequestBody Map<String, String> map, HttpServletRequest request) {
        AjaxResult success = AjaxResult.success();
        success.put("msg", "feign调用成功");
        success.put("Authorization", "没有带着TOKEN");
        success.put("_at", request.getHeader("_at"));
        success.put("signature", request.getParameter("signature"));

        return success;
    }

    @PostMapping("/test2")
    public AjaxResult test2(@RequestBody Map<String, String> map, HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        AjaxResult success = AjaxResult.success();
        success.put("msg", "feign调用成功");
        success.put("Authorization", StrUtil.format("带着TOKEN{}:", authorization));
        success.put("_at", request.getHeader("_at"));
        success.put("signature", request.getParameter("signature"));
        return success;
    }

    @PostMapping("/test3")
    public AjaxResult test3(String s) {
        AjaxResult success = AjaxResult.success();
        success.put("msg", "feign调用成功");
        success.put("data", RandomUtil.randomString(33));
        return success;
    }
    @GetMapping("/test4")
    public AjaxResult test4( HttpServletRequest request) {
        AjaxResult success = AjaxResult.success();
        success.put("msg", "feign调用成功");
        success.put("params1", request.getParameter("params1"));
        success.put("params2", request.getParameter("params2"));
        success.put("params3", request.getParameter("params3"));
        success.put("params4", request.getParameter("params4"));
        return success;
    }
}