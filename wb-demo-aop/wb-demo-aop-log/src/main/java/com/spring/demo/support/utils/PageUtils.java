package com.spring.demo.support.utils;

import cn.hutool.core.convert.Convert;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spring.demo.support.pagehelper.TableDataInfo;

import java.util.List;


/**
 * 分页工具类
 */
public class PageUtils extends PageHelper {
    /**
     * 设置请求分页数据
     */
    public static void startPage() {
        Integer pageNum = Convert.toInt(ServletUtils.getParameter("pageNum"), 1);
        Integer pageSize = Convert.toInt(ServletUtils.getParameter("pageSize"), 10);
        startPage(pageNum, pageSize);
    }

    /**
     * 清理分页的线程变量
     */
    public static void clearPage() {
        PageHelper.clearPage();
    }

    /**
     * 设置请求分页数据
     */
    public static void startPage(Integer pageNum, Integer pageSize) {
        Boolean reasonable = true;
        PageHelper.startPage(pageNum, pageSize).setReasonable(reasonable);
    }


    /**
     * 响应请求分页数据
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static TableDataInfo getDataTable(List<?> list) {
        TableDataInfo rspData = new TableDataInfo();
        PageInfo pageInfo = new PageInfo(list);

        rspData.setCode(200);
        rspData.setMsg("查询成功");
        rspData.setRows(list);
        rspData.setTotal(pageInfo.getTotal());
        rspData.setPageNum(pageInfo.getPageNum());
        rspData.setPageSize(pageInfo.getPageSize());
        rspData.setHaveNextPage(pageInfo.isHasNextPage());
        rspData.setLastPage(pageInfo.isIsLastPage());
        rspData.setFirstPage(pageInfo.isIsFirstPage());
        rspData.setHasPreviousPage(pageInfo.isHasPreviousPage());
        return rspData;
    }
}
