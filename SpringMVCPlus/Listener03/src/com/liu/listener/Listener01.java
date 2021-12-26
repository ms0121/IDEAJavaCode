package com.liu.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author lms
 * @date 2021-09-25 - 16:27
 * 开启监听器，并设置监听的对象
 */
@WebListener
public class Listener01 implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("监听器被创建了。。。。。。。。。");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("监听器被销毁了。。。。。。。。。");
    }
}
