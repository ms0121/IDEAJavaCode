package com.liu.maven;

import org.junit.Test;

/**
 * @author lms
 * @date 2021-04-12 - 22:04
 */
public class HelloTest {

    @Test
    public void test() {
        Hello hello = new Hello();
        String maven = hello.sayHello("maven");
        System.out.println("maven = " + maven);
    }
}
