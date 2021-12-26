package com.xxxx.crm3.utils;

import com.xxxx.crm3.exceptions.ParamsException;

public class AssertUtil {

    public static void isTrue(Boolean flag, String msg) {
        if (flag) {
            throw new ParamsException(msg);
        }
    }

}
