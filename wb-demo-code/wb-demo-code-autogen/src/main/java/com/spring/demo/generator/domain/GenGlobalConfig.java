package com.spring.demo.generator.domain;

import lombok.Data;

@Data
public class GenGlobalConfig   {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 是否开启lombok
     */
    private Boolean openLombok;

    /**
     * 是否开启MybatisPlus
     */
    private Boolean openMybatisPlus;

    /**
     * 是否开启基础类
     */
    private String openBaseEntity;

    /**
     * 是否开启controller
     */
    private String openBaseController;

    /**
     * 统一返回结果
     */
    private String unifyAjaxResult;

    /**
     * 是否开启Swagger
     */
    private Boolean openSwagger;

    /**
     * 是否开启ageHelper
     */
    private Boolean openPageHelper;
}