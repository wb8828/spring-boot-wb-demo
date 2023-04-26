package com.spring.demo;

import lombok.Data;

/**
 * @author: 自己的名字
 * @description:
 * @date: 2022-12-15 16:06
 */
@Data
public class BaseParams {

    /**
     * 页码
     */
    private Integer pageNum;

    /**
     * 每页条数
     */
    private Integer pageSize;
}