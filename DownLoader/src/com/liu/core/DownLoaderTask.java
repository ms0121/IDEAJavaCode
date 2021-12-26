package com.liu.core;

import com.liu.constant.Constant;
import com.liu.util.HttpUtils;
import com.liu.util.LogUtils;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * @author lms
 * @date 2021-10-11 - 13:29
 * 分块下载任务
 */
public class DownLoaderTask implements Callable<Boolean> {

    // 下载文件的地址
    private String url;

    // 下载文件的开始位置
    private long startPos;

    // 结束位置
    private long endPos;

    // 用于记录当前下载的是文件的第几个部分
    private Integer part;

    // 计数器
    private CountDownLatch countDownLatch;

    public DownLoaderTask(String url, long startPos, long endPos, Integer part, CountDownLatch countDownLatch) {
        this.url = url;
        this.startPos = startPos;
        this.endPos = endPos;
        this.part = part;
        this.countDownLatch = countDownLatch;
    }

    // 编写具体的任务实现
    @Override
    public Boolean call() throws Exception {
        // 获取文件名
        String httpFileName = HttpUtils.getHttpFileName(url);
        // 获取分块的文件名
        httpFileName = httpFileName + ".temp" + part;
        // 文件下载的路径
        httpFileName = Constant.PATH + httpFileName;

        // 获取分块下载的连接
        HttpURLConnection httpURLConnection = HttpUtils.getHttpURLConnection(url, startPos, endPos);

        // 下载文件
        try(
                // 获取输入流以及对应的缓冲流
                InputStream input = httpURLConnection.getInputStream();
                BufferedInputStream bis = new BufferedInputStream(input);
                // 使用随机的文件流，实现断点下载(可以实现移动指针)
                RandomAccessFile accessFile = new RandomAccessFile(httpFileName, "rw")
        ) {
            byte[] buffer = new byte[Constant.BYTE_SIZE];
            int len = -1;
            while ((len = bis.read(buffer)) != -1){
                // 1秒内下载的数据之和，因为使用的是多线程，所以使用的是元子类
                DownLoadInfoThreadPlus.downSize.add(len);
                accessFile.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e){
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
