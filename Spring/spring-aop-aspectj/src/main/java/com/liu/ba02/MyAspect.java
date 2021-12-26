package com.liu.ba02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

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
     * @AfterReturning:后置通知，
     * 属性：1.value 切入点表达式
     *      2.returning：自定义的变量，表示目标方法的返回值
     *      自定义变量名必须和通知方法的形参名一样
     *
     * 位置: 在方法定义的上面
     * 特点：
     *  1. 在目标方法之后执行
     *  2. 能够获取到目标方法的返回值，可以根据这个返回值做不同的处理功能
     *  3. 可以修改这个返回值类型
     *
     *  注意：returning的值和形参的名必须一致
     *
     *  后置通知执行的流程：
     *    先执行 Object res = doOther();
     *    再执行： myAfterReturning(res)
     *    将执行方法得到的res传到后置通知中
     */
    @AfterReturning(value = "execution(* com.liu.ba02.SomeServiceImpl.doOther(..))", returning = "res")
    public void myAfterReturning(Object res) {
        System.out.println("我是后置方法: " + res);
        // 然后可以根据传过来的参数执行需要的方法
        // 修改res的返回值，并不会影响方法的执行结果
        res = "hjshdjsh3112";

    }

}



















