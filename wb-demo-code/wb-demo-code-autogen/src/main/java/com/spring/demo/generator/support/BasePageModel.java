package com.spring.demo.generator.support;


import com.spring.demo.generator.support.utils.PageUtils;

import java.util.List;


public class BasePageModel {
    /**
     * 设置请求分页数据
     */
    protected void startPage() {
        PageUtils.startPage();
    }

    /**
     * 设置请求分页数据
     */
    protected void startPage(Integer pageNum, Integer pageSize) {
        PageUtils.startPage(pageNum, pageSize);
    }


    /**
     * 清理分页的线程变量
     */
    protected void clearPage() {
        PageUtils.clearPage();
    }


    /**
     * 响应请求分页数据
     */
    protected TableDataInfo getDataTable(List<?> list) {
        return PageUtils.getDataTable(list);
    }
}