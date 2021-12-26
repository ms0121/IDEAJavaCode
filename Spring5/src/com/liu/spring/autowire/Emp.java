package com.liu.spring.autowire;

/**
 * @author lms
 * @date 2021-04-11 - 11:39
 */
public class Emp {
    private Dept dept;

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "dept=" + dept +
                '}';
    }
}
