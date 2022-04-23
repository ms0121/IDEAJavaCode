package com.liu.learn;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-12-25 - 20:25
 * 实现多线程的文件复制操作
 */
public class RandomAccessFileTest2 {
    /**
     * 测试单线程的文件复制
     */
    public void SingleFile() {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            File file = new File("C:/Users/Administrator/Desktop/PCQQ2021.exe");
            fis = new FileInputStream(file);
            fos = new FileOutputStream("D:\\360Downloads\\xxx.exe");

            // 一次读取8k字节
            byte[] bytes = new byte[1024 * 8];
            int len = -1;
            long start = System.currentTimeMillis();
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
            long end = System.currentTimeMillis();
            System.out.println("总耗时: " + (end - start));
            System.out.println("文件复制完成~~~");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
