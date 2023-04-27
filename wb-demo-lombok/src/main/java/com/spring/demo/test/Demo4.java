package com.spring.demo.test;

import lombok.Builder;
import lombok.Singular;
import lombok.ToString;

import java.util.List;

@Builder
@ToString
public class Demo4 {

    private String name;

    private Integer age;

    private Byte sex;

    @Singular("addHobby") // 直接调用会增加到此集合，示例代码在下面
    private List<String> hobby;

    public static void main(String[] args) {
        Demo4 demo4 = Demo4.builder()
                .name("张三")
                .age(10)
                .addHobby("打游戏")
                .addHobby("打篮球")
                .build();
        System.out.println(demo4.toString());
    }
}