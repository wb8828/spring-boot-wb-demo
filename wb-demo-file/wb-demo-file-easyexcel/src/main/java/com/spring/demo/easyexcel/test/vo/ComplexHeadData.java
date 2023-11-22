package com.spring.demo.easyexcel.test.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class ComplexHeadData {

    @ExcelProperty({"主标题", "二级标题","三级标题1"})
    private String string;

    @ExcelProperty({"主标题", "二级标题","三级标题2"})
    private String str1;

    @ExcelProperty({"主标题", "二级标题","三级标题3"})
    private String str2;



    @ExcelProperty({"主标题", "二级标题2","三级标题4"})
    private String str3;

    @ExcelProperty({"主标题", "二级标题2","三级标题5"})
    private String str4;

    @ExcelProperty({"主标题", "二级标题2","三级标题6"})
    private String str5;
}