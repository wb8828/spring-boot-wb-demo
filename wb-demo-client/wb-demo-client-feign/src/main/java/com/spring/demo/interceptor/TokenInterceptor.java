package com.spring.demo.interceptor;

import cn.hutool.core.util.StrUtil;
import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.Target;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;

/**
 * 通过拦截器的形式增加请求头
 */
@Slf4j
public class TokenInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("_at", "qwwrersfd");
        requestTemplate.query("signature", "wb");

        String body = StrUtil.str(requestTemplate.body(), "UTF-8");
        Target<?> target = requestTemplate.feignTarget();
        log.info("name-url:{}-{}，queries:{},headers：{},body:{}", target.name(), target.url(), requestTemplate.queries(), requestTemplate.headers(), body);

    }

    @Bean
    Logger.Level feignLevel() {
        return Logger.Level.FULL;
    }
}