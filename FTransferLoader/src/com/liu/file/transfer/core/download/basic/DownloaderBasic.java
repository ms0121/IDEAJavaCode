package com.liu.file.transfer.core.download.basic;


import com.liu.file.transfer.constant.Constant;
import com.liu.file.transfer.utils.FileUtils;
import com.liu.file.transfer.utils.HttpUtils;
import com.liu.file.transfer.utils.LogUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @description: 实现最基础的文件下载功能（单线程版本的下载器）
 * @author: lms
 * @date: 2022-04-23 16:56
 */
public class DownloaderBasic {
    /**
     * 下载指定url文件
     *
     * @param url
     */

    // 创建线程池，执行打印的任务
    public ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    public void download(String url) {
        if (url.equals("")) {
            throw new RuntimeException("请输入正确的url");
        }
        // 获取文件名
        String httpFileName = HttpUtils.getHttpFileName(url);
        // 设置文件保存的路径
        String filePath = Constant.PATH + httpFileName;
        // 判断相应的路径上是否已经下载过
        long localFileContextLength = FileUtils.getLocalFileContextLength(filePath);
        // 获取文件下载连接对象
        HttpURLConnection httpURLConnection = null;
        // 记录总文件的大小
        int contentLength = 0;
        // 下载信息任务对象
        DownloaderInfo downloaderInfo = null;

        try {
            httpURLConnection = HttpUtils.getHttpURLConnection(url);
            // 获取下载文件的总大小
            contentLength = httpURLConnection.getContentLength();
            // 判断当前要下载的文件是否已经被下载过
            if (localFileContextLength > contentLength) {
                LogUtils.info("{} 当前文件已经存在!", httpFileName);
                return;
            }
            // 创建下载信息任务对象
            downloaderInfo = new DownloaderInfo(contentLength);
            // 线程池每隔一秒钟执行一次
            scheduledExecutorService.scheduleAtFixedRate(downloaderInfo, 1, 1, TimeUnit.SECONDS);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 使用IO流实现文件的下载操作
        try (
                // 获取输入流
                InputStream inputStream = httpURLConnection.getInputStream();
                // 获取输入缓冲流
                BufferedInputStream bis = new BufferedInputStream(inputStream);
                // 设置文件输出流
                FileOutputStream fos = new FileOutputStream(filePath);
                // 设置文件输出缓冲流
                BufferedOutputStream bos = new BufferedOutputStream(fos)
        ) {
            // 实现文件的下载操作
            int len = -1;
            byte[] buffer = new byte[Constant.TYPE_SIZE];
            while ((len = bis.read(buffer)) != -1) {
                // 将每次下载的字节数添加到downSize属性中
                downloaderInfo.downSize += len;
                // 将文件写入到磁盘中
                bos.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            LogUtils.error("下载的文件 {} 不存在!", url);
        } catch (Exception e) {
            LogUtils.error("文件下载失败!");
        } finally {
            System.out.print("\r");
            System.out.print("文件下载完成~~~~");
            if (httpURLConnection != null) {
                // 断开http连接
                httpURLConnection.disconnect();
            }
            // 关闭线程池
            scheduledExecutorService.shutdown();
        }
    }

}
