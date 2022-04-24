package com.liu.file.transfer.core.download.fragment;

import com.liu.file.transfer.constant.Constant;

import java.util.concurrent.atomic.LongAdder;

/**
 * @description: 下载信息显示类（就是一个任务类）, 因为需要被线程进行执行，所以需要实现相关的接口
 *      多线程下载文件（需要使用原子类的方式）
 *      用来展示下载信息的线程
 * @author: lms
 * @date: 2022-04-23 17:25
 */
public class DownloaderInfoPlus implements Runnable {
    // 记录总文件的大小
    public long httpFileContextLength;

    // 记录本地已经下载的文件大小
    public static volatile LongAdder finishedSize = new LongAdder();

    // 记录档次已经下载的文件大小
    // 因为当前的变量被多个线程进行访问，所以需要将其设置为volatile类型，目的就是让每个线程都去主内存中读取数据信息
    // 这样子就可以保证变量的可见性
    // 修改为原子类(static为了方便操作，只适合当个用户使用)
    public static volatile LongAdder downSize = new LongAdder();

    // 记录上一秒内已经下载好的文件大小
    public double preSize;

    // 构造器进行初始化相关的参数值
    public DownloaderInfoPlus(int httpFileContextLength) {
        this.httpFileContextLength = httpFileContextLength;
    }

    /**
     * 执行打印下载信息的任务
     */
    @Override
    public void run() {
        // 计算总文件的大小，将其格式化为MB
        String httpFileSize = String.format("%.2f", this.httpFileContextLength / Constant.MB);
        // 计算每秒钟下载的文件大小(也就是计算下载速度)
        int speed = (int) ((downSize.doubleValue() - preSize) / 1024d);
        // 更新上一次的文件大小
        preSize = downSize.doubleValue();

        // 计算剩余文件的大小
        double remainSize = httpFileContextLength - downSize.doubleValue();
        // 计算下载完成还需要的时间
        String remainTime = String.format("%.1f", remainSize / 1024d / speed);
        // 刚开始的时候（speed=0），剩余时间是无限大
        if ("Infinity".equalsIgnoreCase(remainTime)) {
            remainTime = "-";
        }

        // 计算已下载的大小（当次已下载的大小，单位是MB）
        String currentFileSize = String.format("%.2f", downSize.doubleValue() / Constant.MB);
        // 输出的打印信息
        String downInfo = String.format("已下载 %smb / %smb, 速度 %skb/s, 剩余时间 %ss",
                currentFileSize, httpFileSize, speed, remainTime);
        // 不间断的进行刷新，从而让显示信息只在第一行显示
        System.out.print("\r");
        System.out.print(downInfo);
    }
}
