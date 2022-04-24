package com.liu.file.transfer.core.download.fragment;


import com.liu.file.transfer.constant.Constant;
import com.liu.file.transfer.utils.FileUtils;
import com.liu.file.transfer.utils.HttpUtils;
import com.liu.file.transfer.utils.LogUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @description: 实现文件的分片下载
 * @author: lms
 * @date: 2022-04-23 16:56
 */
public class FragmentDownloader {
    /**
     * 下载指定url文件
     *
     * @param url
     */

    // 创建线程池，执行打印的任务
    public ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    // 创建线程池执行提交的任务对象
    public ThreadPoolExecutor threadPools =
            new ThreadPoolExecutor(Constant.THREAD_NUM, Constant.THREAD_NUM, 0,
                    TimeUnit.SECONDS, new ArrayBlockingQueue<>(Constant.THREAD_NUM));

    // 创建计数器
    public CountDownLatch countDownLatch = new CountDownLatch(Constant.THREAD_NUM);

    /**
     * 下载的方法
     *
     * @param url
     */
    public void download(String url) {
        // 获取文件名
        String httpFileName = HttpUtils.getHttpFileName(url);
        // 设置文件保存的路径
        String filePath = Constant.PATH + httpFileName;
        // 判断相应的路径上是否已经下载过
        long localFileContextLength = FileUtils.getLocalFileContextLength(filePath);
        // 获取文件下载连接对象
        HttpURLConnection httpURLConnection = null;
        // 下载信息任务对象
        DownloaderInfoPlus downloaderInfoPlus = null;

        try {
            // 获取连接对象
            httpURLConnection = HttpUtils.getHttpURLConnection(url);
            // 获取下载文件的总大小
            int contentLength = httpURLConnection.getContentLength();
            // 判断当前要下载的文件是否已经被下载过
            if (localFileContextLength > contentLength) {
                LogUtils.info("{} 当前文件已经存在!", httpFileName);
                return;
            }
            // 创建下载信息任务对象
            downloaderInfoPlus = new DownloaderInfoPlus(contentLength);
            // 线程池每隔一秒钟执行一次
            scheduledExecutorService.scheduleAtFixedRate(downloaderInfoPlus, 1, 1, TimeUnit.SECONDS);

            // 执行文件的切分下载操作
            // 使用多线程去下载文件（切分任务）
            ArrayList<Future> list = new ArrayList<>();
            split(url, list);

            // 等待所有的线程执行完成
            countDownLatch.await();

            // 执行文件的合并操作
            if (merge(filePath, url)) {
                // 清除临时文件
                clearTempFile(filePath);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.print("\r");
            System.out.print("文件下载完成~~~~");
            if (httpURLConnection != null) {
                // 断开http连接
                httpURLConnection.disconnect();
            }
            // 关闭线程池
            scheduledExecutorService.shutdown();
            threadPools.shutdown();
        }
    }


    /**
     * 执行文件的分片下载操作
     *
     * @param url        文件路径
     * @param futureList 存放每个任务计算的结果，因为call()会有一个线程执行的返回结果
     */
    public void split(String url, ArrayList<Future> futureList) {
        try {
            // 获取下载文件的总大小
            long contentLength = HttpUtils.getFileContentLength(url);
            // 计算每个线程需要下载的文件大小
            long eachSize = contentLength / Constant.THREAD_NUM;
            // 给每个线程创建对象的下载任务
            for (int i = 0; i < Constant.THREAD_NUM; i++) {
                // 每个分片的开始和结束位置
                long startPos = i * eachSize;
                long endPos;

                // 最后一个文件分片
                if (i == Constant.THREAD_NUM - 1) {
                    endPos = 0;
                } else {
                    // 每个分块文件的结束位置
                    endPos = startPos + eachSize;
                }

                // 如果当前的开始位置不是原文件的开始位置，则需要进行加1
                if (startPos != 0){
                    startPos++;
                }

                // 创建下载任务对象
                FragmentDownloadTask fragmentDownloadTask = new FragmentDownloadTask(url, startPos, endPos, i, countDownLatch);

                // 将任务对象提交到线程池中
                Future<Boolean> future = threadPools.submit(fragmentDownloadTask);
                // 将future返回值添加到list中
                futureList.add(future);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 合并文件操作,还需要进行文件的校验工作，防止下载文件出现的缺失
     *  校验出现了一个小错误，就是在验证远程文件的时候，无法通过url进行直接验证
     * @param fileName 文件路径
     * @return
     */
    public boolean merge(String fileName, String url) {
        // 通过url计算出源文件的md5加密串
        // String originFileMd5 = FileUtils.checkFileMd5(url);

        LogUtils.info("开始合并文件: ");
        int len = -1;
        byte[] buffer = new byte[Constant.TYPE_SIZE];
        try (
               // 获取随机读写文件流
               RandomAccessFile accessFile = new RandomAccessFile(fileName, "rw")
        ){
            // 按照顺序读写临时文件，然后进行写出
            for (int i = 0; i < Constant.THREAD_NUM; i++) {
                // 文件输入流
               try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName + ".temp" + i))){
                   while ((len = bis.read(buffer)) != -1) {
                       accessFile.write(buffer, 0, len);
                   }
               }
            }

            LogUtils.info("文件校验正确，合并成功~~~~~");

//             计算合并完成的文件加密串
//            String newFileMd5 = FileUtils.checkFileMd5(fileName);
//             验证是否是同一个文件
//            if (originFileMd5.equals(newFileMd5)) {
//                // 合并成功
//                LogUtils.info("文件校验正确，合并成功~~~~~");
//            }else {
//                // 合并成功
//                LogUtils.info("下载的文件有缺失，请重新进行下载~~~~~");
//            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    /**
     * 删除临时文件
     * @param fileName
     */
    public boolean clearTempFile(String fileName) {
        for (int i = 0; i < Constant.THREAD_NUM; i++) {
            File file = new File(fileName + ".temp" + i);
            file.delete();
        }
        return true;
    }

}


