package com.spring.demo.demo.java;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class Java8Demo {
    // <editor-fold desc="集合转MAP">
    private static List<TestPOJO> list = null;

    public static void init1() {
        list = new ArrayList<TestPOJO>() {{
            add(new TestPOJO("1", "1-1"));
            add(new TestPOJO("2", "2-2"));
            add(new TestPOJO("3", "3-3"));
        }};
    }

    public static void init2() {
        list = new ArrayList<TestPOJO>() {{
            add(new TestPOJO("1", "1-1"));
            add(new TestPOJO("2", "2-2"));
            add(new TestPOJO("2", "3-3"));
        }};
    }

    public void getIdNameMap() {
        Java8Demo.init1();
        Map<String, String> collect = list.stream().collect(Collectors.toMap(TestPOJO::getKey, TestPOJO::getValue));
        log.info(collect.toString());
    }

    /**
     * 重复key的情况
     * 在list转为map时，作为key的值有可能重复，这时候流的处理会抛出个异常：Java.lang.IllegalStateException:Duplicate key。
     * 这时候就要在toMap方法中指定当key冲突时key的选择。(这里是选择第二个key覆盖第一个key)
     */
    public void test2() {
        Java8Demo.init2();
        Map<String, String> collect = list.stream().collect(Collectors.toMap(TestPOJO::getKey, TestPOJO::getValue, (key1, key2) -> key2));
        log.info(collect.toString());
    }

    public void test3() {
        Java8Demo.init1();
        Map<String, TestPOJO> collect = list.stream().collect(Collectors.toMap(TestPOJO::getKey, account -> account));

        // account -> account是一个返回本身的lambda表达式，其实还可以使用Function接口中的一个默认方法 Function.identity()，这个方法返回自身对象，更加简洁
        Map<String, TestPOJO> collect1 = list.stream().collect(Collectors.toMap(TestPOJO::getKey, Function.identity()));
        log.info(collect.toString());
        log.info(collect1.toString());
    }

    // </editor-fold>

    // <editor-fold desc="集合转List">

    public void test4(){
        Java8Demo.init1();
        List<String> collect = list.stream().map(TestPOJO::getKey).collect(Collectors.toList());
        log.info(collect.toString());
    }

    // </editor-fold>

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class TestPOJO {
        private String key;

        private String value;
    }
}