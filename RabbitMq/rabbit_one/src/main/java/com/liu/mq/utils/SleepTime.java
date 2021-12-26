package com.liu.mq.utils;

import java.util.concurrent.TimeUnit;

/**
 * @author lms
 * @date 2021-09-14 - 9:40
 */
public class SleepTime {
    public static void sleepTime(int s){
        try {
            TimeUnit.SECONDS.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
