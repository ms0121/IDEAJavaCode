package com.liu.file.transfer.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @description: http相关接口的操作类
 * @author: lms
 * @date: 2022-04-23 16:45
 */
public class HttpUtils {


    /**
     * 分片下载的数据设置
     * @param url
     * @param startPos 文件下载开始的位置
     * @param endPos 文件下载的结束位置
     * @return 第一块的startPos为0，最后一块的endPos也为0
     */
    public static HttpURLConnection getHttpURLConnection(String url, long startPos, long endPos) throws IOException {
        // 获取连接对象
        HttpURLConnection httpURLConnection = getHttpURLConnection(url);
        LogUtils.info("下载的文件区间是{} -- {}", startPos, endPos);
        if (endPos != 0) {
            // 不是最后一块数据
            // 通过http设置切片的字段，bytes=100-200，即要获取100-200之间的数据
            httpURLConnection.setRequestProperty("RANGE", "bytes=" + startPos + "-" + endPos);
        }else {
            // 分块的最后一部分，默认就是startPos - 末尾
            httpURLConnection.setRequestProperty("RANGE", "bytes=" + startPos + "-");
        }
        return httpURLConnection;
    }


    /**
     * 计算指定url文件的大小
     *
     * @param url 需要下载的文件路径
     * @return
     */
    public static long getFileContentLength(String url) {
        // 记录需要下载的文件大小
        int contentLength = 0;
        HttpURLConnection httpURLConnection = null;
        try {
            // 获取文件连接对象
            httpURLConnection = getHttpURLConnection(url);
            // 根据连接对象计算出整个要下载文件的大小
            contentLength = httpURLConnection.getContentLength();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 如果没有连接成功，则断开连接
            if (httpURLConnection == null) {
                httpURLConnection.disconnect();
            }
        }
        return contentLength;
    }


    /**
     * 通过url获取到要下载的httpConnection对象
     *
     * @param url
     * @return
     */
    public static HttpURLConnection getHttpURLConnection(String url) throws IOException {
        // 获取连接对象(本地和远程服务器的连接对象)
        URL httpUrl = new URL(url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) httpUrl.openConnection();
        // 模拟浏览器进行连接
        httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:2.0.1) Gecko/20100101 Firefox/4.0.1");
        return httpURLConnection;
    }

    /**
     * 获取下载的文件名
     * @param url
     * @return
     */
    public static String getHttpFileName(String url){
        // 获取最后一个 / 的下标
        int idx = url.lastIndexOf("/");
        // 截取文件名
        return url.substring(idx + 1);
    }

}
