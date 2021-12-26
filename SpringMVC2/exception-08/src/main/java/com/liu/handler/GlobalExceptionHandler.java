package com.liu.handler;

import com.liu.exception.AgeException;
import com.liu.exception.NameException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lms
 * @date 2021-04-29 - 15:59
 *
 * @ControllerAdvice：控制器增强，（也就是说给控制器类增加功能，即异常处理功能）
 *  位置：放置在类的上面
 *  特点：必须让框架知道这个注解所在的包名，需要在springmvc配置文件中声明组件扫描器
 *  指定@ControllerAdvice所在的包名
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 定义异常处理的方法：
     *  处理异常的方法和控制器方法的定义一样，可以有多个参数，可以有ModelAndView，
     *  string，void，对象类型的返回值
     *
     *  形参：Exception，表示controller中抛出的异常对象
     *  通过形参可以获取发生的异常信息
     *
     * @ExceptionHandler(异常的class)，表示异常的类型，当发生此类型的异常时，
     * 由当前方法进行处理
     */
    @ExceptionHandler(value = NameException.class)
    public ModelAndView doNameException(Exception exception){
        /**
         * 异常发生后的处理逻辑：
         * 1.需要把异常记录下来，记录到数据库，日志文件中，记录日记发生的时间，哪个方法发生的，
         *      异常错误的内容信息
         * 2.发送通知信息，把异常的信息通过邮件，短信，微信将信息发送给相关的人员进行处理
         * 3.给用户友好的提示
         */
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "姓名必须是zhangsan, 其他的用户无法进行访问!");
        mv.addObject("ex", exception);
        mv.setViewName("nameEerror");
        return mv;
    }

    @ExceptionHandler(value = AgeException.class)
    public ModelAndView doAgeException(Exception exception){
        /**
         * 异常发生后的处理逻辑：
         * 1.需要把异常记录下来，记录到数据库，日志文件中，记录日记发生的时间，哪个方法发生的，
         *      异常错误的内容信息
         * 2.发送通知信息，把异常的信息通过邮件，短信，微信将信息发送给相关的人员进行处理
         * 3.给用户友好的提示
         */
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "年龄不可以大于80!");
        mv.addObject("ex", exception);
        mv.setViewName("ageError");
        return mv;
    }


    // 处理其他的异常信息,不需要添加参数value值的设置
    @ExceptionHandler
    public ModelAndView doOtherException(Exception exception){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "不可预知的异常信息!");
        mv.addObject("ex", exception);
        mv.setViewName("error");
        return mv;
    }

}
