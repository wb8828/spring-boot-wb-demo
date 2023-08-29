package com.spring.demo.core.myBatis;


import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})
})
public class MyBatisInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 在执行 SQL 语句之前的自定义逻辑
        System.out.println("Before executing SQL statement...");

        // 执行原始方法
        Object result = invocation.proceed();

        // 在执行 SQL 语句之后的自定义逻辑
        System.out.println("After executing SQL statement...");

        return result;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        // 设置拦截器的属性
    }
}