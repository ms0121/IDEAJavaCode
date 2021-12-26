package com.liu.AOP.aopAnnotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author lms
 * @date 2021-04-12 - 12:49
 */

// 创建增强类（即给被增强的类添加功能的类）
// 在增强类里面，创建方法，让不同的方法代表不同的通知类型
@Component
@Aspect  // 生成代理对象
@Order(2)  // 用于设置优先级的顺序
public class UserProxy {

    // 对相同切入点进行提取,即所有的这个部分的切入点表达式都可以进行替换
    @Pointcut(value = "execution(* com.liu.AOP.aopAnnotation.User.add(..))")
    public void pointDemo(){

    }

    // 前置通知（即先输出before方法的内容，再输出add中的内容）
    // @before注解表示作为被增强方法的前置通知  ..代表add方法的形参
    // value的内容表示的就是  切入点表达式（即需要增强的方法）
//    @Before(value = "execution(* com.liu.AOP.aopAnnotation.User.add(..))")  //所有的都可以进行替换
    @Before(value = "pointDemo()")
    public void before() {
        System.out.println("before........");
    }

    // 后置通知
    @AfterReturning(value = "execution(* com.liu.AOP.aopAnnotation.User.add(..))")
    public void afterReturning(){
        System.out.println("afterReturning.............");
    }

    // 最终通知
    @After(value = "execution(* com.liu.AOP.aopAnnotation.User.add(..))")
    public void after(){
        System.out.println("after.............");
    }

    // 异常通知
    @AfterThrowing(value = "execution(* com.liu.AOP.aopAnnotation.User.add(..))")
    public void afterThrowing(){
        System.out.println("afterThrowing.............");
    }

    // 环绕通知
    @Around(value = "execution(* com.liu.AOP.aopAnnotation.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前.............");
        proceedingJoinPoint.proceed();
        System.out.println("环绕之后.............");
    }


}
