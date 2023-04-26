package com.spring.demo.system.setting.controller;


import com.spring.demo.AjaxResult;
import com.spring.demo.pojo.BasePageModel;
import com.spring.demo.pojo.TableDataInfo;
import com.spring.demo.system.setting.domain.WbSysSetting;
import com.spring.demo.system.setting.service.IWbSysSettingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 菜单Controller
 *
 * @author wb
 * @date 2023-03-17
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/setting")
public class WbSysSettingController extends BasePageModel {
    private final IWbSysSettingService wbSysSettingService;


    /**
     * 查询菜单列表
     */
    @PostMapping("/list")
    public TableDataInfo list(@RequestBody WbSysSetting wbSysSetting) {
        List<WbSysSetting> list = wbSysSettingService.selectWbSysSettingList(wbSysSetting);

        return getDataTable(list);
    }


    /**
     * 获取菜单详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(wbSysSettingService.selectWbSysSettingById(id));

    }

    /**
     * 新增修改
     */
    @PostMapping("/saveOrUpdate")
    public AjaxResult saveOrUpdate(@RequestBody WbSysSetting wbSysSetting) {
        return AjaxResult.success();
    }

    /**
     * 新增菜单
     */
    @PostMapping("/add")
    public AjaxResult add(@RequestBody WbSysSetting wbSysSetting) {
        return AjaxResult.success(wbSysSettingService.insertWbSysSetting(wbSysSetting));
    }

    /**
     * 修改菜单
     */
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody WbSysSetting wbSysSetting) {
        return AjaxResult.success(wbSysSettingService.updateWbSysSetting(wbSysSetting));
    }

    /**
     * 删除菜单
     */
    @GetMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return AjaxResult.success(wbSysSettingService.deleteWbSysSettingByIds(ids));
    }
}
