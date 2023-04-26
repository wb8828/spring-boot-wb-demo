package com.spring.demo.system.setting.service.impl;


import com.spring.demo.system.setting.domain.WbSysSetting;
import com.spring.demo.system.setting.mapper.WbSysSettingMapper;
import com.spring.demo.system.setting.service.IWbSysSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 菜单Service业务层处理
 * 
 * @author wb
 * @date 2023-03-17
 */
@Service
public class WbSysSettingServiceImpl implements IWbSysSettingService
{
    @Autowired
    private WbSysSettingMapper wbSysSettingMapper;

    /**
     * 查询菜单
     * 
     * @param id 菜单主键
     * @return 菜单
     */
    @Override
    public WbSysSetting selectWbSysSettingById(Long id)
    {
        return wbSysSettingMapper.selectWbSysSettingById(id);
    }

    /**
     * 查询菜单列表
     * 
     * @param wbSysSetting 菜单
     * @return 菜单
     */
    @Override
    public List<WbSysSetting> selectWbSysSettingList(WbSysSetting wbSysSetting)
    {
        return wbSysSettingMapper.selectWbSysSettingList(wbSysSetting);
    }

    /**
     * 新增菜单
     * 
     * @param wbSysSetting 菜单
     * @return 结果
     */
    @Override
    public int insertWbSysSetting(WbSysSetting wbSysSetting)
    {
        return wbSysSettingMapper.insertWbSysSetting(wbSysSetting);
    }

    /**
     * 修改菜单
     * 
     * @param wbSysSetting 菜单
     * @return 结果
     */
    @Override
    public int updateWbSysSetting(WbSysSetting wbSysSetting)
    {
        return wbSysSettingMapper.updateWbSysSetting(wbSysSetting);
    }

    /**
     * 批量删除菜单
     * 
     * @param ids 需要删除的菜单主键
     * @return 结果
     */
    @Override
    public int deleteWbSysSettingByIds(Long[] ids)
    {
        return wbSysSettingMapper.deleteWbSysSettingByIds(ids);
    }

    /**
     * 删除菜单信息
     * 
     * @param id 菜单主键
     * @return 结果
     */
    @Override
    public int deleteWbSysSettingById(Long id)
    {
        return wbSysSettingMapper.deleteWbSysSettingById(id);
    }

    /**
     * 新增修改菜单信息
     *
     * @param  wbSysSetting 菜单
     * @return 结果
     */
    @Transactional
    @Override
    public boolean saveOrUpdate(WbSysSetting wbSysSetting){
        if( "".equals(wbSysSetting.getId()) || wbSysSetting.getId()== null){
            return  insertWbSysSetting( wbSysSetting)  > 0;
       }else{
            return  updateWbSysSetting( wbSysSetting)  > 0;
       }

    }
}
