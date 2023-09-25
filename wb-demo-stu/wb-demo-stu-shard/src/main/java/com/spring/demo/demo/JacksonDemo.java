package com.spring.demo.demo;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL) // 这个最常用，即如果加该注解的字段为null,那么就不序列化这个字段了。
//@JsonJsonInclude.Include.NON_DEFAULT  //如果字段是默认值的话就不序列化。
public class JacksonDemo {

    @JsonProperty("demo")
    private String iDemo;

    public static void main(String[] args) {

        System.out.println(test(41));
    }

    public static int test(int num) {
        return num / 10 * 10;
    }
}