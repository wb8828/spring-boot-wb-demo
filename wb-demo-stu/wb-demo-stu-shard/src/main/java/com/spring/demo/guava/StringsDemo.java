package com.spring.demo.guava;

import com.google.common.base.Strings;

/**
 * 字符串工具
 */
public class StringsDemo {
    public static void main(String[] args) {
        // NULL 变成空
        System.out.println(Strings.nullToEmpty(null));
        System.out.println(Strings.nullToEmpty("122"));

        // 空变null
        System.out.println("------------空变null");
        System.out.println(Strings.emptyToNull(""));
        System.out.println(Strings.emptyToNull("   "));
        System.out.println(Strings.emptyToNull("   2131"));

        // 判断字符串是否为空或null，多个空格不为空
        String str1 = null;
        String str2 = "";
        System.out.println(Strings.isNullOrEmpty(str1));
        System.out.println(Strings.isNullOrEmpty(str2));

        // 在字符串末尾填充指定字符，直到字符串达到指定长度
        String str3 = "abc";
        String paddedStr1 = Strings.padEnd(str3, 6, '*');
        System.out.println(paddedStr1);

        // 在字符串开头填充指定字符，直到字符串达到指定长度
        String str4 = "abc";
        String paddedStr2 = Strings.padStart(str4, 6, '*');
        System.out.println(paddedStr2);

        // 重复指定字符串指定次数
        String str5 = "abc";
        String repeatedStr = Strings.repeat(str5, 3);
        System.out.println(repeatedStr);

        // 获取两个字符串的最长公共前缀
        String str6 = "abcdefg";
        String str7 = "abcdxyz";
        String commonPrefix = Strings.commonPrefix(str6, str7);
        System.out.println(commonPrefix);

        // 获取两个字符串的最长公共后缀
        String str8 = "abcdefg";
        String str9 = "xyzdefg";
        String commonSuffix = Strings.commonSuffix(str8, str9);
        System.out.println(commonSuffix);
    }
}