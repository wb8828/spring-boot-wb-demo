package com.spring.demo.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class ListDemo1 {

    private static List<String> STR_LIST = new ArrayList<>();

    /**
     * 初始化集合数据
     */
    public static void init() {
        STR_LIST.clear();
        STR_LIST = new ArrayList<String>() {{
            add("one");
            add("two");
            add("three");
        }};
        log.info("初始list => {}", STR_LIST);
    }

    /**
     * subList方法包含左不包含右
     */
    public void subList() {
        ListDemo1.init();
        List<String> list = STR_LIST.subList(0, STR_LIST.size());
        log.info("subList => {}", list);
    }

    //<editor-fold desc="删除集合元素方法">
    public static class remove {
        /**
         * 通过java8的Filter过滤list元素
         */
        public void removeByFilter() {
            ListDemo1.init();
            // 删除list元素方式1
            // 不等two的字符串保留，即表达式为true的保留
            List<String> collect = STR_LIST.stream().filter(e -> !"two".equals(e)).collect(Collectors.toList());
            log.info("removeByFilter => {}", collect);
        }

        /**
         * 通过迭代器删除list元素
         */
        public void removeByIterator() {
            ListDemo1.init();

            Iterator<String> iterable = STR_LIST.iterator();
            while (iterable.hasNext()) {
                if ("two".equals(iterable.next())) {
                    iterable.remove();
                }
            }
            log.info("removeByIterator => {}", STR_LIST);
        }

        /**
         * 通过RemoveIf删除list元素
         */
        public void removeByRemoveIf() {
            ListDemo1.init();
            // 删除list元素方式3
            STR_LIST.removeIf("two"::equals);
            log.info("removeByremoveIf => {}", STR_LIST);
        }
    }
    //</editor-fold>


}