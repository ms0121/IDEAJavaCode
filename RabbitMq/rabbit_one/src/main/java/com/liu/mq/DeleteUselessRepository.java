package com.liu.mq;

/**
 * @author lms
 * @date 2021-09-17 - 17:19
 */
import java.io.File;

/**
 * @author xfcyzq
 * @version 1.0
 */
public class DeleteUselessRepository {


    private static String MAVEN_PATH = "D:\\E_DISK\\LocalRepository";

    /**
     * 判断是否存在jar
     *
     * @author xfcyzq
     * @version 1.0
     * @param file
     * @return
     */
    private static boolean judge(File file) {
        boolean isHaveJar = false;
        File[] files = file.listFiles();
        if (files != null && files.length > 0) {
            for (File _file : files) {
                if (_file.getName().endsWith(".jar")) {
                    isHaveJar = true;
                }
                if (_file.isDirectory()) {
                    boolean isNextHaveJar = judge(_file);
                    if (isNextHaveJar) {
                        isHaveJar = true;
                    }
                }
            }
        }
        if (!isHaveJar) {
            delete(file);
        }
        return isHaveJar;
    }

    /**
     * 删除操作
     *
     * @author xfcyzq
     * @version 1.0
     * @param file
     */
    public static void delete(File file) {
        File[] files = file.listFiles();
        if (files != null && files.length > 0) {
            for (File f : files) {
                if (f.isDirectory()) {
                    delete(f);
                }
                f.delete();
                System.out.println("已删除：" + f.getAbsolutePath());
            }
        } else {
            file.delete();
            System.out.println("已删除：" + file.getAbsolutePath());
        }
    }

    public static void main(String[] args) {
        File mavenRoot = new File(MAVEN_PATH);
        if (mavenRoot.exists()) {
            File[] files = mavenRoot.listFiles();
            if (files != null && files.length > 0) {
                for (File file : files) {
                    judge(file);
                }
            }
        }
    }
}
