package com.thread.lambdaL;

/**
 * @author lms
 * @date 2021-09-01 - 22:22
 */
public class LoveTest {

    // 静态内部类
    static class MyLove2 implements ILove{
        @Override
        public void love(String name) {
            System.out.println("I love " + name);
        }
    }

    public static void main(String[] args) {
        MyLove myLove = new MyLove();
        myLove.love("Java");

        //静态内部类
        MyLove2 myLove2 = new MyLove2();
        myLove2.love("C++");

        // 局部内部类
        class MyLove3 implements ILove{
            @Override
            public void love(String name) {
                System.out.println("I love " + name);
            }
        }
        MyLove3 myLove3 = new MyLove3();
        myLove3.love("C");


        // lambda表达式
        ILove iLove = (String name) ->{
            System.out.println("I love " + name);
        };
        iLove.love("CSS");


        ILove iLove1 = (name) ->{
            System.out.println("I love " + name);
        };
        iLove1.love("HTML");


        ILove iLove2 = (name) -> System.out.println("I love " + name);
        iLove2.love("python");


    }
}

interface ILove{
    void love(String name);
}

class MyLove implements ILove{

    @Override
    public void love(String name) {
        System.out.println("I love " + name);
    }
}



