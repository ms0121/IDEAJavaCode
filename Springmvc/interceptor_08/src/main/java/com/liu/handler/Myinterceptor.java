package com.liu.handler;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Time;
import java.util.Date;

/**
 * @author lms
 * @date 2021-04-18 - 20:06
 */

//拦截器类：拦截用户的请求
public class Myinterceptor implements HandlerInterceptor {
    /**
     * preHandle: 叫做预处理方法
     * @param handler： 被拦截的处理器对象
     * @return:
     *      true; 表示请求通过了拦截器的验证，可以执行处理器的方法
     *          控制台输出：
    *                 拦截器MyInterceptor的preHandle()方法！
                      MyController执行了 doSome()方法!
                      拦截器MyInterceptor的postHandle()方法！
                      拦截器MyInterceptor的afterCompletion()方法
     *
     *      false: 请求没有通过拦截器的验证，请求到达拦截器就截止了，请求没有被处理
     *          控制台输出：
     *                拦截器MyInterceptor的preHandle()方法！
     *  特点：
     *     1. 方法在控制器方法（MyController的dosom）之前先执行的用户请求首先到达这里
     *     2. 在这个方法中可以获取请求的信息，验证请求是否合法
     *          可以验证用户是否登录。验证用户是否有权限访问某个连接地址(url)
     *          如果验证失败，可以截断请求，请求不能被处理
     *          如果验证成功，可以放行请求，此时控制器方法才可以执行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        System.out.println("拦截器MyInterceptor的preHandle()方法！");
//        request.getRequestDispatcher("/tips.jsp").forward(request, response);
        return true;
    }

    /**
     * postHandle： 后处理方法
     * @param handler 被拦截的处理器对象（MyController）
     * @param modelAndView 处理器方法的返回值
     *   特点：
     *          1. 在处理器方法之后执行的（即MyController.doSome()），
     *          2. 能够获取到处理器方法的返回值ModelAndView，可以修改ModelAndView中的数据和视图，
     *                     可以影响到最后的执行结果
     *          3. 主要是对原来的执行结果做二次修正
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截器MyInterceptor的postHandle()方法！");
        // 可以修改数据
        if (modelAndView != null){
            // 修改数据
            modelAndView.addObject("date", new Date());
            // 修改视图
            modelAndView.setViewName("other");
        }
    }

    /**
     * afterCompletion： 最后执行的方法
     * @param handler: 被拦截的处理器对象
     * @param ex 程序中发生的异常信息
     * 特点：
     *     1.在青丘处理完成之后执行，框架中规定是当你的视图处理完成之后，对视图执行了forward。就认为
     *           请求处理完成了
     *     2. 一般做资源回收工作的，程序请求过程中创建了一些对象，在这里可以删除，把占用的内存进行回收
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("拦截器MyInterceptor的afterCompletion()方法！");
    }
}
