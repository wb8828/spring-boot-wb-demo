package com.spring.demo.system.menu.controller;


import com.spring.demo.AjaxResult;
import com.spring.demo.pojo.BasePageModel;
import com.spring.demo.pojo.TableDataInfo;
import com.spring.demo.system.menu.domain.WbSysMenu;
import com.spring.demo.system.menu.service.IWbSysMenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 菜单Controller
 *
 * @author wb
 * @date 2023-03-16
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/menu")
public class WbSysMenuController extends BasePageModel {
    private final IWbSysMenuService wbSysMenuService;


    /**
     * 查询菜单列表
     */
    @PostMapping("/list")
    public TableDataInfo list(@RequestBody WbSysMenu wbSysMenu) {
        List<WbSysMenu> list = wbSysMenuService.selectWbSysMenuList(wbSysMenu);

        return getDataTable(list);
    }


    /**
     * 获取菜单详细信息
     */
    @GetMapping(value = "/{menuId}")
    public AjaxResult getInfo(@PathVariable("menuId") Long menuId) {
        return AjaxResult.success(wbSysMenuService.selectWbSysMenuByMenuId(menuId));

    }

    /**
     * 新增修改
     */
    @PostMapping("/saveOrUpdate")
    public AjaxResult saveOrUpdate(@RequestBody WbSysMenu wbSysMenu) {
        return AjaxResult.success();
    }

    /**
     * 新增菜单
     */
    @PostMapping("/add")
    public AjaxResult add(@RequestBody WbSysMenu wbSysMenu) {
        return AjaxResult.success(wbSysMenuService.insertWbSysMenu(wbSysMenu));
    }

    /**
     * 修改菜单
     */
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody WbSysMenu wbSysMenu) {
        return AjaxResult.success(wbSysMenuService.updateWbSysMenu(wbSysMenu));
    }

    /**
     * 删除菜单
     */
    @GetMapping("/{menuIds}")
    public AjaxResult remove(@PathVariable Long[] menuIds) {
        return AjaxResult.success(wbSysMenuService.deleteWbSysMenuByMenuIds(menuIds));
    }
}
