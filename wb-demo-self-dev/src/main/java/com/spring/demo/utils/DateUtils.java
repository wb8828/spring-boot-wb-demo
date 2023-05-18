package com.spring.demo.utils;

import org.apache.commons.lang3.RandomUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 */
public class DateUtils {
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 格式化日期
     */
    public static String parseDateToStr(final String format, final Date date) {
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 获取当前日期, 默认格式为yyyy-MM-dd
     */
    public static String getDate() {
        return dateTimeNow(YYYY_MM_DD);
    }

    /**
     * 获取当前日期, 自定义格式
     */
    public static String dateTimeNow(final String format) {
        return parseDateToStr(format, new Date());
    }

    public static String randomDate(String beginTime, String endTime) {
        try {
            //指定开始日期
            long start = sdf.parse(beginTime).getTime();
            //指定结束日期
            long end = sdf.parse(endTime).getTime();
            //调用方法产生随机数
            long randomDate = RandomUtils.nextLong(start, end);
            //格式化输出日期
            return parseDateToStr(YYYY_MM_DD, new Date(randomDate));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getDate();
    }
}