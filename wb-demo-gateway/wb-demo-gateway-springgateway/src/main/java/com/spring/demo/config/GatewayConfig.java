package com.spring.demo.config;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Autowired
    private MeterRegistry meterRegistry;

    /**
     * Spring Cloud Gateway 提供了一种名为 Gateway Metrics Filter 的过滤器
     * 用于收集和记录网关的指标数据。
     * 你可以使用该过滤器来监控和度量你的网关服务的性能和行为。
     */
    @Bean
    public MeterRegistryCustomizer<MeterRegistry> gatewayMetricsCustomizer() {
        return registry -> registry.config().commonTags("application", "gateway-service");
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("baidu_route", r -> r.path("/baidu")
                        .uri("https://www.baidu.com"))
                .build();
    }
}