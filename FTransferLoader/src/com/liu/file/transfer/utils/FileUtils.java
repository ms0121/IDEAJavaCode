package com.liu.file.transfer.utils;


import com.liu.file.transfer.constant.Constant;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.*;

/**
 * @description:
 * @author: lms
 * @date: 2022-04-23 17:10
 */
public class FileUtils {

    public static void main(String[] args) {
        String url = "E:/java_learn_tmp_file/upload/lmstest";
        String desDir = "E://";
        decompress(url, desDir);
    }

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

    /**
     * 没有指定压缩后的存放路径，则直接使用默认的路径进行压缩(直接压缩再E盘目录下)
     *
     * @param dirPath 源文件路径
     */
    public static void compress(String dirPath) {
        int firstIndex = dirPath.indexOf("/");
        int lastIndex = dirPath.lastIndexOf("/");
        // 解压到指定的盘，以及压缩包的文件名，如: E:/images
        String zipFileName = dirPath.substring(0, firstIndex + 1) + dirPath.substring(lastIndex + 1);
        compress(dirPath, zipFileName);
        System.out.println("压缩成功");
    }

    /**
     * 压缩文件
     *
     * @param dirPath     压缩源文件路径    D:/liumingshan3/Desktop/images
     * @param zipFileName 压缩目标文件路径  D:/images
     */
    public static void compress(String dirPath, String zipFileName) {
        zipFileName = zipFileName + Constant.SUFFIX;//添加文件的后缀名zip
        File dirFile = new File(dirPath);
        // 获取路径上的所有文件: 如D:/liumingshan3/Desktop/images/test.jpg
        List<File> fileList = getAllFile(dirFile);

        byte[] buffer = new byte[Constant.TYPE_SIZE];
        // 创建压缩文件中的条目
        ZipEntry zipEntry = null;
        int readLength = 0;     //每次读取出来的长度

        try {
            // CheckedOutputStream类可实现带验证的压缩、解压, 对输出文件做CRC32校验
            CheckedOutputStream cos = new CheckedOutputStream(new FileOutputStream(
                    zipFileName), new CRC32());
            // zip的输出流
            ZipOutputStream zos = new ZipOutputStream(cos);

            for (File file : fileList) {

                if (file.isFile()) {   //若是文件，则压缩文件
                    zipEntry = new ZipEntry(getRelativePath(dirPath, file));
                    // 进行压缩文件
                    zipEntry.setSize(file.length());
                    zipEntry.setTime(file.lastModified());
                    zos.putNextEntry(zipEntry);

                    InputStream is = new BufferedInputStream(new FileInputStream(file));
                    // 将文件通过zos进行写入
                    while ((readLength = is.read(buffer, 0, Constant.TYPE_SIZE)) != -1) {
                        zos.write(buffer, 0, readLength);
                    }
                    is.close();
                    System.out.println("file compress:" + file.getCanonicalPath());
                } else {     //若是空目录，则写入zip条目中
                    zipEntry = new ZipEntry(getRelativePath(dirPath, file));
                    zos.putNextEntry(zipEntry);
                    System.out.println("dir compress: " + file.getCanonicalPath() + "/");
                }
            }
            zos.close();  //最后得关闭流，不然压缩最后一个文件会出错
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 得到源文件路径的所有文件
     *
     * @param dirFile 压缩源文件路径
     */
    public static List<File> getAllFile(File dirFile) {

        List<File> fileList = new ArrayList<>();
        // 获取指定目录的所有文件信息
        File[] files = dirFile.listFiles();
        for (File file : files) {
            //文件
            if (file.isFile()) {
                fileList.add(file);
                System.out.println("add file:" + file.getName());
            } else {
                //目录
                if (file.listFiles().length != 0) {//非空目录
                    fileList.addAll(getAllFile(file));//把递归文件加到fileList中
                } else {//空目录
                    fileList.add(file);
                    System.out.println("add empty dir:" + file.getName());
                }
            }
        }
        return fileList;
    }

    /**
     * 获取相对路径
     *
     * @param dirPath 源文件路径  D:\liumingshan3\Desktop\images
     * @param file    准备压缩的单个文件  D:\liumingshan3\Desktop\images\test.jpg
     */
    public static String getRelativePath(String dirPath, File file) {
        File dirFile = new File(dirPath);
        // 获取压缩文件的文件名 test.jpg
        String relativePath = file.getName();

        while (true) {
            // file得到的路径为 D:\liumingshan3\Desktop\images
            file = file.getParentFile();
            if (file == null) break;
            if (file.equals(dirFile)) {
                break;
            } else {
                relativePath = file.getName() + "/" + relativePath;
            }
        }
        return relativePath;
    }

    /**
     * 解压
     *
     * @param zipFileName 需要解压的文件，不携带.zip
     * @param destPath    解压到的路径
     */
    public static void decompress(String zipFileName, String destPath) {
        try {
            zipFileName = zipFileName + Constant.SUFFIX;
            // 将压缩文件的内容添加到输入流
            ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFileName));
            ZipEntry zipEntry = null;
            byte[] buffer = new byte[Constant.TYPE_SIZE];//缓冲器
            int readLength = 0;//每次读出来的长度
            while ((zipEntry = zis.getNextEntry()) != null) {
                if (zipEntry.isDirectory()) {//若是目录
                    File file = new File(destPath + "/" + zipEntry.getName());
                    if (!file.exists()) {
                        file.mkdirs();
                        System.out.println("mkdirs:" + file.getCanonicalPath());
                        continue;
                    }
                }
                //若是文件
                File file = createFile(destPath, zipEntry.getName());
                System.out.println("file created: " + file.getCanonicalPath());
                OutputStream os = new FileOutputStream(file);
                while ((readLength = zis.read(buffer, 0, Constant.TYPE_SIZE)) != -1) {
                    os.write(buffer, 0, readLength);
                }
                os.close();
                System.out.println("file uncompressed: " + file.getCanonicalPath());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param destPath 解压目标路径
     * @param fileName 解压文件的相对路径
     */
    public static File createFile(String destPath, String fileName) {

        String[] dirs = fileName.split("/");//将文件名的各级目录分解
        File file = new File(destPath);

        if (dirs.length > 1) {//文件有上级目录
            for (int i = 0; i < dirs.length - 1; i++) {
                file = new File(file, dirs[i]);//依次创建文件对象知道文件的上一级目录
            }

            if (!file.exists()) {
                file.mkdirs();//文件对应目录若不存在，则创建
                try {
                    System.out.println("mkdirs: " + file.getCanonicalPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            file = new File(file, dirs[dirs.length - 1]);//创建文件

            return file;
        } else {
            if (!file.exists()) {//若目标路径的目录不存在，则创建
                file.mkdirs();
                try {
                    System.out.println("mkdirs: " + file.getCanonicalPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            file = new File(file, dirs[0]);//创建文件
            return file;
        }
    }

}


