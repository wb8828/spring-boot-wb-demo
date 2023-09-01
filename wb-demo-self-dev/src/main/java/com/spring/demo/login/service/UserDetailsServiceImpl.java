package com.spring.demo.login.service;

import cn.hutool.core.util.ObjectUtil;
import com.spring.demo.config.properties.SysConfig;
import com.spring.demo.core.cache.support.CacheServer;
import com.spring.demo.core.constant.Constants;
import com.spring.demo.core.security.context.AuthenticationContextHolder;
import com.spring.demo.login.vo.LoginUser;
import com.spring.demo.login.vo.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 验证用户权限
 */
@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private CacheServer cacheServer;

    @Autowired
    private SysConfig sysConfig;

    @Value(value = "${user.password.maxRetryCount:5}")
    private int maxRetryCount;

    @Value(value = "${user.password.lockTime:10}")
    private int lockTime;

    /**
     * 判断密码是否相同
     *
     * @param rawPassword     真实密码
     * @param encodedPassword 加密后字符
     * @return 结果
     */
    public static boolean matchesPassword(String rawPassword, String encodedPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    public static String getPwd(String s) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(s);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = new SysUser();
        if (ObjectUtil.isNull(user)) {
            throw new RuntimeException("10245");
        }
        // 验证密码是否正确
        validate(user);
        // 获取用户的角色
        Set<String> pre = new HashSet<>();
        return createLoginUser(user, pre);
    }

    public UserDetails createLoginUser(SysUser user, Set<String> pre) {
        return new LoginUser(user, pre);
    }

    private void validate(SysUser user) {
        Authentication usernamePasswordAuthenticationToken = AuthenticationContextHolder.getContext();
        String username = usernamePasswordAuthenticationToken.getName();
        String password = usernamePasswordAuthenticationToken.getCredentials().toString();

        Integer retryCount = cacheServer.getObject(getCacheKey(username));

        if (retryCount == null) {
            retryCount = 0;
        }
        if (retryCount >= Integer.valueOf(maxRetryCount).intValue()) {
            throw new RuntimeException("10246");
        }
        // 验证密码是否正确
        if (!matches(user, password)) {
            retryCount = retryCount + 1;
            cacheServer.setObject(getCacheKey(username), retryCount, lockTime, TimeUnit.MINUTES);
            throw new RuntimeException("10245");
        }
        // 清除密码锁定信息
        else {
            clearLoginRecordCache(username);
        }
    }

    public boolean matches(SysUser user, String rawPassword) {
        return matchesPassword(rawPassword, user.getPassword());
    }

    public void clearLoginRecordCache(String loginName) {
        if (cacheServer.hasKey(getCacheKey(loginName))) {
            cacheServer.deleteObject(getCacheKey(loginName));
        }
    }

    /**
     * 登录账户密码错误次数缓存键名
     *
     * @param username 用户名
     * @return 缓存键key
     */
    private String getCacheKey(String username) {
        return Constants.PWD_ERR_CNT_KEY + username;
    }

}