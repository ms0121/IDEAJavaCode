package com.liu.learn;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 * 使用RandomAccessFile实现多线程文件的复制
 *
 * @author lms
 * @date 2021-12-25 - 20:45
 */
public class RandomAccessFileTest3 {
    public static void main(String[] args) {
        File file = new File("C:/Users/Administrator/Desktop/PCQQ2021.exe");

        // 用于存放线程
        ArrayList<Thread> threadArrayList = new ArrayList<>();

        // 线程的数量
        int threadNum = 5;
        // 计算文件的总长度
        long length = file.length();
        // 每个线程分得的长度(向上取整，因为randomAccessFile会对重叠的部分进行合并整合)
        int partLen = (int) Math.ceil(length / threadNum);

        // 创建线程
        for (int i = 0; i < threadNum; i++) {
            final int k = i;
            Thread thread = new Thread(() -> {
                // 每个线程需要做的事情
                try {
                    // 进行文件的读写
                    RandomAccessFile rafIn = new RandomAccessFile(file, "r");
                    RandomAccessFile rafOut = new RandomAccessFile("D:/360Downloads/xxx.exe", "rw");

                    // 计算每个线程读取文件的开始位置
                    rafIn.seek(k * partLen);
                    // 每个写文件的开始位置
                    rafOut.seek(k * partLen);

                    int plen = 0, len = -1;
                    // 每次读取的文件大小为 8k
                    byte[] bytes = new byte[1024 * 8];

                    // 不断的读取，写文件
                    while (true) {
                        // 记录当前读取的字节数
                        len = rafIn.read(bytes);

                        // -1说明整个文件已经被读取完毕
                        if (len == -1) {
                            break;
                        }
                        // 否则记录每次读取的字节数，并将其累加到plen中
                        plen += len;
                        rafOut.write(bytes, 0, len);
                        // 如果plen大于partLen，说明当前线程要写的文件长度已经达到，就执行退出操作
                        if (plen >= partLen) {
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            });
            // 开启线程
            thread.start();
            threadArrayList.add(thread);
        }
        long start = System.currentTimeMillis();
        // 阻塞主线程
        for (Thread thread : threadArrayList) {
            // 等所有的线程结束之后，main线程才能继续执行
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("总耗时: " + (end - start));
        System.out.println("文件复制完成~~~");
    }
}
