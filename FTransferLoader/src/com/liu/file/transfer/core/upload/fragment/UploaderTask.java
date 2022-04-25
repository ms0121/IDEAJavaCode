package com.liu.file.transfer.core.upload.fragment;

import com.liu.file.transfer.constant.Constant;
import com.liu.file.transfer.utils.HttpUtils;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * @description: 将断点续传的任务进行封装称为一个个的任务信息
 * @author: lms
 * @date: 2022-04-25 13:03
 */
public class UploaderTask implements Callable<Boolean> {

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
    public UploaderTask(String url, long startPos, long endPos, int part, CountDownLatch countDownLatch) {
        this.url = url;
        this.startPos = startPos;
        this.endPos = endPos;
        this.part = part;
        this.countDownLatch = countDownLatch;
    }

    /**
     * 线程执行的任务信息
     * @return
     * @throws Exception
     */
    @Override
    public Boolean call() throws Exception {
        // 获取要下载文件的文件名
        String httpFileName = HttpUtils.getHttpFileName(url);
        // 将当前上传的部分文件设置为临时文件
        httpFileName = httpFileName + ".temp" + this.part;
        // 创建临时文件的保存路径
        httpFileName = Constant.PATH + httpFileName;

        return true;
    }
}
