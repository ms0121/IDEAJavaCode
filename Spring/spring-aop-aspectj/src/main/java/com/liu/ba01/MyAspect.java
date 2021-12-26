package com.liu.ba01;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import com.sun.tracing.dtrace.ArgsAttributes;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Date;

/**
 * @author lms
 * @date 2021-04-26 - 16:02
 *
 * @Aspect: 是aspectj框架的注解
 *  作用：表示当前的类是切面类
 *  切面类：是用来给业务方法增加功能的类，在这个类中有切面的功能代码
 *  位置：放置在类定义的上面
 */

@Aspect
public class MyAspect {
    /**
     * 定义方法，方法是实现切面功能的
     * 方法的定义要求：
     *  1.公共方法public
     *  2,。方法没有返回值的，
     *  3.方法名称自定义
     *  4.方法可以有参数，也可以没有参数
     *      如果有参数，参数不是自定义的，有几个参数类型可以使用
     */

    /**
     *@Before：前置通知注解
     * 属性;value,是切入点表达式，表示切面的功能执行的位置
     * 位置：载方法的上面
     *
     * 特点：
     *  1. 在目标方法之前先执行
     *  2. 不会改变目标方法的执行结果
     *  3. 不会影响目标方法的执行
     */
//    @Before(value = "execution(public void com.liu.ba01.SomeServiceImpl.doSome(String, int ))")
//    public void myBefore() {
//        System.out.println("我是前置通知方法，" + new Date());
//    }

    // 当前包下的所有类的所有方法增加 事务功能
    @Before(value = "execution(* com.liu.ba01.*ServiceImpl.*(..))")
    public void myBefore2(){
        System.out.println("实现了事务的功能");
    }

    /**
     * 指定通知方法中的参数，JoinPoint（连接点）
     * JoinPoint：业务方面，要加入切面功能的业务方法，
     *  作用是：可以在通知方法中获取方法运行时的信息，例如方法名称，方法的实参
     *  如果你的切面功能中需要用到方法的信息，就加入到JoinPoint
     *  这个JoinPoint参数的值是由框架赋予的，必须是第一个位置的参数
     */
    @Before(value = "execution(* com.liu.ba01.*ServiceImpl.*(..))")
    public void test2(JoinPoint jp){
        // 获取方法的完整定义，
        System.out.println("方法的签名（定义）：" + jp.getSignature()); // 完整的路径方法名
        System.out.println("方法的签名（定义）：" + jp.getSignature().getName()); //

        // 获取方法的实参
        Object[] args = jp.getArgs();
        for (Object arg : args) {
            System.out.println("参数 = " + arg);
        }
        // 切面要执行的功能代码
        System.out.println("前置功能方法，添加了JoinPoint");

    }
}



















