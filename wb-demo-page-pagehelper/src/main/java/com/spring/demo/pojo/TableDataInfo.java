package com.spring.demo.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 表格分页数据对象
 */
@Data
public class TableDataInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 总记录数
     */
    private long total;

    /**
     * 列表数据
     */
    private List<?> rows;

    /**
     * 消息状态码
     */
    private int code;

    /**
     * 消息内容
     */
    private String msg;

    /**
     * 页码
     */
    private int pageNum;

    /**
     * 每页条数
     */
    private int pageSize;
    /**
     * 总页数
     */
    private int pages;
    /**
     * 是否第一页
     */
    private boolean isFirstPage;
    /**
     * 是否最后一页
     */
    private boolean isLastPage;
    /**
     * 是否有前一页
     */
    private boolean hasPreviousPage;
    /**
     * 是否有下一页
     */
    private boolean haveNextPage;

    /**
     * 表格数据对象
     */
    public TableDataInfo() {
    }

    /**
     * 分页
     *
     * @param list  列表数据
     * @param total 总记录数
     */
    public TableDataInfo(List<?> list, int total) {
        this.rows = list;
        this.total = total;
    }

}
