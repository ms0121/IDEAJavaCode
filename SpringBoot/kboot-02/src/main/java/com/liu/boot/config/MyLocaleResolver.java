package com.liu.boot.config;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author lms
 * @date 2021-05-11 - 20:28
 * 重写处理国际化语言
 */
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        // 获取语言请求的参数
        String language = httpServletRequest.getParameter("lg");
        System.out.println("language = " + language);
        // 如果没有请求参数直接使用默认值
        Locale locale = Locale.getDefault();
        // 如果请求中携带了国际化参数
        if (StringUtils.hasLength(language)) {
            String[] split = language.split("_");
            // 拼接，国家地区
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
