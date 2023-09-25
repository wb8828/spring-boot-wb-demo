package com.spring.demo.generator.mapper;


import com.spring.demo.generator.domain.CreateCodeGenConfig;
import com.spring.demo.generator.domain.GenGlobalConfig;
import com.spring.demo.generator.domain.GenTable;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 业务 数据层
 */
public interface GenTableMapper {
    /**
     * 查询业务列表
     *
     * @param genTable 业务信息
     * @return 业务集合
     */
    public List<GenTable> selectGenTableList(GenTable genTable);

    /**
     * 查询业务列表
     *
     * @param tableNames 表名
     * @return 业务集合
     */
    public List<GenTable> selectGenTableListByTableNames(String[] tableNames);

    /**
     * 查询据库列表
     *
     * @param genTable 业务信息
     * @return 数据库表集合
     */
    public List<GenTable> selectDbTableList(GenTable genTable);

    /**
     * 查询据库列表
     *
     * @param tableNames 表名称组
     * @return 数据库表集合
     */
    public List<GenTable> selectDbTableListByNames(String[] tableNames);

    /**
     * 查询所有表信息
     *
     * @return 表信息集合
     */
    public List<GenTable> selectGenTableAll();

    /**
     * 查询表ID业务信息
     *
     * @param id 业务ID
     * @return 业务信息
     */
    public GenTable selectGenTableById(Long id);

    /**
     * 查询表名称业务信息
     *
     * @param tableName 表名称
     * @return 业务信息
     */
    public GenTable selectGenTableByName(String tableName);

    /**
     * 新增业务
     *
     * @param genTable 业务信息
     * @return 结果
     */
    public int insertGenTable(GenTable genTable);

    /**
     * 修改业务
     *
     * @param genTable 业务信息
     * @return 结果
     */
    public int updateGenTable(GenTable genTable);

    /**
     * 批量删除业务
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGenTableByIds(Long[] ids);

    /**
     * 批量删除业务
     *
     * @param ids 需要删除的数据表名
     * @return 结果
     */
    public int deleteGenTableByTableNames(String[] ids);

    public CreateCodeGenConfig genConfig();

    public int insertGenConfig(CreateCodeGenConfig genConfig);

    /**
     * 修改【请填写功能名称】
     *
     * @param genConfig 【请填写功能名称】
     * @return 结果
     */
    public int updateGenConfig(CreateCodeGenConfig genConfig);

    public GenGlobalConfig selectGenGlobalConfigById(String id);

    public int insertGenGlobalConfig(GenGlobalConfig genGlobalConfig);

    /**
     * 修改菜单
     *
     * @param genGlobalConfig 菜单
     * @return 结果
     */
    public int updateGenGlobalConfig(GenGlobalConfig genGlobalConfig);


    @Select("SELECT table_name FROM information_schema.TABLES WHERE table_schema =  DATABASE()")
    List<String> getTableNames();

    @Select("SELECT COLUMN_NAME FROM information_schema. COLUMNS WHERE TABLE_SCHEMA = DATABASE() AND TABLE_NAME = #{tableName,jdbcType=VARCHAR}")
    List<String> getFieldNames(String tableName);

    Object ext(@Param("sql") String sql);
}
