package com.spring.demo.core.filter;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 是在一次外部请求中只过滤一次。对于服务器内部之间的forward等请求，不会再次执行过滤方法。
 */
@Component
@Slf4j
public class OncePerRequestFilterConfig extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        log.info("自定义过滤器--》》》请求路径为" + httpServletRequest.getRequestURI());
        doFilter(httpServletRequest, httpServletResponse, filterChain);
    }
}
