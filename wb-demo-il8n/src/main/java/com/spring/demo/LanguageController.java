package com.spring.demo;

import com.spring.demo.util.LocaleUtils;
import com.spring.demo.util.MessageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@Slf4j
public class LanguageController {

    /**
     * 切换语言环境
     */
    @GetMapping("/changeLanguages/{lang}")
    public AjaxResult changeLanguages(@PathVariable(value = "lang") String lang) {
        Locale locale = LocaleUtils.stringToLocale(lang);
        LocaleContextHolder.setLocale(locale);
        return AjaxResult.success();
    }

    /**
     * 测试国际化接口--后端根据前端设置的语言返回相应语言的文字
     */
    @GetMapping("/testLanguages")
    public AjaxResult test() {
//        Locale locale = LocaleContextHolder.getLocale();
        return AjaxResult.success(MessageUtils.message("addSuccess"));
    }

//    /**
//     * 测试国际化接口--后端根据前端设置的语言返回相应语言的文字
//     */
//    @GetMapping("/testLanguages1")
//    public AjaxResult test1() {
//        MessageSource messageSource = SpringUtil.getBean(MessageSource.class);
//        return AjaxResult.success(messageSource.getMessage("addSuccess", new Object[0], LocaleContextHolder.getLocale()));
//    }
}