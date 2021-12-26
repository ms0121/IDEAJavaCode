package com.liu.core;

import com.liu.constant.Constant;
import com.liu.util.FileUtils;
import com.liu.util.HttpUtils;
import com.liu.util.LogUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author lms
 * @date 2021-10-11 - 8:35
 *
 * 因为downloader主线程是用来执行下载操作的，所以要想在下载文件的同时又打印下载文件相关的信息，
 * 一个主线程无法执行，所以需要额外开启一个线程来执行打印信息
 *
 * 使用单一的线程下载文件
 */
public class Downloader {

    // 创建线程池
    public ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

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
        DownLoadInfoThread downLoadInfoThread = null;

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
            downLoadInfoThread = new DownLoadInfoThread(contentLength);
            // 将任务交给线程去执行，每个一秒钟执行一次
            scheduledExecutorService.scheduleAtFixedRate(downLoadInfoThread, 1,1, TimeUnit.SECONDS);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 执行文件下载的操作
        // 下载文件实质也是利用文件流的方式进行,在try()中的流会自动进行关闭
        try(// 从链接对象中获取文件的输入流
            InputStream input = httpURLConnection.getInputStream();
            // 从输入流中获取缓冲流(相当于把文件已经下载到了内存当中)
            BufferedInputStream bis = new BufferedInputStream(input);

            // 用输出流将文件写入到磁盘中
            // 指定文件要输出到的路径
            FileOutputStream fos = new FileOutputStream(httpFileName);
            BufferedOutputStream bos = new BufferedOutputStream(fos);)
        {
            int len = -1;
            // 将数据读取到buffer数组中
            byte[] buffer = new byte[Constant.BYTE_SIZE];
            while ((len = bis.read(buffer)) != -1){
                // 将每次下载字节长度加到downSize上
                downLoadInfoThread.downSize += len;
                bos.write(buffer, 0,   len);
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
        }
    }
}
