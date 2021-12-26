package com.liu.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @author lms
 * @date 2021-05-08 - 9:58
 * 日记切面类
 */

@Aspect  // 告诉spring当前的这个类是一个切面类
public class LogAspects {
    // 抽取公共的切入点表达式
    // 引用的方式：1）.本类引用，直接用方法名即可，2.）其他外部的引用，使用全类名
    @Pointcut("execution(public int com.liu.aop.MathCalculator.*(..))")
    public void pointCut() { }


    // @Before在目标方法之前切入：切入点表达式（指定在哪个方法切入）

    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        // 获取运行的切入方法的方法名
        String name = joinPoint.getSignature().getName();
        // 获取参数列表
        Object[] args = joinPoint.getArgs();
        System.out.println(name + "除法运行，，，参数列表是{}" + Arrays.asList(args));
    }

    @After("pointCut()")
    public void logEnd() {
        System.out.println("除法结束，，，，，");
    }

    // JoinPoint必须出现在参数列表的第一位
    @AfterReturning(value = "com.liu.aop.LogAspects.pointCut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        System.out.println(joinPoint.getSignature().getName() + "除法正常返回，，，运行结果是{}" + result);
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(Exception exception) {
        System.out.println("除法异常，，，异常信息: " + exception);
    }

}
