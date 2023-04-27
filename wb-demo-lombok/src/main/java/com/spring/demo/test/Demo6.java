package com.spring.demo.test;

import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;

import java.util.List;

@Data
@FieldNameConstants
public class Demo6 {

    private String name;

    private Integer age;

    private Byte sex;

    private List<String> hobby;

    public static void main(String[] args) {

        System.out.println(Demo6.Fields.sex);
    }

}