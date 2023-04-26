package com.spring.demo.system.menu.mapper;


import com.spring.demo.system.menu.domain.WbSysMenu;

import java.util.List;

/**
 * 菜单Mapper接口
 * 
 * @author wb
 * @date 2023-03-16
 */
public interface WbSysMenuMapper 
{
    /**
     * 查询菜单
     * 
     * @param menuId 菜单主键
     * @return 菜单
     */
    public WbSysMenu selectWbSysMenuByMenuId(Long menuId);

    /**
     * 查询菜单列表
     * 
     * @param wbSysMenu 菜单
     * @return 菜单集合
     */
    public List<WbSysMenu> selectWbSysMenuList(WbSysMenu wbSysMenu);

    /**
     * 新增菜单
     * 
     * @param wbSysMenu 菜单
     * @return 结果
     */
    public int insertWbSysMenu(WbSysMenu wbSysMenu);

    /**
     * 修改菜单
     * 
     * @param wbSysMenu 菜单
     * @return 结果
     */
    public int updateWbSysMenu(WbSysMenu wbSysMenu);

    /**
     * 删除菜单
     * 
     * @param menuId 菜单主键
     * @return 结果
     */
    public int deleteWbSysMenuByMenuId(Long menuId);

    /**
     * 批量删除菜单
     * 
     * @param menuIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWbSysMenuByMenuIds(Long[] menuIds);


    public List<WbSysMenu> selectMenuTreeByUserId(String userId);


    public List<WbSysMenu> selectMenuTreeByPId(Long pid);
}
