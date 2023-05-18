package com.spring.demo.generator.controller;

import cn.hutool.core.util.RandomUtil;
import com.spring.demo.BaseController;
import com.spring.demo.generator.service.IGeneratorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping(value = "/generator")
@RestController
@AllArgsConstructor
@Slf4j
public class GeneratorController extends BaseController {

    private final IGeneratorService generatorService;

    @GetMapping("/getRandomMes/{num}")
    public List<Map<String, String>> getRandomMes(@PathVariable(value = "num", required = false) Integer num) {
        num = num == null ? RandomUtil.randomInt(1, 500) : num;

        return generatorService.getRandomMes(num);
    }
}