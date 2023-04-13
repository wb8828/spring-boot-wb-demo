package com.spring.demo.controller;

import com.spring.demo.itext.PdfGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author: wb
 * @description: iText技术操作PDF技术
 * @date: 2023-04-11 14:05
 */
@RestController
@RequestMapping(value = "/itext")
public class ITextController {


    /**
     * 测试导出PDF
     *
     * @param response 响应
     */
    @GetMapping("/export/pdfTable")
    public void exportPdf(HttpServletResponse response) {
        String title = "安全工器具台账信息数据质量评价标准";
        String[][] data = {{"实物ID", "1.台账信息中实物id信息缺失；\n2.全省范围内，台账信息中实物 id 重复；\n3.评价范围：个体防护装备（不含防护眼镜）、绝缘安全工器具、登高工器具三大类全部安全工器具。"}, {"A2", "B2"}, {"A3", "B3"}};
        try {
            // 设置响应头
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=example.pdf");
            // 生成 PDF 文件
            PdfGenerator pdfGenerator = new PdfGenerator();
            // 输出 PDF 文件
            OutputStream outputStream = response.getOutputStream();
            pdfGenerator.generatePdf(outputStream, title, data);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}