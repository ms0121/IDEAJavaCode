package com.liu.spring.demo3;

import com.sun.org.apache.xml.internal.serialize.LineSeparator;

import java.util.List;

/**
 * @author lms
 * @date 2021-04-11 - 9:35
 */

// 把集合注入的部分提取出来，类似于类中相同的方法进行提取公共部分进行封装
//    1.在spring配置文件中设置所属空间util
public class Book {
    private List<String> nameList;

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }

    @Override
    public String toString() {
        return "Book{" +
                "nameList=" + nameList +
                '}';
    }
}
