package com.spring.demo.view.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ViewController {

    @GetMapping("/toWechatView")
    public String toWechatView() {
        return ViewConstant.PREFIX + "/wechat/index";
    }

    @GetMapping("/toRevenueView")
    public String toRevenueView() {
        log.info("跳转财税顾问表格页面");
        return ViewConstant.PREFIX + "/revenue/index";
    }

    public static class ViewConstant {
        public static final String PREFIX = "page";

    }
}