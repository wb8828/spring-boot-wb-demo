package com.spring.demo.config;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

/**
 * @author: wb
 * @description: 统一异常处理
 * 当有多个异常通知时，匹配顺序为当前类及其⼦类向上依次匹配
 * @date: 2023-04-19 15:29
 */
@RestControllerAdvice // 当前是针对 Controller 的通知类（增强类）
public class MyExceptionAdvice {


    @ExceptionHandler(ArithmeticException.class)
    public HashMap<String, Object> arithmeticExceptionAdvice(ArithmeticException e) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("state", -1);
        result.put("data", null);
        result.put("msg", "算出异常：" + e.getMessage());
        return result;
    }

    @ExceptionHandler(NullPointerException.class)
    public HashMap<String, Object> nullPointerExceptionAdvice(NullPointerException e) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("state", -1);
        result.put("data", null);
        result.put("msg", "空指针异常异常：" + e.getMessage());
        return result;
    }

    @ExceptionHandler(Exception.class)
    public HashMap<String, Object> exceptionAdvice(Exception e) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("state", -1);
        result.put("data", null);
        result.put("msg", "异常：" + e.getMessage());
        return result;
    }
}