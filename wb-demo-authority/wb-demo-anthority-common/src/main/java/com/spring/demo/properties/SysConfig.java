package com.spring.demo.properties;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "wbSysConfig")
@Getter
@Setter
//@PropertySource(name = "isc", value = "classpath:prem.yml", factory = YamlPropertySourceFactory.class)
public class SysConfig {


    /**
     * 业务应用ID
     */
    @Value("${sys.captcha.enabled:true}")
    private boolean captchaEnabled = true;


    @Value("${sys.captcha.captchaType:'math'}")
    private String captchaType;

    @Value("${spring.cache.type:'ehcache'}")
    private String cacheType;


    @Value("${sys.env:'dev'}")
    private String env;
}