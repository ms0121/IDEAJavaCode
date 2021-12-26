package com.liu.handler;

import jdk.nashorn.internal.ir.Flags;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lms
 * @date 2021-04-29 - 20:48
 */

// 拦截器类，用于拦截用户的请求
public class MyInterceptor implements HandlerInterceptor {
    /**
     * preHandle叫做预处理方法：
     *  参数：Object handler： 它是被拦截的控制器对象，比如MyController类
     *     返回值是true
     *          拦截器的preHandle()方法执行了
             * 控制器doSome方法执行了
             * 拦截器的postHandle()方法执行了
             * 拦截器的afterCompletion()方法执行了
     *
     *     或者 false
     *        拦截器的preHandle()方法执行了
     *  特点：
     *  1.方法在控制器方法（MyController的doSome）之前执行，用户的请求首先到达此方法
     *  2.在这个方法中可以获取请求的信息，验证请求是否符合要求;
     *      可以验证用户是否登录，验证用户是否有权限访问某个链接地址（uri）
     *      如果验证失败，可以截断请求，请求就不能处理
     *      如果验证成功，可以放行请求，此时控制器方法才能执行。
     *
     *  实际上，拦截器可以看作是多个Controller中共用的功能，知识集中到
     *  拦截器进行统一处理，使用的是aop的思想
     *
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("拦截器的preHandle()方法执行了");
        // 出现异常的时候，可以将其转发到提示页面
//        request.getRequestDispatcher("tips.jsp").forward(request, response);
        return true;
    }

    /**
     * postHandle：后处理方法
     * 参数：handler：被拦截的处理器对象MyController
     * ModelAndView：处理器方法的返回值
     *
     * 特点：
     * 1. 在处理器方法之后执行的（即doSome方法执行之后才执行这个方法）
     * 2. 能够获取到处理器方法的返回值ModelAndView，可以修改ModelAndView中的数据和视图，
     *      可以影响到最后的执行结果
     * 3. 主要是可以对原来的执行结果做二次修正
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView mv) throws Exception {
        System.out.println("拦截器的postHandle()方法执行了");
        // 对程序做二次开发
        if (mv != null){
            // 实现二次开发
            mv.addObject("mydata", "添加了新的功能!");
            // 转发到新的页面
            mv.setViewName("second");
        }
    }

    /**
     * afterCompletion，最后执行的方法
     * @param handler 被拦截的处理器方法
     * @param ex 程序中发生的异常
     *
     *  特点：
     *        1.在青丘处理完成之后执行，框架中规定当你的视图处理完成之后，对视图执行了forward，就认为是
     *                处理完成了
     *        2.一般是用作资源回收工作的，程序请求过程中创建了一些对象，在这里可以删除，把占用的内存回收
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {
        System.out.println("拦截器的afterCompletion()方法执行了");
    }
}
