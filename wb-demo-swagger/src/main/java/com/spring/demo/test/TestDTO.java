package com.spring.demo.test;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: 测试请求参数
 * @description:
 * @date: 2023-04-12 16:02
 */
@ApiModel("接收参数")
@Data
public class TestDTO {

    @ApiModelProperty("字段")
    private String string;
}