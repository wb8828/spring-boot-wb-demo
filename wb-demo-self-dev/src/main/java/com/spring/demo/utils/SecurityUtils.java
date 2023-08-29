package com.spring.demo.utils;

import com.spring.demo.login.vo.SysUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author: wb
 * @description:
 * @date: 2022-12-14 10:42
 */
public class SecurityUtils {


    /**
     * 获取用户
     **/
    public static SysUser getLoginUser() {
        try {
            return (SysUser) getAuthentication().getPrincipal();
        } catch (Exception e) {
//            throw new RuntimeException("获取用户信息异常", HttpStatus.UNAUTHORIZED);
        }
        return null;
    }

    /**
     * 获取Authentication
     */
    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取加密后的密码
     * 不允许纯数字纯字母
     */
    public static String password(String pwd) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(pwd);
    }
}