package com.spring.demo.config.properties;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(
        prefix = "xxl.job",
        ignoreUnknownFields = true
)
@Getter
@Setter
public class XxlJobProperties {

    private String accessToken;

    private Admin admin;

    private Executor executor;

    @Getter
    @Setter
    public static class Admin {
        private String addresses;
    }

    @Getter
    @Setter
    public static class Executor {

        private String address;
        private String appName;
        private String ip;
        private String logPath;
        private int logRetentionDays;

        private Integer port;

    }
}