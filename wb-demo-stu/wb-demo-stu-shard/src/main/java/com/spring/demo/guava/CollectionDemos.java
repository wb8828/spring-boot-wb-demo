package com.spring.demo.guava;


import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 集合操作常用方法
 */
public class CollectionDemos {
    public static void main(String[] args) {
        // 不可变集合
        ImmutableList<String> iList = ImmutableList.of("a", "b", "c");
        ImmutableSet<String> iSet = ImmutableSet.of("e1", "e2");
        ImmutableMap<String, String> iMap = ImmutableMap.of("k1", "v1", "k2", "v2");

        List<String> list = Lists.newArrayList("a", "b", "c");
        ImmutableList<String> immutableList = ImmutableList.copyOf(list);
        System.out.println(immutableList);

        // 分割集合
        List<List<String>> partition = Lists.partition(immutableList, 2);
        System.out.println(partition);

        // 创建map集合(key=String，value=list)
        Multimap<String, Integer> map = ArrayListMultimap.create();
        map.put("aa", 1);
        map.put("aa", 2);
        System.out.println(map.get("aa"));  //[1, 2]

        // BiMap: 双向Map(Bidirectional Map) 键与值都不能重复
        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("123", "wsdfsde");
        System.out.println(biMap);

        // 将集合转换为特定规则的字符串
        List<String> list1 = new ArrayList<String>();
        list1.add("aa");
        list1.add("bb");
        list1.add("cc");
        String result = Joiner.on("-").join(list1);
        System.out.println(result);

        // 把 map 集合转换为特定规则的字符串
        Map<String, Integer> map1 = Maps.newHashMap();
        map1.put("xiaoming", 12);
        map1.put("xiaohong",13);
        String result1 = Joiner.on(",").withKeyValueSeparator("=").join(map1);
        System.out.println(result1);

        // 将 String 转换为特定的集合
        String str = "1-2-3-4-5-6";
        List<String> list2 = Splitter.on("-").splitToList(str);
        String str1 = "xiaoming=11,xiaohong=23";
        Map<String,String> map2 = Splitter.on(",").withKeyValueSeparator("=").split(str1);
        String str2 = "1-2-3-4-  5-  6   ";
        List<String> list3 = Splitter.on("-").omitEmptyStrings().trimResults().splitToList(str2);
        System.out.println(list3);
    }
}