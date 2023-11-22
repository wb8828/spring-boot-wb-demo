package com.spring.demo.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;

/**
 * @author: wb
 * @description: 记录映射反射的方法-持续更新
 */
@Slf4j
public class FieldDemo {


    /**
     * 获取静态属性值
     * 获取非静态的属性值参考test1写法
     */
    public void test() throws IllegalAccessException {

        Field[] fields = FieldTestPOJO.class.getDeclaredFields();

        for (Field field : fields) {
            if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) { // 判断为静态属性
                field.setAccessible(true); // 私有属性需要设置为可以访问
                log.info("静态字段名称：{}，字段值：{}，字段类型为：{}", field.getName(), field.get(null), field.getType());
            }

        }
    }

    /**
     * 获取非静态属性值
     * 当然此方法也可以直接获取静态的属性值
     */
    public void test1() throws IllegalAccessException {
        FieldTestPOJO fieldTestPOJO = new FieldTestPOJO("踢足球");
        Field[] fields = fieldTestPOJO.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (!Modifier.isStatic(field.getModifiers())) { // 非静态属性
                field.setAccessible(true); // 私有属性需要设置为可以访问
                log.info("非静态字段名称：{}，字段值：{}，字段类型为：{}", field.getName(), field.get(fieldTestPOJO), field.getType());
            }

        }
    }


    @Data
    @Builder
    @AllArgsConstructor
    static class FieldTestPOJO {

        public static final Long tex = 10L;

        private static String name = "张三";

        private static Integer age = 18;

        private static Byte sex = 1;

        private String hobby;

        @Singular("addGoodAt")
        private List<String> goodAt;

        public FieldTestPOJO(String hobby) {
            this.hobby = hobby;
        }

        public FieldTestPOJO() {

        }
    }
}