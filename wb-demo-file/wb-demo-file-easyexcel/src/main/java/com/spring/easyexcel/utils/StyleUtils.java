package com.spring.easyexcel.utils;


import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;

public class StyleUtils {

    public static HorizontalCellStyleStrategy StyleStrategy() {
        // 表头样式策略
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        //设置表头居中对齐
        headWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
        //表头前景色
        headWriteCellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());

//        HSSFWorkbook wb = new HSSFWorkbook();
//        HSSFPalette palette = wb.getCustomPalette();
//        HSSFColor hssfColor = palette.findSimilarColor(245, 245, 245);
//        headWriteCellStyle.setFillForegroundColor(hssfColor.getIndex());
        WriteFont headWriteFont = new WriteFont();
        headWriteFont.setBold(true);
        headWriteFont.setFontName("宋体");
        headWriteFont.setFontHeightInPoints((short) 10);
        headWriteCellStyle.setWriteFont(headWriteFont);

        //2 内容样式策略
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        WriteFont contentWriteFont = new WriteFont();
        //内容字体大小
        contentWriteFont.setFontName("宋体");
        contentWriteFont.setFontHeightInPoints((short) 10);
        contentWriteCellStyle.setWriteFont(contentWriteFont);
        //设置自动换行
        contentWriteCellStyle.setWrapped(true);
        //设置垂直居中
        contentWriteCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        // 头默认了 FillPatternType所以可以不指定。
        //  contentWriteCellStyle.setFillPatternType(FillPatternType.SOLID_FOREGROUND);
        //设置水平居中
        contentWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
        //设置边框样式
        contentWriteCellStyle.setBorderLeft(BorderStyle.THIN);
        contentWriteCellStyle.setBorderTop(BorderStyle.THIN);
        contentWriteCellStyle.setBorderRight(BorderStyle.THIN);
        contentWriteCellStyle.setBorderBottom(BorderStyle.THIN);

        return new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);
    }
}