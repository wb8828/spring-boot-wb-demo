package com.spring.demo.generator.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class CreateCodeGenConfig implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private String id;

    /**
     * 作者
     */
    private String functionAuthor;

    /**
     * 包名
     */
    private String packageName;

    /**
     * 模块名
     */
    private String moduleName;

    /**
     * 业务名称
     */
    private String businessName;

    /**
     * 功能名称
     */
    private String functionName;

    /**
     * 是否开启Lombok
     */
    private String openLombok;

    /**
     * 是否开启MybatisPlus
     */
    private String openMybatisPlus;

}