package com.liu.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author lms
 * @date 2021-10-11 - 8:24
 */
public class HttpUtils {

    /**
     * 计算要下载文件的大小
     * @param url
     * @return
     * @throws IOException
     */
    public static long getHttpFileContentLength(String url) throws IOException {
        int length;
        HttpURLConnection httpURLConnection = null;
        try {
            // 获取要下载的文件链接对象
            httpURLConnection = getHttpURLConnection(url);
            // 计算下载文件的大小
            length = httpURLConnection.getContentLength();
        } finally {
            if (httpURLConnection != null){
                httpURLConnection.disconnect();
            }
        }
        return length;
    }


    /**
     * 对文件进行分块下载
     * @param url 源文件的路径
     * @param startPos 下载文件的开始位置
     * @param endPos 下载文件的结束位置
     * @return
     */
    public static HttpURLConnection getHttpURLConnection(String url, long startPos, long endPos) throws IOException {
        // 获取http的链接对象(因为同样需要使用请求头)
        HttpURLConnection httpURLConnection = getHttpURLConnection(url);
        LogUtils.info("下载的区间是{} - {}", startPos, endPos);

        // endPos不等于0 说明是中间部分
        if (endPos != 0){
            // 通过http设置切片的字段，bytes=100-200，即要获取100-200之间的数据
            httpURLConnection.setRequestProperty("RANGE", "bytes=" + startPos + "-" + endPos);
        }else {
            // 分块的最后一部分，默认就是startPos - 末尾
            httpURLConnection.setRequestProperty("RANGE", "bytes=" + startPos + "-");
        }
        return httpURLConnection;
    }


    // 获取链接对象(即要下载的httpConnection对象)
    public static HttpURLConnection getHttpURLConnection(String url) throws IOException {
        // 获取链接对象(本地和服务器进行连接)
        URL httpUrl = new URL(url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) httpUrl.openConnection();
        // 模拟浏览器和服务器进行连接
        httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:2.0.1) Gecko/20100101 Firefox/4.0.1");
        return httpURLConnection;
    }

    // 获取下载文件的文件名
    public static String getHttpFileName(String url){
        int index = url.lastIndexOf("/");
        // 文件名
        return url.substring(index + 1);
    }

}
