package com.spring.demo.system.setting.domain;


import com.spring.demo.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 菜单对象 wb_sys_setting
 *
 * @author wb
 * @date 2023-03-17
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class WbSysSetting extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 是否开启动态表头
     */
    private Boolean dynamicTitle;


    /**
     * 用户id
     */
    private String userId;
}
