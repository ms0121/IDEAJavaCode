package com.liu;

import com.liu.core.DownloaderPlus;
import com.liu.util.LogUtils;

import java.util.Scanner;

public class Main {

    // https://down.qq.com/qqweb/PCQQ/PCQQ_EXE/PCQQ2021.exe
    // 分片: 60s
    // 单一：160s

    public static void main(String[] args) {
        // 输入下载地址
        String url = null;
        if (args == null || args.length == 0) {
            for (; ; ) {
                LogUtils.info("请输入下载地址: ");
                Scanner scanner = new Scanner(System.in);
                url = scanner.next();
                if (url != null) {
                    break;
                }
            }
        } else {
            url = args[0];
        }

//        单线程的下载器
//        System.out.println("开始时间：" + System.currentTimeMillis() / 1000);
//        Downloader downloader = new Downloader();
//        downloader.downloader(url);
//        System.out.println("结束时间：" + System.currentTimeMillis() / 1000);

//        切片下载
        System.out.println("开始时间：" + System.currentTimeMillis() / 1000);
        DownloaderPlus downloaderPlus = new DownloaderPlus();
        downloaderPlus.downloader(url);
        System.out.println("开始时间：" + System.currentTimeMillis() / 1000);
    }
}
