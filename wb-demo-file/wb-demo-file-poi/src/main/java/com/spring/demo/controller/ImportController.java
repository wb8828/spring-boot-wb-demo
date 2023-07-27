package com.spring.demo.controller;

import com.spring.demo.pojo.TestImportFilePOJO;
import com.spring.demo.util.TestImportExcelUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: wb
 * @description: 导入文件记录类
 * @date: 2023-04-13 14:18
 */
@RestController
public class ImportController {

    @PostMapping("/testImportFileToPOJO")
    public void testImportFileToPOJO(MultipartFile file, HttpServletRequest request) {
        try {
            List<TestImportFilePOJO> importData = TestImportExcelUtils.ExcelTolist(0, 2, 0, TestImportFilePOJO.class, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}