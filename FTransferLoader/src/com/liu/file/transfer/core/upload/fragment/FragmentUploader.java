package com.liu.file.transfer.core.upload.fragment;

import com.liu.file.transfer.constant.Constant;
import com.liu.file.transfer.utils.FileUtils;
import com.liu.file.transfer.utils.HttpUtils;
import com.liu.file.transfer.utils.LogUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: lms
 * @date: 2022-04-24 14:08
 */
public class FragmentUploader {

    /**
     * 实现多线程版本的文件断点续传
     *
     * @param url
     */
    public void upload(String url) throws IOException {
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

        // 记录每个线程已经下载到的各自负责分区部分的字节位置
        // key：线程  value：当前线程下载到的位置
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        // 记录所有的线程集合
        ArrayList<Thread> threadArrayList = new ArrayList<>();

        // 保存下载文件的日记文件的路径信息
        String logPath = "E:\\java_learn_tmp_file\\logs\\upload.temp.log";
        // 读取日记文件
        String[] data = null;
        File logFile = new File(logPath);
        // 如果日记文件存在，则读取里面的数据文件
        if (logFile.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(logFile));
            String readLine = reader.readLine();
            data = readLine.split(",");
            reader.close();
        }
        // 可以在线程的内部进行操作
        final String[] logData = data;

        // 创建分片上传的操作
        for (int i = 0; i < Constant.THREAD_NUM; i++) {
            final int k = i;
            Thread thread = new Thread(() -> {
                // 用于读取日记文件的随机文件流
                RandomAccessFile rafLog = null;
                try {
                    // 创建随机读写文件流
                    RandomAccessFile rafIn = new RandomAccessFile(file, "r");
                    RandomAccessFile rafOut = new RandomAccessFile(new File(uploadFilePath), "rw");
                    // 进行日记文件信息的读写
                    rafLog = new RandomAccessFile(logFile, "rw");

                    // 使用seek函数实现文件从指定的位置开始读取和写入文件
                    // 需要从指定的位置开始读取数据，从而实现断点续传
                    rafIn.seek(logData == null ? k * partLen : Integer.parseInt(logData[k]));
                    // 从指定的位置开始写数据
                    rafOut.seek(logData == null ? k * partLen : Integer.parseInt(logData[k]));

                    // 实现文件的写操作
                    int plen = 0, len = -1;
                    byte[] buffer = new byte[Constant.THREAD_NUM];
                    while ((len = rafIn.read(buffer)) != -1) {
                        // 记录当前写入的字节数
                        plen += len;
                        // 将本次读取到的字节数写入到日记文件中，标识当前已经下载到该位置
                        map.put(k, plen + (logData == null ? k * partLen : Integer.parseInt(logData[k])));

                        // 将文件进行写入磁盘
                        rafOut.write(buffer, 0, len);

                        // log写完毕之后，将日记文件中的数据清零重写
                        // 从头开始重新写入数据
                        rafLog.seek(0);
                        // 将map中的数据进行写盘
                        StringJoiner joiner = new StringJoiner(",");
                        map.forEach((key, val) -> {
                            joiner.add(String.valueOf(val));
                        });
                        rafLog.write(joiner.toString().getBytes(StandardCharsets.UTF_8));

                        // 如果plen大于等于下一个线程的开始位置，说明当前线程要写的文件长度已经达到，就执行退出操作
                        if (plen + (logData == null ? k * partLen : Integer.parseInt(logData[k])) >= (k + 1) * partLen) {
                            break;
                        }
                    }
                    rafIn.close();
                    rafOut.close();
                } catch (FileNotFoundException e) {
                    LogUtils.error("上传的文件不存在，请重新进行选择文件上传!");
                } catch (IOException e) {
                    LogUtils.error("文件上传失败!");
                } finally {
                    if (rafLog != null) {
                        try {
                            rafLog.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            thread.start();
            threadArrayList.add(thread);
        }

        // 删除临时文件
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
        logFile.delete();
        long end = System.currentTimeMillis();
        System.out.println("总耗时: " + (end - start));
        System.out.println("文件复制完成~~~");
    }
}
