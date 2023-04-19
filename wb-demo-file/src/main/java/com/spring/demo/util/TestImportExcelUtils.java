package com.spring.demo.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: wb
 * @description:
 * @date: 2023-04-13 14:23
 */
public class TestImportExcelUtils {
    /**
     * 附件按照实体类顺序字段及表格列顺序一一转换为实体列集合
     *
     * @param invalidNum  从第几列开始读取下标从0开始
     * @param startRowNum 从第几行开始读取 下标从1开始
     * @param sheetNum    读取第几个sheet
     * @param cls         实体列
     * @param file        上传的文件
     * @param <T>
     * @return 实体类集合
     * @throws Exception 异常
     */
    public static <T> List<T> ExcelTolist(int invalidNum, int startRowNum, int sheetNum, Class<T> cls, MultipartFile file) throws Exception {
        // 定义要返回的list
        List<T> resultList = new ArrayList<T>();
        // 创建Excel,读取文件内容
        Workbook workbook = null;

        try {
            // 上传的文件名
            String fileName = file.getOriginalFilename();
            // 根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
            if (fileName.toLowerCase().endsWith("xls")) {
                // 2003
                workbook = new HSSFWorkbook(file.getInputStream());
            } else if (fileName.toLowerCase().endsWith("xlsx")) {
                // 2007
                workbook = new XSSFWorkbook(file.getInputStream());
            }
            // 为1时，不读取第一行标题;为2时，不读取第二行属性列;
            int firstRowNum = startRowNum;
            Sheet sheet = workbook.getSheetAt(sheetNum);
            // 获取表中最后一行
            int lastRowNum = sheet.getPhysicalNumberOfRows();
            // 只有一行数据的话，当成表头，不再进行数据处理
            if (lastRowNum < 1) {
                return resultList;
            }
            // 循环处理数据行
            Row row = null;
            int breakFlag = 0;
            boolean isBreak = false;
            for (int j = firstRowNum; j <= lastRowNum; j++) {
                if (!isBreak) {//重新计算
                    breakFlag = 0;
                }
                boolean flag = true; // 判断cellValue的值是否都为null
                row = sheet.getRow(j);
                if (row == null || breakFlag > 30) { // 连续超过30条行为空的下面的就不解析了
                    break;
                }
                if (!checkData(row, 13)) { // 举例验证前14列一直为空
                    isBreak = false;
                } else {
                    breakFlag++;
                    isBreak = true;
                    continue;
                }

                // 获取Java实例
                T entity = cls.newInstance();
                // 获得JavaBean全部属性
                Field[] fields = cls.getDeclaredFields();
                for (int k = invalidNum; k < fields.length; k++) {
                    fields[k].setAccessible(true);
                    PropertyDescriptor pd = new PropertyDescriptor(fields[k].getName(), cls);
                    // 获得set方法
                    Method setMethod = pd.getWriteMethod();
                    // 操控该对象属性的set方法，从而设置属性值
                    String value = getCellValue(row.getCell(k - invalidNum));
                    if (flag && !StringUtils.isEmpty(value)) flag = false;
                    if (StringUtils.isBlank(value)) value = null;
                    setMethod.invoke(entity, value);
                }
                if (flag) continue;
                resultList.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (workbook != null) {
                workbook.close();
            }
        }
        return resultList;
    }


    private static boolean checkData(Row row, int index) {
        int isInter = -1;
        for (int i = 0; i <= index; i++) {
            Cell cell = row.getCell(i);
            if (cell == null || StringUtils.isBlank(getCellValue(cell))) {
                isInter++;
            }
        }
        if (index == isInter) {
            return true;
        }
        return false;
    }


    private static String getCellValue(Cell cell) {
        if (cell == null) {
            return null;
        }
        String cellValue = null;
        if (cell.getCellTypeEnum() == CellType.NUMERIC) {
            if (HSSFDateUtil.isCellDateFormatted(cell)) {
                Date dateCellValue = cell.getDateCellValue();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                return formatter.format(dateCellValue);
            }
        }
        // 设置单元格属性，直接按照String类型
        cell.setCellType(CellType.STRING);
        cellValue = cell.getStringCellValue();

        return cellValue;
    }
}