package com.spring.demo.utils;


import cn.hutool.core.io.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class FileUtils {

    public static List<String> getTxtContentList(File file) {
        List<String> result = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                result.add(StringUtils.trim(s));
            }
            br.close();
        } catch (Exception e) {
            log.error("未找到文件");
        }
        return result;
    }

    public static String getTxtContent(File file) {
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
//                result.append(s);
                result.append(StringUtils.trim(s)).append(System.lineSeparator());
            }
            br.close();
        } catch (Exception e) {
            log.error("未找到文件");
        }
        return result.toString();
    }

    public static File getFile(String path) {
        File file = FileUtil.file(path);
        if (file.exists()) {
            return file;
        }
        return null;
    }

    public static void main(String[] args) {
        File file = new File("D:\\home\\person.txt");
        System.out.println(getTxtContent(file));
    }
}