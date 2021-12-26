package com.liu.util;

import java.io.File;

/**
 * @author lms
 * @date 2021-10-11 - 10:54
 *
 */
public class FileUtils {

    /**
     * 目的就是根据提供的文件名去查询本地，看看是否已经下载过
     * @param path
     * @return
     */
    public static long getFileContextLength(String path){
        File file = new File(path);
        return file.exists() && file.isFile() ? file.length() : 0;
    }

}
