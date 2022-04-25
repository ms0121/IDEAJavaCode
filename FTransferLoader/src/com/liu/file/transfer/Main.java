package com.liu.file.transfer;

import com.liu.file.transfer.core.download.fragment.FragmentDownloader;
import com.liu.file.transfer.core.upload.fragment.FragmentUploaderPlus;
import com.liu.file.transfer.utils.LogUtils;

import java.util.Scanner;

/**
 * @description: 文件传输加载器：
 * 1. 实现
 * @author: lms
 * @date: 2022-04-23 16:15
 */
public class Main {
    /**
     * 下载的文件路径： https://down.qq.com/qqweb/PCQQ/PCQQ_EXE/PCQQ2021.exe
     * 文件保存路径：E:\java_learn_tmp_file\
     * <p>
     * 上传的文件路径: E:/JD实习文件/lms学习文件.7z
     *
     * @param args
     */
    public static void main(String[] args) {
        // 输入下载地址
        String url = null;
        Scanner scanner = new Scanner(System.in);
        if (args == null || args.length == 0) {
            for (; ; ) {
                System.out.println("请输入您的选择: 1.下载  2.上传  3.退出");
                int choose = scanner.nextInt();
                if(choose == 1) {
                    LogUtils.info("请输入下载地址: ");
                    url = scanner.next();
                    FragmentDownloader fragmentDownloader = new FragmentDownloader();
                    fragmentDownloader.download(url);
                } else if (choose == 2) {
                    LogUtils.info("请输入需要上传的文件: ");
                    url = scanner.next();
                    FragmentUploaderPlus fragmentUploader = new FragmentUploaderPlus();
                    try {
                        fragmentUploader.upload(url);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (choose == 3) {
                    System.out.println("期待您的下次使用~~~");
                    break;
                } else {
                    System.out.print("\r");
                    continue;
                }
                if (url != null) {
                    break;
                }
            }
        } else {
            url = args[0];
        }
//        基础版本的下载方式
//        DownloaderBasic downloader = new DownloaderBasic();
//        downloader.download(url);

//        多线程分片下载版
//        FragmentDownloader fragmentDownloader = new FragmentDownloader();
//        fragmentDownloader.download(url);


//        多线程分片上传
//        UploaderBasic uploadBasic = new UploaderBasic();
//        uploadBasic.upload(url);

//        多线程分片断点续传
//        FragmentUploaderPlus fragmentUploader = new FragmentUploaderPlus();
//        try {
//            fragmentUploader.upload(url);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}
