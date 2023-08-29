package com.spring.demo.core.security.handle;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson2.JSON;
import com.spring.demo.HttpStatus;
import com.spring.demo.utils.ServletUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 认证失败处理类 返回未授权
 * 
 * @author ruoyi
 */
@ConditionalOnProperty(name = "type",prefix = "system",havingValue = "jf")
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint, Serializable
{
    private static final long serialVersionUID = -8970718410437077606L;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e)
            throws IOException
    {

        int code = HttpStatus.UNAUTHORIZED;
        String msg = StrUtil.format("请求访问：{}，认证失败，无法访问系统资源", request.getRequestURI());
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("msg",msg);
        map.put("code",code);
        ServletUtils.renderString(response, JSON.toJSONString(map));
    }
}
