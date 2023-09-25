package com.spring.demo.easyexcel.handler;

import com.alibaba.excel.write.handler.AbstractRowWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomRowStyleHandler extends AbstractRowWriteHandler {
    private static final Logger log = LoggerFactory.getLogger(CustomRowStyleHandler.class);

    @Override
    public void afterRowDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row, Integer relativeRowIndex, Boolean isHead) {
        if (isHead) {
            return;
        }
        try {
            int colIndex = 4;
            Cell cell;
            //边框样式
            cell = row.getCell(colIndex) == null ? row.createCell(colIndex) : row.getCell(colIndex);
            if (cell != null) {
                if (cell.getNumericCellValue() > 0) {
                    XSSFCellStyle style = (XSSFCellStyle) cell.getRow().getSheet().getWorkbook().createCellStyle();
                    setFontStyle(cell, style);
                    style.setBorderTop(BorderStyle.THIN); // 上边框
                    style.setBorderBottom(BorderStyle.THIN); // 下边框
                    style.setBorderLeft(BorderStyle.THIN); // 左边框
                    style.setBorderRight(BorderStyle.THIN);  // 右边框

                    cell.setCellStyle(style);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void setFontStyle(Cell cell, XSSFCellStyle style) {
        XSSFFont font;
        //样式存在字体对象时，使用原有的字体对象
        if (style.getFontIndex() != 0) {
            font = style.getFont();
        }
        //样式不存在字体对象时，创建字体对象
        else {
            font = (XSSFFont) cell.getRow().getSheet().getWorkbook().createFont();
            //默认字体为宋体
            font.setFontName("宋体");
            font.setFontHeightInPoints((short) 10);
//            font.setFontHeight((short) 10);
        }
        font.setColor((short) 10);
        style.setFont(font);

        style.setAlignment(HorizontalAlignment.CENTER);//设置水平居中
        style.setVerticalAlignment(VerticalAlignment.CENTER); // 垂直居中
    }

}