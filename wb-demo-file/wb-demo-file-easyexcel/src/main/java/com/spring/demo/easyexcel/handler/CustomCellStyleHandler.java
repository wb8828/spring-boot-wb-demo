package com.spring.demo.easyexcel.handler;

import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.write.handler.AbstractCellWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;

import java.util.List;

/**
 * 单元格创建处理器
 * 示例：身高大于180的变红色
 */
@Slf4j
public class CustomCellStyleHandler extends AbstractCellWriteHandler {

    @Override
    public void beforeCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row, Head head, Integer columnIndex, Integer relativeRowIndex, Boolean isHead) {
    }

    @Override
    public void afterCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {
    }

    @Override
    public void afterCellDataConverted(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, CellData cellData, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {
    }

    @Override
    public void afterCellDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, List<CellData> cellDataList, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {
        // 增加超链接
        if (isHead && cell.getColumnIndex() == 0) {
            CreationHelper createHelper = writeSheetHolder.getSheet().getWorkbook().getCreationHelper();
            Hyperlink hyperlink = createHelper.createHyperlink(HyperlinkType.URL);
            hyperlink.setAddress("https://github.com/alibaba/easyexcel");
            cell.setHyperlink(hyperlink);
        }

        if (isHead || cell == null) {
            return;
        }
        int columnIndex = cell.getColumnIndex();
        if (columnIndex == 3 && cell.getNumericCellValue() > 180.00f) {
            XSSFCellStyle style = (XSSFCellStyle) cell.getRow().getSheet().getWorkbook().createCellStyle();
            setFontStyle(cell, style);
            cell.setCellStyle(style);
        }
        // 增加下拉框
        if (columnIndex == 2){
            CellRangeAddressList cellRangeAddressList = new CellRangeAddressList(cell.getRowIndex(), cell.getRowIndex(), columnIndex, columnIndex);
            DataValidationHelper helper = writeSheetHolder.getSheet().getDataValidationHelper();
            DataValidationConstraint constraint = helper.createExplicitListConstraint(new String[] {"男", "女"});
            DataValidation dataValidation = helper.createValidation(constraint, cellRangeAddressList);
            writeSheetHolder.getSheet().addValidationData(dataValidation);
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