package com.liu.file.transfer.utils;

import java.io.File;

/**
 * @description:
 * @author: lms
 * @date: 2022-04-23 17:10
 */
public class FileUtils {

    /**
     * 判断该路径是否存在文件，并将文件的大小进行返回
     * @param filePath
     * @return
     */
    public static long getLocalFileContextLength(String filePath) {
        File file = new File(filePath);
        return file.exists() && file.isFile() ? file.length() : 0;
    }

}
