package com.spring.demo.util;

import com.spring.demo.utils.ServletUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

public class LocaleUtils {

    public static Locale stringToLocale(String languageTag) {

        return Locale.forLanguageTag(StringUtils.replace(languageTag, "_", "-"));
    }

    public static Locale locale() {
        HttpServletRequest request = ServletUtils.getRequest();
        String language = request.getHeader("Accept-Language");
        return stringToLocale(language);
    }
}