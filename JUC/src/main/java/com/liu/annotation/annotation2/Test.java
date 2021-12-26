package com.liu.annotation.annotation2;

import java.util.ArrayList;

/**
 * @author lms
 * @date 2021-10-29 - 21:19
 */
public class Test extends Object {

    // 重写当前父类的方法
    @Override
    public String toString() {
        return super.toString();
    }

    // 不推荐使用的方法
    @Deprecated
    public void stop(){
        System.out.println("当前方法不推荐使用,,,,,,,,,,");
    }

    @SuppressWarnings("all")
    public void warn(){
        ArrayList<Integer> list = new ArrayList<>();
    }

    public static void main(String[] args) {
        new Test().stop();
    }

}
