package com.spring.demo.test;

import lombok.Data;
import lombok.Value;
import lombok.experimental.Accessors;

@Data
//@Value
@Accessors(chain = true, fluent = true)
public class Demo3 {

    private String name;

    private Integer age;

    private Byte sex;
}