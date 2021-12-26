package com.liu.util;

import javax.servlet.http.Cookie;

/**
 * @author lms
 * @date 2021-04-06 - 18:12
 */
public class CookieUtils {

    /**
     * 查找指定名称的cookie对象
     * @param name
     * @param cookies
     * @return
     */
    public static Cookie findCookie(String name, Cookie[] cookies) {
        if (name == null || cookies.length == 0 || cookies == null) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                return cookie;
            }
        }
        return null;
    }
}
