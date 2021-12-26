package com.liu.core;

import com.liu.constant.Constant;
import com.liu.util.FileUtils;
import com.liu.util.HttpUtils;
import com.liu.util.LogUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.sql.Time;
import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author lms
 * @date 2021-10-11 - 8:35
 *
 * 因为downloader主线程是用来执行下载操作的，所以要想在下载文件的同时又打印下载文件相关的信息，
 * 一个主线程无法执行，所以需要额外开启一个线程来执行打印信息
 *
 * 使用多线程(分片的)方式下载文件
 */
public class DownloaderPlus {

    // 创建线程池
    public ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    // 创建线程池(不设置非核心线程)
    public ThreadPoolExecutor threadPoolExecutor =
            new ThreadPoolExecutor(Constant.THREAD_NUM, Constant.THREAD_NUM, 0,
                    TimeUnit.SECONDS, new ArrayBlockingQueue<>(Constant.THREAD_NUM));

    // 线程计数器(计数器数量和线程数一致)
    private CountDownLatch countDownLatch = new CountDownLatch(Constant.THREAD_NUM);

    // 下载文件
    public void downloader(String url){
        // 获取文件名
        String httpFileName = HttpUtils.getHttpFileName(url);
        // 设置下载文件存放的路径
        String filePath = Constant.PATH + httpFileName;

        // 根据文件路径查询本地文件的大小（实质就是判断文件是否已存在）
        long localFileLength = FileUtils.getFileContextLength(filePath);


        // 获取连接对象
        HttpURLConnection httpURLConnection = null;
        // 任务对象
        DownLoadInfoThreadPlus downLoadInfoThreadPlus = null;

        try {
            httpURLConnection = HttpUtils.getHttpURLConnection(url);
            // 获取连接中要下载文件的总大小
            int contentLength = httpURLConnection.getContentLength();

            // 判断文件是否已经下载过
            if (localFileLength > contentLength){
                LogUtils.info("{}文件已下载，无需重新下载", httpFileName);
                return;
            }

            // 创建下载信息的任务对象
            downLoadInfoThreadPlus = new DownLoadInfoThreadPlus(contentLength);
            // 将任务交给线程去执行，每个一秒钟执行一次
            scheduledExecutorService.scheduleAtFixedRate(downLoadInfoThreadPlus, 1,1, TimeUnit.SECONDS);

            // 使用多线程去下载文件（切分任务）
            ArrayList<Future> list = new ArrayList<>();
            split(url, list);


            // 知道计数器归0之后才会往下执行(也就是等5个线程都执行完毕)
            countDownLatch.await();

            // 直接使用CountDownLatch代替下面的代码
            // 目的就是为了保证在执行下面的方法之前，上面的所有线程执行完毕
            // 遍历执行的结果（目的就是为了就是为了阻塞，方便后续的合并）
//            list.forEach( future -> {
//                try {
//                    // 返回值为boolean类型
//                    future.get();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (ExecutionException e) {
//                    e.printStackTrace();
//                }
//            });

            // 合并文件
            if (merge(filePath)){
                // 清除临时文件
                clearTempFile(filePath);
            }


        } catch (FileNotFoundException e) {
            // {}是占位符
            LogUtils.error("下载文件不存在: {}", url);
        } catch (Exception e){
            System.out.println("下载失败");
        } finally {
            System.out.print("\r");
            System.out.print("下载完成");
            // 关闭连接对象
            if (httpURLConnection != null){
                httpURLConnection.disconnect();
            }
            // 任务执行完成，立即关闭线程池
            scheduledExecutorService.shutdownNow();
            // 关闭线程池
            threadPoolExecutor.shutdown();
        }
    }

    /**
     * 进行下载文件的切分
     * @param url 文件路径
     * @param futureList 存放每个任务计算的结果，因为call()会有一个线程执行的返回结果
     */
    public void split(String url, ArrayList<Future> futureList){
        try {
            // 获取下载文件的大小
            long contentLength = HttpUtils.getHttpFileContentLength(url);
            // 计算切分后每块文件的大小
            long size = contentLength / Constant.THREAD_NUM;

            // 计算分块个数
            for (int i = 0; i < Constant.THREAD_NUM; i++) {
                // 下载文件的开始位置
                long startPos = i * size;
                // 计算结束的位置
                long endPos;

                // 如果是最后一块数据，直接从开始位置下载到末尾
                if (i == Constant.THREAD_NUM - 1){
                    // 设置为0
                    endPos = 0;
                }else {
                    // 结束位置就等于开始位置加上每块文件的大小
                    endPos = startPos + size;
                }

                // 如果当前的开始位置不是原文件的开始位置，则需要进行加1
                if (startPos != 0){
                    startPos++;
                }

                // 创建下载任务
                DownLoaderTask downLoaderTask = new DownLoaderTask(url, startPos, endPos, i, countDownLatch);

                // 将任务提交到线程池中
                Future<Boolean> future = threadPoolExecutor.submit(downLoaderTask);
                // 将future返回值添加到list中
                futureList.add(future);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将分片下载好的文件进行合并
     * @param fileName
     * @return
     */
    public boolean merge(String fileName){
        LogUtils.info("开始合并文件{}", fileName);
        byte[] buffer = new byte[Constant.BYTE_SIZE];
        int len = -1;
        try (RandomAccessFile accessFile = new RandomAccessFile(fileName, "rw")){
            // 读取文件中的所有数据（按顺序读取）
            for (int i = 0; i < Constant.THREAD_NUM; i++) {
                // 将下载的切片数据全部读取到输入流中，然后在进行输出，完成合并的操作
                try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName + ".temp" + i))){
                    while ((len = bis.read(buffer)) != -1){
                        // 将数据写出到指定的位置
                        accessFile.write(buffer, 0, len);
                    }
                }
            }
            LogUtils.info("文件合并成功{}",fileName);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    // 删除零时的文件（也就是分片下载得到的数据）
    public boolean clearTempFile(String fileName){
        for (int i = 0; i < Constant.THREAD_NUM; i++) {
            // 获取要删除的文件路径
            File file = new File(fileName + ".temp" + i);
            // 删除指定的文件
            file.delete();
        }
        return true;
    }


}
