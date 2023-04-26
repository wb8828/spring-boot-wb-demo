package com.spring.demo.system.menu.service;


import com.spring.demo.system.menu.domain.WbSysMenu;
import com.spring.demo.system.menu.vo.RouterVo;

import java.util.List;

/**
 * 菜单Service接口
 *
 * @author wb
 * @date 2023-03-16
 */
public interface IWbSysMenuService {
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
     * 批量删除菜单
     *
     * @param menuIds 需要删除的菜单主键集合
     * @return 结果
     */
    public int deleteWbSysMenuByMenuIds(Long[] menuIds);

    /**
     * 删除菜单信息
     *
     * @param menuId 菜单主键
     * @return 结果
     */
    public int deleteWbSysMenuByMenuId(Long menuId);

    /**
     * 新增修改菜单信息
     *
     * @param wbSysMenu 菜单
     * @return 结果
     */
    public boolean saveOrUpdate(WbSysMenu wbSysMenu);


    List<WbSysMenu> selectMenuTreeByUserId(String userId);

    public List<RouterVo> buildMenus(List<WbSysMenu> menus);
}
