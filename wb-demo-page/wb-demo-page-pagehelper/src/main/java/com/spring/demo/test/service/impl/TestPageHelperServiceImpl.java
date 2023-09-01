package com.spring.demo.test.service.impl;

import com.spring.demo.pojo.BasePageModel;
import com.spring.demo.test.mapper.TestPageHelperMapper;
import com.spring.demo.test.service.ITestPageHelperService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 测试分页插件
 */
@Primary
@Service("TestPageHelperService")
public class TestPageHelperServiceImpl extends BasePageModel implements ITestPageHelperService {
    @Resource
    private TestPageHelperMapper testPageHelperMapper;

    @Override
    public List<Map<String, String>> queryPage(Integer pageNum, Integer pageSize) {
        startPage(pageNum, pageSize);
        return testPageHelperMapper.queryPage();
    }
}