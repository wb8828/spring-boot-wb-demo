package com.spring.demo.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * @author: wb
 * @description: 一些平时项目中遇到的文件操作的demo
 * @date: 2023-04-11 13:40
 */
@RestController
public class ResourcesFileController {


    /**
     * 获取resources下面的文件，并且以流的形式下载下来
     *
     * @param request  请求头
     * @param response 响应
     * @throws IOException IO异常
     */
    @GetMapping("/downloadResourcesFile")
    public void downloadResourcesFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String downloadFileName = "安全工器具台账信息数据质量评价标准.pdf";

        Resource res = new ClassPathResource("/file/" + "test.pdf");
        OutputStream out = null;
        InputStream in = null;
        try {
            // 设置输出的格式
            response.reset();
            //解决跨域问题
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("application/octet-stream;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(downloadFileName, "UTF-8"));

            in = res.getInputStream();
            //创建输出流
            out = response.getOutputStream();
            //缓存区
            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = in.read(buffer)) != -1) {
                out.write(buffer, 0, length);
                out.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {// 关闭流
            if (out != null) {
                out.close();
            }
            if (in != null) {
                in.close();
            }
        }
    }
}