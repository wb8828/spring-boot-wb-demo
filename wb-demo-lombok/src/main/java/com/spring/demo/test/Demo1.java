package com.spring.demo.test;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(of = {"name", "age"}) // 指定哪些字段参与EqualsAndHashCode
@ToString(of = {"name", "age"})// 指定哪些字段参与ToString
public class Demo1 {

    private String name;

    private Integer age;

    private Byte sex;
}