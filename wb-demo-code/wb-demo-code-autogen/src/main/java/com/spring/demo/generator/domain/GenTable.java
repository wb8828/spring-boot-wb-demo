package com.spring.demo.generator.domain;


import com.spring.demo.generator.constant.GenConstants;
import com.spring.demo.generator.support.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.List;

/**
 * 业务表 gen_table
 * 
 */
@Getter
@Setter
public class GenTable extends BaseEntity implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long tableId;

    /** 表名称 */
    private String tableName;

    /** 表描述 */
    private String tableComment;

    /** 关联父表的表名 */
    private String subTableName;

    /** 本表关联父表的外键名 */
    private String subTableFkName;

    /** 实体类名称(首字母大写) */
    private String className;

    /** 使用的模板（crud单表操作 tree树表操作 sub主子表操作） */
    private String tplCategory;

    /** 生成包路径 */
    private String packageName;

    /** 生成模块名 */
    private String moduleName;

    /** 生成业务名 */
    private String businessName;

    /** 生成功能名 */
    private String functionName;

    /** 生成作者 */
    private String functionAuthor;

    /** 生成代码方式（0zip压缩包 1自定义路径） */
    private String genType;

    /** 生成路径（不填默认项目路径） */
    private String genPath;

    /** 主键信息 */
    private GenTableColumn pkColumn;

    /** 子表信息 */
    private GenTable subTable;

    /** 表列信息 */
    private List<GenTableColumn> columns;

    /** 其它生成选项 */
    private String options;

    /** 树编码字段 */
    private String treeCode;

    /** 树父编码字段 */
    private String treeParentCode;

    /** 树名称字段 */
    private String treeName;

    /** 上级菜单ID字段 */
    private String parentMenuId;

    /** 上级菜单名称字段 */
    private String parentMenuName;

    public void setTableId(Long tableId)
    {
        this.tableId = tableId;
    }

    public void setTableName(String tableName)
    {
        this.tableName = tableName;
    }

    public void setTableComment(String tableComment)
    {
        this.tableComment = tableComment;
    }

    public void setSubTableName(String subTableName)
    {
        this.subTableName = subTableName;
    }

    public void setSubTableFkName(String subTableFkName)
    {
        this.subTableFkName = subTableFkName;
    }

    public void setClassName(String className)
    {
        this.className = className;
    }

    public void setTplCategory(String tplCategory)
    {
        this.tplCategory = tplCategory;
    }

    public void setPackageName(String packageName)
    {
        this.packageName = packageName;
    }

    public void setModuleName(String moduleName)
    {
        this.moduleName = moduleName;
    }

    public void setBusinessName(String businessName)
    {
        this.businessName = businessName;
    }

    public void setFunctionName(String functionName)
    {
        this.functionName = functionName;
    }

    public void setFunctionAuthor(String functionAuthor)
    {
        this.functionAuthor = functionAuthor;
    }

    public void setGenType(String genType)
    {
        this.genType = genType;
    }

    public void setGenPath(String genPath)
    {
        this.genPath = genPath;
    }

    public void setPkColumn(GenTableColumn pkColumn)
    {
        this.pkColumn = pkColumn;
    }

    public void setSubTable(GenTable subTable)
    {
        this.subTable = subTable;
    }

    public void setColumns(List<GenTableColumn> columns)
    {
        this.columns = columns;
    }

    public void setOptions(String options)
    {
        this.options = options;
    }

    public void setTreeCode(String treeCode)
    {
        this.treeCode = treeCode;
    }

    public void setTreeParentCode(String treeParentCode)
    {
        this.treeParentCode = treeParentCode;
    }

    public void setTreeName(String treeName)
    {
        this.treeName = treeName;
    }

    public void setParentMenuId(String parentMenuId)
    {
        this.parentMenuId = parentMenuId;
    }

    public void setParentMenuName(String parentMenuName)
    {
        this.parentMenuName = parentMenuName;
    }

    public boolean isSub()
    {
        return isSub(this.tplCategory);
    }

    public static boolean isSub(String tplCategory)
    {
        return tplCategory != null && StringUtils.equals(GenConstants.TPL_SUB, tplCategory);
    }

    public boolean isTree()
    {
        return isTree(this.tplCategory);
    }

    public static boolean isTree(String tplCategory)
    {
        return tplCategory != null && StringUtils.equals(GenConstants.TPL_TREE, tplCategory);
    }

    public boolean isCrud()
    {
        return isCrud(this.tplCategory);
    }

    public static boolean isCrud(String tplCategory)
    {
        return tplCategory != null && StringUtils.equals(GenConstants.TPL_CRUD, tplCategory);
    }

    public boolean isSuperColumn(String javaField)
    {
        return isSuperColumn(this.tplCategory, javaField);
    }

    public static boolean isSuperColumn(String tplCategory, String javaField)
    {
        if (isTree(tplCategory))
        {
            return StringUtils.equalsAnyIgnoreCase(javaField,
                    ArrayUtils.addAll(GenConstants.TREE_ENTITY, GenConstants.BASE_ENTITY));
        }
        return StringUtils.equalsAnyIgnoreCase(javaField, GenConstants.BASE_ENTITY);
    }
}