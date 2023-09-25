package com.spring.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@Slf4j
public class SwaggerFilter implements Filter {

    @Value("${swagger.enabled:false}")
    private Boolean isEnabled;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        if (!isEnabled) {
            HttpServletRequest req = (HttpServletRequest) request;
            String reqUrl = req.getRequestURI();

            if (reqUrl.indexOf("/doc.html") > 0) {
                log.info("访问swagger被拦截!");
                HttpServletResponse res = (HttpServletResponse) response;
                res.setStatus(HttpStatus.FORBIDDEN.value());
                return;
            }
        }
        chain.doFilter(request, response);
    }
}
