package com.liu.utils;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author lms
 * @date 2021-05-05 - 10:26
 */
public class MyUtils {

    private static SqlSessionFactory factory = null;

//   使用静态代码块进行创建SqlSessionFactory
    static {
        try {
            String config = "mybatis.xml";
            // 读取配置文件
            InputStream in = Resources.getResourceAsStream(config);
            // 通过SqlSessionFactoryBuilder获取SqlSessionFactory
            factory = new SqlSessionFactoryBuilder().build(in);

        } catch (IOException e) {
            factory = null;
            e.printStackTrace();
        }
    }

    // 获取SqlSession对象
    public static SqlSession getSqlSession(){
        SqlSession session = null;
        if (factory != null){
            session = factory.openSession();
        }
        return session;
    }
}
