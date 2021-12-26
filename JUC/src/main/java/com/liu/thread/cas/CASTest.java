package com.liu.thread.cas;

/**
 * @author lms
 * @date 2021-10-10 - 7:30
 * 使用cas实现一个线程安全的计算器
 */
public class CASTest {
    public static void main(String[] args) {
        CASCounter casCounter = new CASCounter();
        for (int i = 0; i < 50; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(casCounter.add());
                }
            }).start();
        }
    }
}

// cas:每次在更新值之前，都会去判断主内存中的值是否等于期望的值，如果等于则进行更新值
class CASCounter {
    // 保证变量的可见性
    private volatile long value = 10;

    public long getValue() {
        return value;
    }

    // 实现cas的原理
    private boolean compareAndSwap(long oldValue, long newValue){
        synchronized (this){
            // 如果当前主内存中的值和期望的值一样，就将主内存中的值更新为新的值
            if (oldValue == getValue()){
                value = newValue;
                return true;
            }else {
                // 不一样就撤销操作
                return false;
            }
        }
    }

    // 定义值自增的方法
    public long add(){
        long oldValue, newValue;
        do {
            oldValue = value;  // 10
            newValue = oldValue + 1;  // 11
            // 如果内存中的value值和期望的值oldValue不相等，就不断进行交换
        }while (!compareAndSwap(oldValue, newValue));
        return getValue();
    }




}

