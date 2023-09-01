package com.spring.demo.login.controller;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.spring.demo.AjaxResult;
import com.spring.demo.BaseController;
import com.spring.demo.config.properties.SysConfig;
import com.spring.demo.core.cache.support.CacheServer;
import com.spring.demo.core.constant.Constants;
import com.spring.demo.core.constant.Keys;
import com.spring.demo.login.dto.LoginBody;
import com.spring.demo.login.service.TokenService;
import com.spring.demo.login.vo.LoginUser;
import com.spring.demo.login.vo.SysUser;
import com.spring.demo.system.captcha.CaptchaImage;
import com.spring.demo.system.menu.domain.WbSysMenu;
import com.spring.demo.system.menu.service.IWbSysMenuService;
import com.spring.demo.system.setting.domain.GlobalSetting;
import com.spring.demo.system.setting.domain.WbSysSetting;
import com.spring.demo.system.setting.service.IWbSysSettingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @author: wb
 * @description:
 * @date: 2023-03-16 11:49
 */

@Slf4j
@RequiredArgsConstructor
@RestController
public class SysLoginController extends BaseController {

    private final IWbSysMenuService wbSysMenuService;

    private final IWbSysSettingService wbSysSettingService;

    private final CaptchaImage captchaImage;

    private final SysConfig sysConfig;

    private final TokenService tokenService;


    private final CacheServer cacheServer;

    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody) {
        RSA rsa = SecureUtil.rsa(Keys.privateKey, Keys.publicKey);

        String username = rsa.decryptStr(loginBody.getUsername(), KeyType.PrivateKey);
        String password = rsa.decryptStr(loginBody.getPassword(), KeyType.PrivateKey);

        String verificationCode = cacheServer.getObject(Constants.CAPTCHA_CODE_KEY + loginBody.getUuid());

        SysUser sysUser = new SysUser();
        sysUser.setUserName("管理员");
        LoginUser loginUser = new LoginUser(212L, 444L, sysUser, new HashSet<>());
        loginUser.setUserId(123L);
        return AjaxResult.success().put("token", tokenService.createToken(loginUser));
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @GetMapping("/getInfo")
    public AjaxResult getInfo() {
        // 角色集合
        Set<String> roles = new HashSet<String>() {{
            add("admin");
        }};
        // 权限集合
        Set<String> permissions = new HashSet<String>() {{
            add("*");
        }};
        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", new SysUser());
        ajax.put("roles", roles);
        ajax.put("permissions", permissions);
        return ajax;
    }

    /**
     * 获取路由信息
     *
     * @return 路由信息
     */
    @GetMapping("/getRouters")
    public AjaxResult getRouters() {
        List<WbSysMenu> wbSysMenus = wbSysMenuService.selectMenuTreeByUserId("");

        // 组装成路由信息
        return AjaxResult.success(wbSysMenuService.buildMenus(wbSysMenus));
    }

    @GetMapping("/getUserSetting")
    public AjaxResult getUserSetting(HttpServletRequest request) {

        WbSysSetting wbSysSetting = wbSysSettingService.selectWbSysSettingById(1L);
        return AjaxResult.success(wbSysSetting);
    }

    @GetMapping("/getGlobalSetting")
    public AjaxResult getGlobalSetting(HttpServletRequest request) {

        return AjaxResult.success(GlobalSetting.builder().captchaEnabled(sysConfig.isCaptchaEnabled()).build());
    }

    @GetMapping(value = "/captchaImage")
    public AjaxResult captchaImage(HttpServletRequest request) {

        return AjaxResult.success(captchaImage.creatCaptchaImage());
    }
}