package com.spring.demo.config;

import com.spring.demo.utils.SM4Utils;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 自定义加密器
 */
@Component("myStringEncryptor")
public class MyStringEncryptor implements StringEncryptor {

    /**
     * 启动命令赋值
     */
    @Value("${jasypt.encryptor.key}")
    private String SM4_SECRET_KEY;
    /**
     * 启动命令赋值
     */
    @Value("${jasypt.encryptor.iv}")
    private String SM4_IV;


    /**
     * 加密
     */
    @Override
    public String encrypt(String message) {
        return SM4Utils.encryptData_CBC(message, SM4_SECRET_KEY, SM4_IV);
    }

    /**
     * 解密
     */
    @Override
    public String decrypt(String encryptedMessage) {
        return SM4Utils.decryptData_CBC(encryptedMessage, SM4_SECRET_KEY, SM4_IV);
    }
}