package com.liu.handler;

import com.liu.exception.AgeException;
import com.liu.exception.NameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lms
 * @date 2021-04-18 - 17:34
 *
 * @ControllerAdvice：控制器增强，（也就是说给控制器增加功能，异常处理功能）
 *      位置： 在类的上面
 *      特点：必须要让框架知道这个注解所在的包名，需要在springmvc配置文件中添加组件扫描器
 *      指定 @ControllerAdvice所在的包名
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 定义方法：
     *  处理异常的方法和控制器方法的定义一样，可以有多个参数，可以有ModelAndView
     *
     *  形参：Exception，表示Controller中抛出的异常对象
     *  通过形参可以获取发生的异常信息
     */
    @ExceptionHandler(value = NameException.class)
    public ModelAndView doNameException(Exception exception) {
        // 处理NameException的异常
        /**
         * 异常发生处理器：
         *     1. 需要把异常信息记录下来，记录到数据库，日志文件中，
         *      记录日志发生的时间，哪个方法发生的，异常的错误内容
         *     2. 发送通知，把异常的信息通过邮件，短信，微信发给相关人员
         *     3. 给用户友好的提示
         */
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "姓名必须是z" +
                "hangsan，其他的用户没有权限进行访问！");
        mv.addObject("ex", exception);
        mv.setViewName("nameError");
        return mv;
    }


    @ExceptionHandler(value = AgeException.class)
    public ModelAndView doAgeException(Exception exception) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "年龄不能大于80岁!");
        mv.addObject("ex", exception);
        mv.setViewName("ageError");
        return mv;
    }


    // 处理其他的异常信息
    @ExceptionHandler
    public ModelAndView doOtherException(Exception exception) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "其他的异常信息~");
        mv.addObject("ex", exception);
        mv.setViewName("defaultError");
        return mv;
    }
}

