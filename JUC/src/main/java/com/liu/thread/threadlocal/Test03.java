package com.liu.thread.threadlocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lms
 * @date 2021-10-13 - 8:23
 * 在多线程的环境下，把字符串转为日期对象
 * 问题：出现了线程安全的问题，因为多个线程操作一个对象
 * 要解决这问题，可以使用一个ThreadLocal类的变量，给每一个线程都创建一个变量
 */
public class Test03 {
    // 设置日期的格式
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
    static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<>();

    // 实现runnable接口的实现类
    static class ParseDate implements Runnable {
        private int i;

        public ParseDate(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            String text = "2021年10月13日 08:32:" + i;
            Date date = null;
            try {
                // date = sdf.parse(text);
                // 先判断当前线程是否有SimpleDateFormat对象，如果没有，就先创建一个对象放置在ThreadLocal中，
                // 如果有就直接使用
                if (threadLocal.get() == null){
                    threadLocal.set(new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss"));
                }
                date = threadLocal.get().parse(text);
                System.out.println(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
             new Thread(new ParseDate(i)).start();
        }
    }

}
