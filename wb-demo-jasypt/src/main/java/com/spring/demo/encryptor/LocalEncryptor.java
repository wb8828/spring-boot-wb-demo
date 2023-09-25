package com.spring.demo.encryptor;

import com.spring.demo.util.JasyptUtil;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.spring.demo.util.JasyptUtil.PBE_ALGORITHMS_SHA1_RC2_40;

/**
 * 自定义加密器
 */
@Component("localEncryptor")
public class LocalEncryptor implements StringEncryptor {

    /**
     * 启动命令赋值
     */
    @Value("${jasypt.encryptor.salt}")
    private String salt;


    /**
     * 加密
     */
    @Override
    public String encrypt(String message) {
        return JasyptUtil.encrypt(message, PBE_ALGORITHMS_SHA1_RC2_40, salt);
    }

    /**
     * 解密
     */
    @Override
    public String decrypt(String encryptedMessage) {
        return JasyptUtil.decrypt(encryptedMessage, PBE_ALGORITHMS_SHA1_RC2_40, salt);
    }
}