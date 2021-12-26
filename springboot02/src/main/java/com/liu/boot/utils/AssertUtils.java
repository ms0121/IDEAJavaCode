package com.liu.boot.utils;

import com.liu.boot.exception.ParamsException;

/**
 * @author lms
 * @date 2021-09-27 - 10:56
 */
public class AssertUtils {
    public static void isTrue(Boolean flag, String msg){
        if (flag){
            throw new ParamsException(msg);
        }
    }
}
