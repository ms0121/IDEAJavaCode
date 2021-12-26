package com.liu.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author lms
 * @date 2021-04-02 - 16:53
 */
public class myServletListenerImpl implements ServletContextListener {

    //    使用 ServletContextListener 监听器监听 ServletContext 对象。
    //    使用步骤如下：
    //            1、编写一个类去实现 ServletContextListener
    //            2、实现其两个回调方法
    //            3、到 web.xml 中去配置监听器

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("listener监听器被创建了");

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("listener监听器被销毁了");
    }
}
