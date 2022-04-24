package com.liu.file.transfer.core.upload.basic;

import com.liu.file.transfer.constant.Constant;
import com.liu.file.transfer.core.download.fragment.DownloaderInfoPlus;
import com.liu.file.transfer.utils.FileUtils;
import com.liu.file.transfer.utils.HttpUtils;
import com.liu.file.transfer.utils.LogUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @description: 实现简单的多线程文件上传功能
 * @author: lms
 * @date: 2022-04-24 13:16
 */
public class UploaderBasic {

    // 创建线程池，执行打印的任务
    public ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    /**
     * 将指定url的文件进行上传
     * @param url
     */
    public void upload(String url) {
        // 获取文件名
        String httpFileName = HttpUtils.getHttpFileName(url);
        // 构建文件上传的路径
        String uploadFilePath = Constant.UPLOAD_PATH + httpFileName;
        // 判断远程服务器是否存在该文件
        long localFileContextLength = FileUtils.getLocalFileContextLength(uploadFilePath);
        // 计算需要上传文件的大小
        File file = new File(url);
        long uploadFileLength = file.length();
        if (localFileContextLength > uploadFileLength) {
            LogUtils.info("文件已经存在，请不要重复上传: {}", httpFileName);
            return;
        }
        // 每个线程分得的长度(向上取整，因为randomAccessFile会对重叠的部分进行合并整合)
        int partLen = (int) Math.ceil(uploadFileLength / Constant.THREAD_NUM);

        // 存放创建的线程
        ArrayList<Thread> threadArrayList = new ArrayList<>();


        // 创建下载信息任务对象
        DownloaderInfoPlus downloaderInfoPlus = new DownloaderInfoPlus((int) uploadFileLength);
        // 线程池每隔一秒钟执行一次
        scheduledExecutorService.scheduleAtFixedRate(downloaderInfoPlus, 1, 1, TimeUnit.SECONDS);

        // 使用多线程的方式实现文件的分片上传
        for (int i = 0; i < Constant.THREAD_NUM; i++) {
            final int k = i;
            Thread thread = new Thread(() -> {
                try {
                    // 实现文件的读操作
                    RandomAccessFile rafIn = new RandomAccessFile(file, "rw");
                    // 文件写操作
                    RandomAccessFile rafOut = new RandomAccessFile(new File(uploadFilePath), "rw");

                    // 使用seek函数，实现文件从头到尾开始进行读取和写入
                    rafIn.seek(k * partLen);
                    rafOut.seek(k * partLen);

                    int plen = 0, len = -1;
                    byte[] buffer = new byte[Constant.TYPE_SIZE];
                    while ((len = rafIn.read(buffer)) != -1) {
                        // 记录每一秒钟下载的字节数量
                        DownloaderInfoPlus.downSize.add(len);
                        // 记录每次读取的字节数，并将其写出到指定的路径
                        plen += len;
                        rafOut.write(buffer, 0, len);
                        // 当前线程已经完成了负责部分文件的写出操作
                        if (plen >= partLen) {
                            break;
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    LogUtils.error("上传的文件不存在，请重新确认!");
                } catch (IOException e) {
                    e.printStackTrace();
                    LogUtils.error("文件上传失败!");
                }
            });
            thread.start();
            threadArrayList.add(thread);
        }
        long start = System.currentTimeMillis();
        // 阻塞主线程(这部分可以直接使用countDownLatch进行替换)
        for (Thread thread : threadArrayList) {
            // 等所有的线程结束之后，main线程才能继续执行
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 关闭线程池
        scheduledExecutorService.shutdown();
        long end = System.currentTimeMillis();
        System.out.println("总耗时: " + (end - start));
        System.out.println("文件复制完成~~~");
    }
}
