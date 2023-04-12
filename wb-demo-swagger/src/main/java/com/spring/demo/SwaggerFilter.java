package com.spring.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: chendayuan
 * @create: 2021-07-15 16:06
 **/
@Configuration
public class SwaggerFilter implements Filter {

    @Value("${wb.swagger.enabled:false}")
    private Boolean isEnabled;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        if (!isEnabled) {
            HttpServletRequest req = (HttpServletRequest) request;
            String reqUrl = req.getRequestURI();

            if (reqUrl.indexOf("/doc.html") > 0) {
                HttpServletResponse res = (HttpServletResponse) response;
                res.setStatus(HttpStatus.NOT_FOUND.value());
                return;
            }
        }
        chain.doFilter(request, response);
    }
}
