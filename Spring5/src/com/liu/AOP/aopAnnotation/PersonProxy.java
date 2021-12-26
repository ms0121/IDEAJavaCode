package com.liu.AOP.aopAnnotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author lms
 * @date 2021-04-12 - 13:36
 */
@Component
@Aspect
@Order(1)
public class PersonProxy {

    @Before(value = "execution(* com.liu.AOP.aopAnnotation.User.add(..))")
    public void bofre() {
        System.out.println("person before............");
    }
}









