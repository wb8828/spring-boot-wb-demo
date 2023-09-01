package com.spring.demo.test.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 测试分页插件
 */
@Mapper
public interface TestPageHelperMapper {

    @Select("select * from test_pagehelper")
    List<Map<String, String>> queryPage();
}