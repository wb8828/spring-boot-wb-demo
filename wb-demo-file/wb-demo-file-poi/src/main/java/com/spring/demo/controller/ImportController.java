package com.spring.demo.controller;

import com.spring.demo.pojo.TestImportFilePOJO;
import com.spring.demo.util.TestImportExcelUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URLEncoder;
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

    @GetMapping("/flow")
    public static ResponseEntity<byte[]> flow() throws IOException {
        File file = new File("C:\\Users\\caowe\\Desktop\\qwe.docx");
        InputStream in = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        StreamUtils.copy(in, bos);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", URLEncoder.encode("qwe.docx", "UTF-8"));
        return new ResponseEntity<byte[]>(bos.toByteArray(), headers, HttpStatus.OK);
    }

}