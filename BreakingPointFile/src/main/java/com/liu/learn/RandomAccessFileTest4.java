package com.liu.learn;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * 基于多线程的断点续传方法
 *
 * @author lms
 * @date 2021-12-25 - 20:45
 */
public class RandomAccessFileTest4 {
    public static void main(String[] args) throws Exception {
        File file = new File("E:\\java_learn_tmp_file\\PCQQ2021.exe");

        // 使用ConcurrentHashMap记录每个线程读取到位置
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();

        // 用于存放线程
        ArrayList<Thread> threadArrayList = new ArrayList<>();

        // 线程的数量
        int threadNum = 5;
        // 计算文件的总长度
        long length = file.length();
        // 每个线程分得的长度(向上取整，因为randomAccessFile会对重叠的部分进行合并整合)
        int partLen = (int) Math.ceil(length / threadNum);
        // 存放日记文件
        String logFile = "E:/java_learn_tmp_file/logs/xxx.exe.log";

        // 读取日记文件
        String[] data = null;
        File fl = new File(logFile);
        if (fl.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(fl));
            String line = reader.readLine();
            // 拆分字符串
            data = line.split(",");
            reader.close();
        }
        final String[] _data = data;

        // 创建线程
        for (int i = 0; i < threadNum; i++) {
            final int k = i;
            Thread thread = new Thread(() -> {
                RandomAccessFile log = null;
                // 每个线程需要做的事情
                try {
                    // 进行文件的读写
                    RandomAccessFile rafIn = new RandomAccessFile(file, "r");
                    RandomAccessFile rafOut = new RandomAccessFile("E:\\java_learn_tmp_file\\upload\\xxx.exe", "rw");
                    // 记录读到的日记文件
                    log = new RandomAccessFile(logFile, "rw");

                    // 计算每个线程读取文件的开始位置
                    // 需要从指定的位置开始读取数据，从而实现断点续传
                    rafIn.seek(_data == null ? k * partLen : Integer.parseInt(_data[k]));
                    // 每个写文件的开始位置
                    // 从指定的位置开始写输入数据
                    rafOut.seek(_data == null ? k * partLen : Integer.parseInt(_data[k]));

                    int plen = 0, len = -1;
                    // 每次读取的文件大小为 10k
                    byte[] bytes = new byte[1024 * 10];

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

                        // 将读取到的字节数量添加到map中
                        map.put(k, plen + (_data == null ? k * partLen : Integer.parseInt(_data[k])));
                        // 将读取到的数据进行写入
                        rafOut.write(bytes, 0, len);

                        // 写入完成之后，覆盖之前的log文件
                        log.seek(0);
                        // 以逗号进行分割，写入
                        StringJoiner joiner = new StringJoiner(",");
                        map.forEach((key, val) -> {
                            String.valueOf(val);
                        });
                        log.write(joiner.toString().getBytes(StandardCharsets.UTF_8));

                        // 如果plen大于等于下一个线程的开始位置，说明当前线程要写的文件长度已经达到，就执行退出操作
                        if (plen + (_data == null ? k * partLen : Integer.parseInt(_data[k])) >= (k + 1) * partLen) {
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (log != null) {
                        try {
                            log.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
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
        // 线程读取完毕，将日记数据进行删除
        // fl.delete();

        long end = System.currentTimeMillis();
        System.out.println("总耗时: " + (end - start));
        System.out.println("文件复制完成~~~");
    }
}
