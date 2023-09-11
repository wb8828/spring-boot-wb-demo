package com.spring.demo;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 数据库密码测试
 */
public class PasswordTest extends SpringBootDemoEmailApplicationTests {
    @Autowired
    private StringEncryptor encryptor;

    /**
     * 生成加密密码
     */
    @Test
    public void testGeneratePassword() {
        // 你的邮箱密码
        String password = "testPass";
        // 加密后的密码(注意：配置上去的时候需要加 ENC(加密密码))
        String encryptPassword = encryptor.encrypt(password);
        String decryptPassword = encryptor.decrypt(encryptPassword);

        System.out.println("password = " + password);
        System.out.println("encryptPassword = " + encryptPassword);
        System.out.println("decryptPassword = " + decryptPassword);
    }
}
