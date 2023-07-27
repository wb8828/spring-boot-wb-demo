package com.spring.demo.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestUser implements Serializable {
    private static final long serialVersionUID = 2892248514883451461L;
    /**
     * 主键id
     */
    private Long id;
    /**
     * 姓名
     */
    private String name;
}
