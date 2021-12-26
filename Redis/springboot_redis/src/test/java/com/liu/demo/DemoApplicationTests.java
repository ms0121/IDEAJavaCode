package com.liu.demo;

import com.liu.demo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;


    @Test
    void test01(){
        // 当前的User类没有进行序列化，所以设置失败
        User user = new User("张三",20);
        redisTemplate.opsForValue().set("user", user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }



    @Test
    void contextLoads() {
        /**
         * redisTemplate 操作不同的数据类型，api和我们的指令是一样的
         * opsForValue() 操作字符串，类似于 String
         * opsForList()  操作list
         * opsForSet()   擦作set
         * opsForHash()   操作hash
         * opsForZSet()  操作zset
         *
         * 除了基本的命令之外，我们常用的方法都可以直接通过redisTemplate进行操作，比如事务和基本的crud
         *
         * redis连接数据库
         *  RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
         *         connection.flushDb();
         *         connection.flushAll();
         */

        redisTemplate.opsForValue().set("name", "lms-yyds");
        System.out.println("" +
                redisTemplate.opsForValue().get("k1"));
    }

}
