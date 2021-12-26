package com.liu.utils;

import com.liu.pojo.User;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author lms
 * @date 2021-04-04 - 13:38
 */
public class WebUtils {

    public static <T> T copyParamToBean(Map value, T bean) {
        try {
            // System.out.println("注入之前: " + bean);
            // 被注入的对象，注入的参数map(req已经封装好)
            BeanUtils.populate(bean, value);
            // System.out.println("注入之后: " + bean);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return bean;
    }

    // 将字符串转为整型
    public static int parseInt(String str, int defaultValue){
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return defaultValue;
    }
}
