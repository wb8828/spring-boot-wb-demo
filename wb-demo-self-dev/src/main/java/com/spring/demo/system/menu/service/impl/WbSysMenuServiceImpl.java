package com.spring.demo.system.menu.service.impl;


import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.spring.demo.system.menu.domain.WbSysMenu;
import com.spring.demo.system.menu.mapper.WbSysMenuMapper;
import com.spring.demo.system.menu.service.IWbSysMenuService;
import com.spring.demo.system.menu.vo.MetaVo;
import com.spring.demo.system.menu.vo.RouterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * 菜单Service业务层处理
 *
 * @author wb
 * @date 2023-03-16
 */
@Service
public class WbSysMenuServiceImpl implements IWbSysMenuService {
    @Autowired
    private WbSysMenuMapper wbSysMenuMapper;

    /**
     * 查询菜单
     *
     * @param menuId 菜单主键
     * @return 菜单
     */
    @Override
    public WbSysMenu selectWbSysMenuByMenuId(Long menuId) {
        return wbSysMenuMapper.selectWbSysMenuByMenuId(menuId);
    }

    /**
     * 查询菜单列表
     *
     * @param wbSysMenu 菜单
     * @return 菜单
     */
    @Override
    public List<WbSysMenu> selectWbSysMenuList(WbSysMenu wbSysMenu) {
        return wbSysMenuMapper.selectWbSysMenuList(wbSysMenu);
    }

    /**
     * 新增菜单
     *
     * @param wbSysMenu 菜单
     * @return 结果
     */
    @Override
    public int insertWbSysMenu(WbSysMenu wbSysMenu) {
        wbSysMenu.setCreateTime(new Date());
        return wbSysMenuMapper.insertWbSysMenu(wbSysMenu);
    }

    /**
     * 修改菜单
     *
     * @param wbSysMenu 菜单
     * @return 结果
     */
    @Override
    public int updateWbSysMenu(WbSysMenu wbSysMenu) {
        wbSysMenu.setUpdateTime(new Date());
        return wbSysMenuMapper.updateWbSysMenu(wbSysMenu);
    }

    /**
     * 批量删除菜单
     *
     * @param menuIds 需要删除的菜单主键
     * @return 结果
     */
    @Override
    public int deleteWbSysMenuByMenuIds(Long[] menuIds) {
        return wbSysMenuMapper.deleteWbSysMenuByMenuIds(menuIds);
    }

    /**
     * 删除菜单信息
     *
     * @param menuId 菜单主键
     * @return 结果
     */
    @Override
    public int deleteWbSysMenuByMenuId(Long menuId) {
        return wbSysMenuMapper.deleteWbSysMenuByMenuId(menuId);
    }

    /**
     * 新增修改菜单信息
     *
     * @param wbSysMenu 菜单
     * @return 结果
     */
    @Transactional
    @Override
    public boolean saveOrUpdate(WbSysMenu wbSysMenu) {
        if ("".equals(wbSysMenu.getMenuId()) || wbSysMenu.getMenuId() == null) {
            return insertWbSysMenu(wbSysMenu) > 0;
        } else {
            return updateWbSysMenu(wbSysMenu) > 0;
        }

    }

    @Override
    public List<WbSysMenu> selectMenuTreeByUserId(String userId) {
        List<WbSysMenu> wbSysMenus = wbSysMenuMapper.selectMenuTreeByPId(0L);
        children(wbSysMenus);
        return wbSysMenus;
    }

    @Override
    public List<RouterVo> buildMenus(List<WbSysMenu> menus) {

        List<RouterVo> routers = new LinkedList<RouterVo>();
        for (WbSysMenu menu : menus) {
            RouterVo router = new RouterVo();
            router.setHidden("1".equals(menu.getVisible()));
            router.setName(menu.getMenuName());
            router.setPath(menu.getPath());
            router.setComponent(menu.getComponent());
            router.setQuery(menu.getQuery());
            router.setMeta(new MetaVo(menu.getMenuName(), menu.getIcon(), menu.getPath()));
            List<WbSysMenu> cMenus = menu.getChildren();
            if (CollectionUtils.isNotEmpty(cMenus)) {
                router.setAlwaysShow(true);
                router.setRedirect("noRedirect");
                router.setChildren(buildMenus(cMenus));
            }
            routers.add(router);
        }

        return routers;
    }


    private void children(List<WbSysMenu> sysMenus) {
        sysMenus.stream().forEach(e -> {
            List<WbSysMenu> index = wbSysMenuMapper.selectMenuTreeByPId(e.getMenuId());
            if (index != null && index.size() > 0) {
                e.setChildren(index);
                children(index);
            }
        });
    }
}
