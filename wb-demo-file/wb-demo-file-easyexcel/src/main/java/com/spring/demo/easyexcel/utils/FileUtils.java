package com.spring.demo.easyexcel.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.handler.WriteHandler;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;

public class FileUtils {

    private static final Logger log = LoggerFactory.getLogger(FileUtils.class);

    /**
     * 下载文件名重新编码
     *
     * @param response     响应对象
     * @param realFileName 真实文件名
     */
    public static void setAttachmentResponseHeader(HttpServletResponse response, String realFileName) throws UnsupportedEncodingException {
        String percentEncodedFileName = percentEncode(realFileName);

        StringBuilder contentDispositionValue = new StringBuilder();
        contentDispositionValue.append("attachment; filename=")
                .append(percentEncodedFileName)
                .append(";")
                .append("filename*=")
                .append("utf-8''")
                .append(percentEncodedFileName);

        response.addHeader("Access-Control-Expose-Headers", "Content-Disposition,download-filename");
        response.setHeader("Content-disposition", contentDispositionValue.toString());
        response.setHeader("download-filename", percentEncodedFileName);
    }

    /**
     * 百分号编码工具方法
     *
     * @param s 需要百分号编码的字符串
     * @return 百分号编码后的字符串
     */
    public static String percentEncode(String s) throws UnsupportedEncodingException {
        String encode = URLEncoder.encode(s, StandardCharsets.UTF_8.toString());
        return encode.replaceAll("\\+", "%20");
    }

    /**
     * 通用流下载方法
     *
     * @param cls       类
     * @param fileName  下载文件名
     * @param sheetName 文件sheet名称
     * @param list      下载的数据
     * @param response  响应头
     */
    public static void download(Class<?> cls, String fileName, String sheetName, List list, HttpServletResponse response) {
        download(cls, fileName, sheetName, list, null, null, StyleUtils.StyleStrategy(), response);
    }

    /**
     * 通用流下载方法
     *
     * @param cls                     类
     * @param fileName                下载文件名
     * @param sheetName               文件sheet名称
     * @param dataList                下载的数据
     * @param includeColumnFiledNames 包含哪些列
     * @param excludeColumnFiledNames 不包含哪些列
     * @param writeHandler            处理器
     */
    public static void download(Class<?> cls,
                                String fileName,
                                String sheetName,
                                List dataList,
                                Collection<String> includeColumnFiledNames,
                                Collection<String> excludeColumnFiledNames,
                                WriteHandler writeHandlere) {
        download(cls, fileName, sheetName, dataList, includeColumnFiledNames, excludeColumnFiledNames, StyleUtils.StyleStrategy(), getRequestAttributes().getResponse());
    }

    /**
     * 通用流下载方法
     *
     * @param cls                     类
     * @param fileName                下载文件名
     * @param sheetName               文件sheet名称
     * @param dataList                下载的数据
     * @param includeColumnFiledNames 包含哪些列
     * @param excludeColumnFiledNames 不包含哪些列
     * @param writeHandler            处理器
     * @param response                响应头
     */
    public static void download(Class<?> cls,
                                String fileName,
                                String sheetName,
                                List dataList,
                                Collection<String> includeColumnFiledNames,
                                Collection<String> excludeColumnFiledNames,
                                WriteHandler writeHandler,
                                HttpServletResponse response) {
        ServletOutputStream outputStream = outputStream(response, fileName);
        EasyExcel.write(outputStream, cls)
                .includeColumnFiledNames(includeColumnFiledNames)
                .excludeColumnFiledNames(excludeColumnFiledNames)
                .autoCloseStream(true)
                .registerWriteHandler(writeHandler)
                .sheet(sheetName)
                .doWrite(dataList);
        flush(outputStream);
        close(outputStream);

    }

    /**
     * 获取输出流
     *
     * @param fileName 表格名称
     * @return 输出流
     */
    public static ServletOutputStream outputStream(String fileName) {
        return outputStream(getRequestAttributes().getResponse(), fileName);
    }

    /**
     * 获取输出流
     *
     * @param response 响应头
     * @param fileName 表格名称
     * @return 输出流
     */
    public static ServletOutputStream outputStream(HttpServletResponse response, String fileName) {
        try {
            ServletOutputStream outputStream = response.getOutputStream();
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            setAttachmentResponseHeader(response, fileName(fileName));

            return outputStream;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 判断是否是合法的后缀名
     *
     * @param fileName 文件名
     */
    public static String fileName(String fileName) {
        if (StringUtils.equalsAnyIgnoreCase(fileName, ".xlsx", ".xls")) {
            return fileName;
        }
        return fileName + ".xlsx";
    }

    /**
     * 获取请求上下文
     */
    public static ServletRequestAttributes getRequestAttributes() {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        return (ServletRequestAttributes) attributes;
    }

    /**
     * 从缓存中刷出数据
     *
     * @param flushable {@link Flushable}
     */
    public static void flush(Flushable flushable) {
        if (null != flushable) {
            try {
                flushable.flush();
            } catch (Exception var2) {
            }
        }

    }

    /**
     * 关闭失败不会抛出异常
     *
     * @param closeable 被关闭的对象
     */
    public static void close(Closeable closeable) {
        if (null != closeable) {
            try {
                closeable.close();
            } catch (Exception var2) {
            }
        }

    }
}