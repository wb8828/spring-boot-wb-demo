package com.spring.demo.core.filter;


import com.spring.demo.config.request.XssHttpServletRequestWrapper;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class XssFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        // 后台自定义cookie信息
        String isc_id = httpServletRequest.getHeader("isc_id");
        log.info("XssFilter-isc_id:{}", isc_id);
        String jwt = "sfsdsf";
        Cookie jwtCookie = creatCookie("_at", jwt);
        Cookie seesionCookie = creatCookie("SESSION", ((HttpServletRequest) request).getRequestedSessionId());


        chain.doFilter(new XssHttpServletRequestWrapper((HttpServletRequest) request, new Cookie[]{jwtCookie, seesionCookie}), response);
    }


    private Cookie creatCookie(String name, String value) {
        Cookie customCookie = new Cookie(name, value);
        customCookie.setMaxAge(-1); // 设置Cookie的过期时间，单位为秒
        customCookie.setPath("/"); // 设置Cookie的路径

        return customCookie;
    }
}