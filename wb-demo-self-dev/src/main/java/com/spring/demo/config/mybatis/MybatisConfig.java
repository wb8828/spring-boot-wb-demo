package com.spring.demo.config.mybatis;

import com.spring.demo.core.myBatis.MyBatisInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
@Slf4j
public class MybatisConfig {
    @Bean
    public String myInterceptor(SqlSessionFactory sqlSessionFactory) {
        //实例化插件
        MyBatisInterceptor sqlInterceptor = new MyBatisInterceptor();
        //创建属性值
        Properties properties = new Properties();
        properties.setProperty("prop1", "value1");
        //将属性值设置到插件中
        sqlInterceptor.setProperties(properties);
        //将插件添加到SqlSessionFactory工厂
        sqlSessionFactory.getConfiguration().addInterceptor(sqlInterceptor);
        log.info("mybatis拦截器注入容器成功");
        return "interceptor";
    }
}