package com.liu.ba04;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

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


    /**
     * 环绕通知方法定义的格式：
     *  1。public
     *  2. 必须有一个返回值，推荐使用object
     *  3. 方法名称自定义
     *  4. 方法有参数，固定的参数 ProceedingJoinPoint
     *
     *  @Around:环绕通知
     *      属性：value切入点表达式
     *      位置：在方法的定义上面
     *
     *  特点：
     *      1.它是功能最强的通知
     *      2.在目标方法的前面和后面都能够添加增强功能
     *      3.控制目标方法是否被调用执行
     *      4.修改原来的目标方法的执行结果，影响最后的调用结果
     *
     *  环绕通知：等同于jdk动态代理，InvocationHandler接口
     *
     *  参数: ProceedingJoinPoint 等同于 jdk动态代理的Method
     *      作用：执行目标方法的
     *  返回值: 就是目标方法的执行结果，可以被修改
     *
     *  环绕通知：通常做事务，在目标方法之前开启事务，指向目标方法，在目标方法之后提交事务
     *
     */
    @Around(value = "execution(* com.liu.ba04.SomeServiceImpl.doFirst(..))")
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
        // 实现环绕通知
        Object result = null;

        System.out.println("环绕通知，方法执行之前： " + new Date());
        // 1.目标方法的调用
        // 等同于method.invoke()；或者Object result = doFirst()

        //.控制目标方法是否被调用执行（如果输入的name等于zhangsan执行环绕方法）
        String name = "";
        // 返回的是被增强方法中的所有参数数组，JoinPoint就是用来获取被增强方法的参数的
        Object[] args = pjp.getArgs();
        if (args != null && args.length > 1){
           name = (String) args[0];
        }

        if ("zhangsan".equals(name)){
            result = pjp.proceed();
        }
        System.out.println("环通知，方法执行之后： 执行事务");
        // 2.在执行方法的前后都可以添加增强功能
//        return result;

//        4.修改原来的目标方法的执行结果，影响最后的调用结果
        result = "hello Aop";
        return result;
    }


    /**
     * 异常通知方法的定义格式：
     *      1. public
     *      2. 没有返回的值
     *      3. 方法名称自定义
     *      4. 方法有一个Exception，如果还有就是JoinPoint
     *
     * @AfterThrowing：异常通知
     *  属性：
     *      1、value切入点表达式
     *      2、throwing 自定义变量，表示目标方法抛出的异常对象,
     *          变量名必须和方法的参数名一样
     *
     * 特点：
     *      1. 在目标方法抛出异常是执行的
     *      2. 可以做异常的监控程序，监控目标方法执行时是不是有异常
     *          如果有异常，可以发送邮件，短信进行通知
     */
    @AfterThrowing(value = "execution(* com.liu.ba04.SomeServiceImpl.doSecond(..))",
            throwing = "ex")
    public void myAfterThrowing(Exception ex){
        System.out.println("异常通知：方法发生异常时执行" + ex.getMessage());
        // 发送邮件，短信通知开发人员
    }



}



















