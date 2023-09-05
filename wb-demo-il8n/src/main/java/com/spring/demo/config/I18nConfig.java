package com.spring.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

public class I18nConfig {

    @Bean
    public LocaleResolver customLocaleResolver() {
        return new CustomLocaleResolver();
    }


//    /**
//     * 默认拦截器 其中lang表示切换语言的参数名
//     */
//    @Bean
//    public WebMvcConfigurer localeInterceptor() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
//                localeInterceptor.setParamName("lang");
//                registry.addInterceptor(localeInterceptor);
//            }
//        };
//    }
}