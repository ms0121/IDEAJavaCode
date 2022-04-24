package com.liu.file.transfer.utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

/**
 * @description:
 * @author: lms
 * @date: 2022-04-23 17:10
 */
public class FileUtils {

    /**
     * 使用md5加密进行检验下载的文件是否有丢失
     *
     * @param url 文件的路径
     * @return
     */
    public static String checkFileMd5(String url) throws Exception {
        // 拿到一个MD5转换器
        MessageDigest digest = MessageDigest.getInstance("MD5");
        File file = new File(url);
        FileInputStream fis = new FileInputStream(file);
        // 获取连接文件的通道, 缓冲区的字节可以通过绝对路径被读写，而当前channel的位置不受影响
        FileChannel channel = fis.getChannel();
        // 将文件的区块直接映射到内存中
        MappedByteBuffer byteBuffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
        // 使用digest进行转换
        digest.update(byteBuffer);
        // 获取加密后的字节数组，长度16
        byte[] bytes = digest.digest();
        // System.out.println("bytes.length = " + bytes.length);
        return new String(bytes);
    }


    /**
     * 判断该路径是否存在文件，并将文件的大小进行返回
     *
     * @param filePath
     * @return
     */
    public static long getLocalFileContextLength(String filePath) {
        File file = new File(filePath);
        return file.exists() && file.isFile() ? file.length() : 0;
    }

}
