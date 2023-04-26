package com.spring.demo.login.controller;

import com.github.pagehelper.autoconfigure.PageHelperProperties;
import com.spring.demo.AjaxResult;
import com.spring.demo.BaseController;
import com.spring.demo.system.menu.domain.WbSysMenu;
import com.spring.demo.system.menu.service.IWbSysMenuService;
import com.spring.demo.system.setting.domain.WbSysSetting;
import com.spring.demo.system.setting.service.IWbSysSettingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @GetMapping("/getSetting")
    public AjaxResult getSetting(HttpServletRequest request) {

        WbSysSetting wbSysSetting = wbSysSettingService.selectWbSysSettingById(1L);
        return AjaxResult.success(wbSysSetting);
    }
}