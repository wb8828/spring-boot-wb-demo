package com.spring.demo.test.service;

import java.util.List;
import java.util.Map;

/**
 * 测试分页插件
 */
public interface ITestPageHelperService {

    List<Map<String, String>> queryPage(Integer pageNum,Integer pageSize );
}