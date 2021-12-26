package com.liu.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author lms
 * @date 2021-09-25 - 16:48
 * 实现在线人数的统计
 */

@WebListener
public class OnlineListener implements HttpSessionListener {

    // 记录在线的人数统计
    private Integer onlineNum = 0;

    // 通过判断session的创建和销毁来判断人数登录和退出的统计
    // 登录
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        onlineNum++;
        // 为了让别的地方能够获取到onlineNum对象，将其设置在session域对象中
        // session的作用域比较小，得让所有的浏览器都能看到互相的改变，所以设置在Context中
//        HttpSession session = httpSessionEvent.getSession();
//        session.setAttribute("onlineNum", onlineNum);


        httpSessionEvent.getSession().getServletContext().setAttribute("onlineNum", onlineNum);

    }

    // 退出
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        onlineNum--;
        // 为了让别的地方能够获取到onlineNum对象，将其设置在session域对象中
//        HttpSession session = httpSessionEvent.getSession();
//        session.setAttribute("onlineNum", onlineNum);

//        理由同上
        httpSessionEvent.getSession().getServletContext().setAttribute("onlineNum", onlineNum);
    }
}
