package com.spring.demo.easyexcel.test.controller;


import com.alibaba.excel.EasyExcel;
import com.google.common.collect.Sets;
import com.spring.demo.easyexcel.handler.CustomCellStyleHandler;
import com.spring.demo.easyexcel.listener.LocalEasyExcelListener;
import com.spring.demo.easyexcel.test.vo.TestData;
import com.spring.demo.easyexcel.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Slf4j
@RestController
@RequestMapping("/test/easyexcel")
public class TestController {

    /**
     * 根据参数只导出指定列
     * 动态有范围表头
     */
    @PostMapping("/includeColumnFiledNames")
    public void includeColumnFiledNames(HttpServletResponse response) {
        // 根据用户传入字段 假设我们只要导出 date
        Set<String> includeColumnFiledNames = new HashSet<String>();
        includeColumnFiledNames.add("birthday");

        FileUtils.download(TestData.class, "test", "测试", TestData.data(), includeColumnFiledNames, Sets.newHashSet(), null, response);
    }

    /**
     * 根据参数只导出指定列
     * 动态有范围表头
     */
    @PostMapping("/excludeColumnFiledNames")
    public void excludeColumnFiledNames(HttpServletResponse response) {
        // 根据用户传入字段 假设我们只要导出 date
        Set<String> excludeColumnFiledNames = new HashSet<String>();
        excludeColumnFiledNames.add("birthday");

        CustomCellStyleHandler customCellStyleHandler = new CustomCellStyleHandler();
        FileUtils.download(TestData.class, "test", "测试", TestData.data(), null, excludeColumnFiledNames, customCellStyleHandler, response);
    }

    /**
     * 导入
     * 此处导入的文件使用Resource下的文件方便测试
     */
    @PostMapping("/easyExcel")
    public void easyExcel() {
        List<TestData> successList = new ArrayList<>();
        List<TestData> errorList = new ArrayList<>();
        InputStream in = null;
        try {
            Resource res = new ClassPathResource("/template/test.xlsx");
            in = res.getInputStream();
            // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
            List<TestData> data = EasyExcel.read(in, TestData.class, new LocalEasyExcelListener(errorList, successList)).sheet().headRowNumber(1).doReadSync(); // doReadSync有返回值 doRead没有返回值
            System.out.println("");
        } catch (IOException e) {
            log.error("IO异常", e);
        } catch (Exception e) {
            log.error("捕捉异常", e);
        } finally {
            FileUtils.close(in);
        }

    }
}