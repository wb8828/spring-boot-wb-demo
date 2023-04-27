package com.spring.demo.test;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE) // 无参构造函数，加个PRIVATE 单例就有了
@AllArgsConstructor // 全参构造函数
public class Demo2 {

    private String name;

    private Integer age;

    private Byte sex;
}