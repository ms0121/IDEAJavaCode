package com.liu.core;

import com.liu.constant.Constant;

/**
 * @author lms
 * @date 2021-10-11 - 9:38
 *
 */
// 单线程下载文件的显示信息
//用来展示下载信息的线程
public class DownLoadInfoThread implements Runnable {

    // 下载文件的总大小（字节）
    private long httpFileContextLength;

    // 表示本地已经下载文件的大小
    public double finishedSize;

    // 本次累计已下载的大小(用于计算下载速率)，强制从主内存中读取值
    // 为什么使用volatile？因为一个线程会去读取数据（每秒钟），
    //  另个一个线程会去修改数据(下载累积到downSize变量中)
    public volatile double downSize;

    // 记录前一次（秒）下载的大小（实现下载速率的计算：downSize - preSize）
    public double preSize;

    public DownLoadInfoThread(long httpFileContextLength) {
        this.httpFileContextLength = httpFileContextLength;
    }

    // 线程会执行的方法
    @Override
    public void run() {
        // 计算总文件的大小,单位mb
        String httpFileSize = String.format("%.2f", httpFileContextLength / Constant.MB);

        // 计算每秒钟的下载速度 kb
        int speed = (int) ((downSize - preSize) / 1024d);
        // 更新
        preSize = downSize;

        // 计算剩余文件的大小(总文件 - 已下载 - 当前下载)
        double remainSize = httpFileContextLength - finishedSize - downSize;
        // 计算剩余的时间
        String remainTime = String.format("%.1f", remainSize / 1024d / speed);
        // 刚开始的时候（speed=0），剩余时间是无限大
        if ("Infinity".equalsIgnoreCase(remainTime)){
            remainTime = "-";
        }

        // 计算已下载的大小（当次已下载的大小，单位是MB）
        String currentFileSize = String.format("%.2f", (downSize - finishedSize) / Constant.MB);
        // 输出的打印信息
        String downInfo = String.format("已下载 %smb / %smb, 速度 %skb/s, 剩余时间 %ss",
                currentFileSize, httpFileSize, speed, remainTime);
        System.out.print("\r");
        System.out.print(downInfo);
    }
}
