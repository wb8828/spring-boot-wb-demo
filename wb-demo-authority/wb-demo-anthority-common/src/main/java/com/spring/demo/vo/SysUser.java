package com.spring.demo.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysUser implements Serializable {
    private static final long serialVersionUID = 5175082362119580768L;


    private String userName;

    private String password;
}