package com.spring.demo.ratelimit.redis.properties;


import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@ConfigurationProperties(
        prefix = "ratelimit",
        ignoreUnknownFields = true
)
public class RedisRatelimitProperties {

    /**
     * 是否开启接口限流
     */
    private final boolean enabled;
    /**
     * 是否记录被拦截的请求
     */
    private final Records records;

    public RedisRatelimitProperties() {
        this.enabled = true;
        this.records = new Records();
    }

    @Getter
    public static class Records {
        private final boolean enabled;

        private final String group;

        private final String appName;

        public Records() {
            this.enabled = false;
            this.group = "default";
            this.appName = "默认应用";
        }
    }
}