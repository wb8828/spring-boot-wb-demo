package com.spring.demo.config;


import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import com.spring.demo.support.SwaggerProperties;
import com.spring.demo.support.SwaggerUtil;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;


@EnableSwagger2
@Configuration
@ConditionalOnProperty(name = "swagger.enabled", matchIfMissing = true)
@EnableSwaggerBootstrapUI
@ConditionalOnClass(Docket.class)
public class SwaggerAutoConfiguration {
    @Bean
    public Docket api(SwaggerProperties swaggerProperties) {
        ApiSelectorBuilder builder = new Docket(DocumentationType.SWAGGER_2).select()
                .apis(SwaggerUtil.basePackages(swaggerProperties.getBasePackages()))
                .paths(PathSelectors.any());

        return builder.build().apiInfo(apiInfo(swaggerProperties)).securitySchemes(securitySchemes());
    }

    private List<SecurityScheme> securitySchemes() {
        List<SecurityScheme> apiKeyList = new ArrayList();
        apiKeyList.add(new ApiKey("Authorization", "Authorization", "header"));
        return apiKeyList;
    }

    private static ApiInfo apiInfo(SwaggerProperties swaggerProperties) {
        return new ApiInfoBuilder().title(swaggerProperties.getTitle()).description(swaggerProperties.getDescription())
                .version(swaggerProperties.getVersion()).build();
    }

}
