package com.spring.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;

public class I18nConfig {

    @Bean
    public LocaleResolver customLocaleResolver() {
        return new CustomLocaleResolver();
    }
}