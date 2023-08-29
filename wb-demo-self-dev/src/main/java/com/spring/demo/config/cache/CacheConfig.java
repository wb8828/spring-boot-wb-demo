package com.spring.demo.config.cache;

import com.spring.demo.config.properties.SysConfig;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
public class CacheConfig {

    private final SysConfig sysConfig;



}