package com.liu.learn;

import org.junit.Test;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;


/**
 * @author lms
 * @date 2021-12-25 - 19:43
 */
public class RandomAccessFileTest {

    @Test
    public void read() throws Exception {
        File file = new File("D:/E_DISK/IDEAJavaCode/BreakingPointFile/a.txt");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        // 默认读取一个字节
        randomAccessFile.read();

        // 相对路径，跳过前3个字节开始读取数据信息
        // randomAccessFile.skipBytes(3);

        // 绝对路径(从文件头开始读取数据)
        randomAccessFile.seek(3);

        byte[] bytes = new byte[1024];
        // 返回读取到的字节数
        int len = randomAccessFile.read(bytes);
        System.out.println("len = " + len);
        System.out.println("str = " + new String(bytes, 0, len));
    }


    @Test
    public void write() throws Exception {
        File file = new File("D:/E_DISK/IDEAJavaCode/BreakingPointFile/a.txt");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");

        String str = "zhangsan";
        randomAccessFile.write(str.getBytes(StandardCharsets.UTF_8));
    }


}
