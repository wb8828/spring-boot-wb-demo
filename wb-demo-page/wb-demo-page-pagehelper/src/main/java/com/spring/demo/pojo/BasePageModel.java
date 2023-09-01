package com.spring.demo.pojo;

import com.spring.demo.utils.PageUtils;

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
     * 设置请求排序数据
     */
    protected void startOrderBy(String orderBy) {
        PageUtils.startOrderBy(orderBy);
    }


    /**
     * 响应请求分页数据
     */
    protected TableDataInfo getDataTable(List<?> list) {
        return PageUtils.getDataTable(list);
    }
}