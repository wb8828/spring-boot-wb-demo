package com.spring.demo.system.menu.domain;


import com.spring.demo.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单对象 wb_sys_menu
 *
 * @author wb
 * @date 2023-03-16
 */
@ToString
@Data
@EqualsAndHashCode(callSuper = true)
public class WbSysMenu extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID
     */
    private Long menuId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 父菜单ID
     */
    private Long parentId;

    /**
     * 显示顺序
     */
    private Integer orderNum;

    /**
     * 路由地址
     */
    private String path;

    /**
     * 组件路径
     */
    private String component;

    /**
     * 路由参数
     */
    private String query;

    /**
     * 是否为外链（0是 1否）
     */
    private Integer isFrame;

    /**
     * 是否缓存（0缓存 1不缓存）
     */
    private Integer isCache;

    /**
     * 菜单类型（M目录 C菜单 F按钮）
     */
    private String menuType;

    /**
     * 菜单状态（0显示 1隐藏）
     */
    private String visible;

    /**
     * 菜单状态（0正常 1停用）
     */
    private String status;

    /**
     * 权限标识
     */
    private String perms;

    /**
     * 菜单图标
     */
    private String icon;


    /**
     * 子菜单
     */
    private List<WbSysMenu> children = new ArrayList<WbSysMenu>();
}