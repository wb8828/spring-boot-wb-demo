package com.spring.demo.system.setting.service;


import com.spring.demo.system.setting.domain.WbSysSetting;

import java.util.List;

/**
 * 菜单Service接口
 * 
 * @author wb
 * @date 2023-03-17
 */
public interface IWbSysSettingService
{
    /**
     * 查询菜单
     * 
     * @param id 菜单主键
     * @return 菜单
     */
    public WbSysSetting selectWbSysSettingById(Long id);

    /**
     * 查询菜单列表
     * 
     * @param wbSysSetting 菜单
     * @return 菜单集合
     */
    public List<WbSysSetting> selectWbSysSettingList(WbSysSetting wbSysSetting);

    /**
     * 新增菜单
     * 
     * @param wbSysSetting 菜单
     * @return 结果
     */
    public int insertWbSysSetting(WbSysSetting wbSysSetting);

    /**
     * 修改菜单
     * 
     * @param wbSysSetting 菜单
     * @return 结果
     */
    public int updateWbSysSetting(WbSysSetting wbSysSetting);

    /**
     * 批量删除菜单
     * 
     * @param ids 需要删除的菜单主键集合
     * @return 结果
     */
    public int deleteWbSysSettingByIds(Long[] ids);

    /**
     * 删除菜单信息
     * 
     * @param id 菜单主键
     * @return 结果
     */
    public int deleteWbSysSettingById(Long id);

    /**
     * 新增修改菜单信息
     *
     * @param  wbSysSetting 菜单
     * @return 结果
     */
    public boolean saveOrUpdate(WbSysSetting wbSysSetting);
}
