package com.spring.demo;


import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// 打日志的直接，自己选，常用Slf4j
@Slf4j
//@XSlf4j
//@Log
//@Log4j
//@Log4j2
//@CommonsLog
//@JBossLog
public class DemoLombok {


    /**
     * 抛出异常注解
     */
    @SneakyThrows
    public void shitHappens() {
        Thread.sleep(1000);
    }

    /**
     * 增加Synchronized关键字
     */
    @Synchronized
    public void concurrency() {
        System.out.println("123");
    }

    /**
     * 自动关闭资源
     */
    public void copyFile(String in, String out) throws IOException {
        @Cleanup FileInputStream inputStream = new FileInputStream(in);
        @Cleanup FileOutputStream outputStream = new FileOutputStream(in);
        byte[] bytes = new byte[65536];
        while (true) {
            int r = inputStream.read(bytes);
            if (r == -1) {
                break;
            }
            outputStream.write(bytes, 0, r);
        }
    }
}