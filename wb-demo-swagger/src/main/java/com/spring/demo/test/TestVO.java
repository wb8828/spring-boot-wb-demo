package com.spring.demo.test;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: wb
 * @description: 测试响应参数
 * @date: 2023-04-12 16:02
 */
@Data
@ApiModel("返回参数")
public class TestVO {

    @ApiModelProperty("字段")
    private String string;
}