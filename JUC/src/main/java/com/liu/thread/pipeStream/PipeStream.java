package com.liu.thread.pipeStream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author lms
 * @date 2021-10-12 - 22:57
 * 线程的通信方式：管道
 */
public class PipeStream {

    public static void main(String[] args) {

    }

    // 定义方法向管道流中进行写入数据
    public static void writeData(PipedOutputStream out) {
        try {
            for (int i = 0; i < 100; i++) {
                String data = "" + i;
                out.write(data.getBytes());
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 定义方法从管道流中读取数据
    public static void readData(PipedInputStream in) {
        try {
            byte[] buffer = new byte[1024];
            // 从管道输入字节流中读取字节并保存到字节数组中
            // 返回读取到的字节数，如果没有读到数据就返回-1
            int len = in.read(buffer);
            while (len != -1){
                // 将读取到的长度为len的字节转换为字符串
                System.out.println(new String(buffer, 0, len));
                len = in.read(buffer);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
