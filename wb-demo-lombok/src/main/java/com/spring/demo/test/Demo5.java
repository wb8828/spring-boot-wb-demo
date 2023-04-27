package com.spring.demo.test;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true) // 链式操作
public class Demo5 {

    private String name;

    private Integer age;

    private Byte sex;

    private List<String> hobby;

    public static void main(String[] args) {
        Demo5 demo5 = new Demo5();
        // chain，设置值不用换行
        demo5.setAge(10).setName("张三");
    }

}