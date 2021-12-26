package com.liu.juc.queue;

import javax.naming.spi.ObjectFactory;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author lms
 * @date 2021-09-04 - 15:23
 */
public class BlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        test4();
    }

    /**
     * queue中使用add或者remove方法会抛出异常信息
     * 不推荐使用
     */
    public static void test1(){
        // 使用的是阻塞式队列,设置队列的大小
        // 抛出异常信息
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(3);

        // 阻塞时队列添加成功之后有返回值true or false
        System.out.println("blockingQueue.add() = " + blockingQueue.add(1));
        System.out.println("blockingQueue.add() = " + blockingQueue.add(2));
        System.out.println("blockingQueue.add() = " + blockingQueue.add(3));
        // 检车队首元素，会抛出异常信息
        System.out.println("blockingQueue.element() = " + blockingQueue.element());
        // 会抛出异常信息
//        System.out.println("blockingQueue.add() = " + blockingQueue.add(4));

        System.out.println("==================");
        System.out.println("blockingQueue.remove() = " + blockingQueue.remove());
        System.out.println("blockingQueue.remove() = " + blockingQueue.remove());
        System.out.println("blockingQueue.remove() = " + blockingQueue.remove());
        // 队空之后会抛出异常信息
//        System.out.println("blockingQueue.remove() = " + blockingQueue.remove());
    }


    /**
     * 使用offer或者poll不会抛出异常信息，
     */
    public static void test2(){
        // 使用的是阻塞式队列,设置队列的大小
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(3);

        // 队列添加成功之后有返回值true or false
        System.out.println("blockingQueue.offer() = " + blockingQueue.offer(1));
        System.out.println("blockingQueue.offer() = " + blockingQueue.offer(2));
        System.out.println("blockingQueue.offer() = " + blockingQueue.offer(3));
        // 检测队首元素
        System.out.println("blockingQueue.peek() = " + blockingQueue.peek());
        System.out.println("blockingQueue.offer() = " + blockingQueue.offer(4));

        System.out.println("==================");
        System.out.println("blockingQueue.poll() = " + blockingQueue.poll());
        System.out.println("blockingQueue.poll() = " + blockingQueue.poll());
        System.out.println("blockingQueue.poll() = " + blockingQueue.poll());
        // 不会抛出异常信息
        System.out.println("blockingQueue.poll() = " + blockingQueue.poll());
    }


    /**
     * 线程满了之后（不会抛出异常信息），阻塞(会一直等待)
     */
    public static void test3() throws InterruptedException {
        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        // 队列满了之后，线程会一直等待
//        blockingQueue.put("d");

        // 出队
        System.out.println("blockingQueue.take() = " + blockingQueue.take());
        System.out.println("blockingQueue.take() = " + blockingQueue.take());
        System.out.println("blockingQueue.take() = " + blockingQueue.take());
        // 阻塞（一致等待）
//        System.out.println("blockingQueue.take() = " + blockingQueue.take());
    }


    // 不抛出异常，阻塞(等待超时会直接结束)
    // offer和poll方法的重载方法
    public static void test4() throws InterruptedException {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.offer(1);
        blockingQueue.offer(2);
        blockingQueue.offer(3);
        // 阻塞，等待超时，直接结束,设置等待的时间，以及时间的单位
//        blockingQueue.offer(4, 2, TimeUnit.SECONDS);

        System.out.println("blockingQueue.poll() = " + blockingQueue.poll());
        System.out.println("blockingQueue.poll() = " + blockingQueue.poll());
        System.out.println("blockingQueue.poll() = " + blockingQueue.poll());
        // 设置等待超时的时间
        System.out.println("blockingQueue.poll(2, TimeUnit.SECONDS) = " +
                blockingQueue.poll(2, TimeUnit.SECONDS));
    }
}



