package com.liu.file.transfer.utils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @description:
 * @author: lms
 * @date: 2022-04-23 17:21
 */
public class LogUtils {
    // 成功
    public static void info(String msg, Object... args){
        print(msg, "-info-", args);
    }

    public static void error(String msg, Object... args){
        print(msg, "-error-", args);
    }


    private static void print(String msg, String level, Object... args){
        if (args != null && args.length > 0){
            // 格式化msg信息
            msg = String.format(msg.replace("{}", "%s"), args);
        }
        // 获取当前线程的名字
        String name = Thread.currentThread().getName();
        // 打印日记文件
        System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")) +
                " " + name + level + msg);
    }
}
