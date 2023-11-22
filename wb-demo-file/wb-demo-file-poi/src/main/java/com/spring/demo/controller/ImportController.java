package com.spring.demo.controller;

import com.spring.demo.pojo.TestImportFilePOJO;
import com.spring.demo.util.TestImportExcelUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.util.List;

/**
 * 导入文件记录类
 */
@RestController
@Slf4j
public class ImportController {

    /**
     * 返回本地文件的文件流
     *
     * @return 文件流
     * @throws IOException IO异常
     */
    @GetMapping("/flow")
    public static ResponseEntity<byte[]> flow() throws IOException {
        File file = new File("C:\\Users\\caowe\\Desktop\\qwe.docx");
        InputStream in = Files.newInputStream(file.toPath());
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        StreamUtils.copy(in, bos);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", URLEncoder.encode("qwe.docx", "UTF-8"));
        return new ResponseEntity<byte[]>(bos.toByteArray(), headers, HttpStatus.OK);
    }

    /**
     * 文件转换成实体类
     *
     * @param file    文件
     * @param request 请求
     */
    @PostMapping("/importFileToPOJO")
    public void testImportFileToPOJO(MultipartFile file, HttpServletRequest request) {
        try {
            List<TestImportFilePOJO> importData = TestImportExcelUtils.ExcelTolist(0, 2, 0, TestImportFilePOJO.class, file);
        } catch (Exception e) {
            log.error("文件转换成实体类发生错误", e);
        }
    }

    /**
     * 获取多个文件
     *
     * @param request 请求头
     */
    @PostMapping("/uploadPic")
    public void uploadPic(HttpServletRequest request) {
        List<MultipartFile> multipartFiles = ((MultipartHttpServletRequest) request).getFiles("files");//文件数据
    }
}