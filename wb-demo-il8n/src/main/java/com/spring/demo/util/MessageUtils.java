package com.spring.demo.util;

import cn.hutool.extra.spring.SpringUtil;
import com.spring.demo.utils.ServletUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * 获取i18n资源文件
 * 
 */
public class MessageUtils
{
    /**
     * 根据消息键和参数 获取消息 委托给spring messageSource
     *
     * @param code 消息键
     * @param args 参数
     * @return 获取国际化翻译值
     */
    public static String message(String code, Object... args)
    {
        MessageSource messageSource = SpringUtil.getBean(MessageSource.class);

        return messageSource.getMessage(code, args, LocaleUtils.locale());
//        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }

}
