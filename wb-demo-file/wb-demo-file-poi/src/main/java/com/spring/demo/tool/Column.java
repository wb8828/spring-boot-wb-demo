package com.spring.demo.tool;

import java.util.ArrayList;
import java.util.List;


public class Column {

    int totalRow;
    int totalCol;
    int row;//excel第几行
    int col;//excel第几列
    int rLen; //excel 跨多少行
    int cLen;//excel跨多少列
    //单元格内容
    private String content;
    //字段名称，用户导出表格时反射调用
    private String fieldName;
    //这个单元格的集合
    private List<Column> listTpamscolumn = new ArrayList<Column>();
    private boolean hasChilren;//是否有子节点

    private int treeStep;//树的级别 从0开始

    private String id;

    private String pid;

    public Column() {
    }

    ;

    public Column(String content, String fieldName) {
        this.content = content;
        this.fieldName = fieldName;
    }

    public Column(String fieldName, String content, int treeStep) {
        this.treeStep = treeStep;
        this.fieldName = fieldName;
        this.content = content;
    }

    public int getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(int totalRow) {
        this.totalRow = totalRow;
    }

    public int getTotalCol() {
        return totalCol;
    }

    public void setTotalCol(int totalCol) {
        this.totalCol = totalCol;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isHasChilren() {
        return hasChilren;
    }

    public void setHasChilren(boolean hasChilren) {
        this.hasChilren = hasChilren;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public List<Column> getListTpamscolumn() {
        return listTpamscolumn;
    }

    public void setListTpamscolumn(List<Column> listTpamscolumn) {
        this.listTpamscolumn = listTpamscolumn;
    }

    public int getTreeStep() {
        return treeStep;
    }

    public void setTreeStep(int treeStep) {
        this.treeStep = treeStep;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getrLen() {
        return rLen;
    }

    public void setrLen(int rLen) {
        this.rLen = rLen;
    }

    public int getcLen() {
        return cLen;
    }

    public void setcLen(int cLen) {
        this.cLen = cLen;
    }

    @Override
    public String toString() {
        return "Column{" +
                "content='" + content + '\'' +
                ", fieldName='" + fieldName + '\'' +
                ", listTpamscolumn=" + listTpamscolumn +
                ", totalRow=" + totalRow +
                ", totalCol=" + totalCol +
                ", row=" + row +
                ", col=" + col +
                ", rLen=" + rLen +
                ", cLen=" + cLen +
                ", hasChilren=" + hasChilren +
                ", treeStep=" + treeStep +
                ", id='" + id + '\'' +
                ", pid='" + pid + '\'' +
                '}';
    }
}