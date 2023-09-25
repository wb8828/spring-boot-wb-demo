package com.spring.demo.generator.support;

import lombok.Data;

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