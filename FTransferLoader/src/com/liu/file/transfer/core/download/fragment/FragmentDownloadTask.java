package com.liu.file.transfer.core.download.fragment;

import com.liu.file.transfer.constant.Constant;
import com.liu.file.transfer.utils.HttpUtils;
import com.liu.file.transfer.utils.LogUtils;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * @description: 分片下载任务器，每个线程都将调用这个方法进行下载指定区间的文件
 * 并且还需要判断当前的线程执行的下载任务是否成功，所以让改任务实现Callable接口，通过call方法的返回值来判断下载成功与否
 * @author: lms
 * @date: 2022-04-23 21:36
 */
public class FragmentDownloadTask implements Callable<Boolean> {

    // 下载文件的路径信息
    private String url;

    // 下载文件的开始位置
    private long startPos;

    // 下载文件的结束位置
    private long endPos;

    // 表示当前要下载的是哪个部分文件
    private Integer part;

    // 计数器
    private CountDownLatch countDownLatch;

    // 创建任务对象的时候，需要将相关的属性进行传递
    public FragmentDownloadTask(String url, long startPos, long endPos, int part, CountDownLatch countDownLatch) {
        this.url = url;
        this.startPos = startPos;
        this.endPos = endPos;
        this.part = part;
        this.countDownLatch = countDownLatch;
    }

    // 执行具体的下载任务操作流程
    @Override
    public Boolean call() throws Exception {
        // 获取要下载文件的文件名
        String httpFileName = HttpUtils.getHttpFileName(url);
        // 将当前下载的部分文件设置为临时文件
        httpFileName = httpFileName + ".temp" + this.part;
        // 创建临时文件的保存路径
        httpFileName = Constant.PATH + httpFileName;

        // 获取指定下载区间位置的连接对象
        HttpURLConnection httpURLConnection = HttpUtils.getHttpURLConnection(url, startPos, endPos);

        try (
                // 获取文件输入流
                InputStream inputStream = httpURLConnection.getInputStream();
                // 获取文件输入缓冲流
                BufferedInputStream bis = new BufferedInputStream(inputStream);
                // 创建随机读写的文件对象
                RandomAccessFile randomAccessFile = new RandomAccessFile(httpFileName, "rw");
        ) {
            // 将文件进行写盘操作
            byte[] buffer = new byte[Constant.TYPE_SIZE];
            int len = -1;
            while ((len = bis.read(buffer)) != -1) {
                // 记录每一秒钟下载的字节数量
                DownloaderInfoPlus.downSize.add(len);
                // 写盘
                randomAccessFile.write(buffer, 0, len);
            }
        }  catch (FileNotFoundException e){
            LogUtils.error("下载文件不存在{}", url);
            return false;
        } catch (Exception e){
            LogUtils.error("下载失败");
            return false;
        } finally {
            // 关闭连接
            httpURLConnection.disconnect();
            // 每个线程执行完毕，都将countDownLatch进行减1的操作
            countDownLatch.countDown();
        }
        return true;
    }
}
