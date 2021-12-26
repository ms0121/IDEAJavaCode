package com.thread.lambdaL;

/**
 * @author lms
 * @date 2021-09-01 - 21:43
 * lambda进化操作
 * 函数式接口的定义：
 *  1.任何接口，如果只有一个抽象方法，那么他就是一个函数式接口
 *  2.对于函数式接口，我们可以通过lambda表达式来创建该接口的对象
 */
public class LambdaTest {

    // 3.静态内部类
    static class Like2 implements ILike {
        @Override
        public void lambda() {
            System.out.println("I like lambda - 2");
        }
    }

    public static void main(String[] args) {

        // 第一种实现方式
        Like1 like1 = new Like1();
        like1.lambda();

        // 静态内部类
        Like2 like2 = new Like2();
        like2.lambda();

        // 4. 局部内部类
        class Like3 implements ILike {
            @Override
            public void lambda() {
                System.out.println("I like lambda - 3");
            }
        }
        Like3 like3 = new Like3();
        like3.lambda();


        // 5.匿名内部类,没有类的名称，必须借助接口或者父类
        ILike like4 = new ILike() {
            @Override
            public void lambda() {
                System.out.println("I like lambda - 4");
            }
        };
        like4.lambda();


        // 6.lambda表达式
        ILike like5 = () -> {
            System.out.println("I like lambda - 5");
        };
        like5.lambda();

    }
}

// 1.定义一个接口
interface ILike{
    void lambda();
}

// 2.定义一个实现类
class Like1 implements ILike {
    @Override
    public void lambda() {
        System.out.println("I like lambda - 1");
    }
}
