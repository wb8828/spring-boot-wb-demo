package com.spring.demo.itext;

import com.itextpdf.text.*;
import com.itextpdf.text.html.WebColors;
import com.itextpdf.text.pdf.*;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author: wb
 * @description:
 * @date: 2023-04-12 09:23
 */
public class PdfGenerator {
    public void generatePdf(OutputStream outputStream, String title, String[][] data) {
        Document document = null;
        PdfWriter pdfWriter = null;
        try {
            // 创建 PDF 文档对象
            document = new Document(PageSize.A4);
            // 创建 PDF 写入器
            pdfWriter = PdfWriter.getInstance(document, outputStream);
            // 打开 PDF 文档对象
            document.open();
            PdfDestination zoom = new PdfDestination(PdfDestination.XYZ, 0, 0, 0, 1f);
            pdfWriter.setOpenAction(PdfAction.gotoLocalPage(1, zoom, pdfWriter));
            //设置中文
            BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            //普通字体
            Font fontChinese = new Font(bfChinese, 20, Font.NORMAL);
            fontChinese.setColor(BaseColor.BLACK);
//            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20, BaseColor.BLACK);
            Paragraph titleParagraph = new Paragraph(title, fontChinese);
            titleParagraph.setAlignment(Element.ALIGN_CENTER);
            document.add(titleParagraph);
            // 添加表格
            PdfPTable table = createTable(data);
            document.add(table);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (document != null) {
                // 关闭 PDF 文档对象
                document.close();
            }
            if (pdfWriter != null) {
                // 关闭 PDF 写入器
                pdfWriter.close();
            }
        }
    }

    private PdfPTable createTable(String[][] data) throws DocumentException, IOException {
        //设置中文
        BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        //普通字体
        Font fontChinese = new Font(bfChinese, 12, Font.NORMAL);

        // 创建表格对象
        PdfPTable table = new PdfPTable(3);
        // 设置表格宽度和边距
        table.setWidthPercentage(100);
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);
        // 创建表头单元格
        PdfPCell headerCell1 = new PdfPCell(new Phrase("安全工器具台账信息字段名称", fontChinese));
        headerCell1.setColspan(1);
        headerCell1.setMinimumHeight(20f); // 设置单元格最小高度
        headerCell1 = setCellLeft(headerCell1);
        PdfPCell headerCell2 = new PdfPCell(new Phrase("台账信息不规范字段信息评价标准", fontChinese));
        headerCell2.setColspan(2);
        headerCell2.setMinimumHeight(20f);// 设置单元格最小高度
        headerCell2 = setCellLeft(headerCell2);
        // 设置表头单元格样式
        BaseColor baseHeaderColor = baseColor(156, 194, 229); // 设置自定义颜色
        headerCell1.setBackgroundColor(baseHeaderColor);
        headerCell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        headerCell2.setBackgroundColor(baseHeaderColor);
        headerCell2.setHorizontalAlignment(Element.ALIGN_CENTER);
        // 添加表头单元格到表格中
        table.addCell(headerCell1);
        table.addCell(headerCell2);

        for (String[] row : data) {
            Phrase elements = new Phrase();
            if (row[0].equals("A2")) {
                Font font = new Font(bfChinese, 12, Font.NORMAL);
                font.setStyle(Font.BOLD);// 字体加粗
                elements = new Phrase(row[0], fontChinese);
                elements.add(new Chunk("12345", font)); // 模拟加粗某个字体
            } else {
                elements = new Phrase(row[0], fontChinese);
            }

            PdfPCell dataCell1 = new PdfPCell(elements);
            dataCell1.setColspan(1);
            PdfPCell dataCell2 = new PdfPCell(new Phrase(row[1], fontChinese));
            dataCell2.setColspan(2);
            // 设置数据单元格样式
            dataCell1.setVerticalAlignment(Element.ALIGN_MIDDLE); // 垂直
            dataCell1.setHorizontalAlignment(Element.ALIGN_CENTER); // 水平
            dataCell2.setVerticalAlignment(Element.ALIGN_CENTER);
            dataCell2.setHorizontalAlignment(Element.ALIGN_LEFT);
            // 添加数据单元格到表格中
            table.addCell(dataCell1);
            table.addCell(dataCell2);
        }
        return table;
    }

    /**
     * 设置垂直居中，水平居左
     *
     * @param dataCell
     * @return
     */
    private PdfPCell setCellLeft(PdfPCell dataCell) {
        dataCell.setVerticalAlignment(Element.ALIGN_MIDDLE); // 垂直
        dataCell.setHorizontalAlignment(Element.ALIGN_LEFT); // 水平
        return dataCell;
    }

    /**
     * 根据RGB获取颜色
     *
     * @param red   红(R:0~255)
     * @param green 绿(R:0~255)
     * @param blue  蓝(R:0~255)
     * @return
     */
    private BaseColor baseColor(int red, int green, int blue) {
        BaseColor baseHeaderColor = new BaseColor(red, green, blue); // 设置自定义颜色
        return baseHeaderColor;
    }

    /**
     * 根据HEX获取颜色
     *
     * @param HEX 值
     * @return
     */
    private BaseColor baseColor(String HEX) {
        BaseColor myColor = WebColors.getRGBColor("#9cc2e5"); // 设置自定义颜色
        return myColor;
    }


    public static void main(String[] args) {
        String str = "123444个体防护装备7777777";

    }
}