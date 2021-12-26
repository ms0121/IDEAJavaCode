package com.liu.jedis;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;
import java.util.Set;

/**
 * @author lms
 * @date 2021-05-02 - 19:36
 */
public class JedisTest {
    public static void main(String[] args) {
        // 创建Jedis对象，主机号，以及端口号,进行连接的时候，需要关闭防火墙
        Jedis jedis = new Jedis("192.168.115.129", 6379);
        String ping = jedis.ping();
        System.out.println("ping = " + ping);
        jedis.close();
    }

    // 事务的操作
    @Test
    public void test6(){
        Jedis jedis = new Jedis("192.168.115.129", 6379);
        // 清空redis数据库
        jedis.flushDB();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello", "world");
        jsonObject.put("name", "lms");
        System.out.println("jsonObject = " + jsonObject);

        // 开启redis事务操作
        Transaction multi = jedis.multi();
        String string = jsonObject.toJSONString();
//        System.out.println("string = " + string);
        try {
            multi.set("user1", string);
            multi.set("user2", string);
            // 模拟事务异常现象
            int i = 1 / 0;
            // 执行事务操作
            multi.exec();
        } catch (Exception e) {
            // 出现异常放弃事务操作
            multi.discard();
            e.printStackTrace();
        } finally {
            System.out.println("jedis.get(\"user1\") = " + jedis.get("user1"));
            System.out.println("jedis.get(\"user2\") = " + jedis.get("user2"));
            // 关闭连接
            jedis.close();
        }
    }




    @Test
    public void test1() {
        Jedis jedis = new Jedis("192.168.115.129", 6379);
        jedis.set("name","zhangsan");
        jedis.set("age", "20");
        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println("key = " + key);
        }

        System.out.println("jedis.exists(\"name\") = " + jedis.exists("name"));
        System.out.println("jedis.ttl(\"name\") = " + jedis.ttl("name"));
        System.out.println("jedis.get(\"name\") = " + jedis.get("name"));
    }


//   操作list的方式
    @Test
    public void test2() {
        Jedis jedis = new Jedis("192.168.115.129", 6379);
        jedis.lpush("key1", "lucy","lisi","zhangsan");
        List<String> value = jedis.lrange("key1", 0, -1);
        System.out.println("value = " + value);
    }


    //   操作set的方式
    @Test
    public void test3() {
        Jedis jedis = new Jedis("192.168.115.129", 6379);
        jedis.sadd("names", "zhangsan");
        jedis.sadd("names", "lisi");
        jedis.sadd("names", "sary");
        jedis.sadd("names", "zhangsan");

        // 取出当前key对应的所有值
        Set<String> names = jedis.smembers("names");
        System.out.println("names = " + names);
    }


    //   操作hash的方式
    @Test
    public void test4() {
        Jedis jedis = new Jedis("192.168.115.128", 6379);
        jedis.hset("user","age", "20");
        String hget = jedis.hget("user", "age");
        System.out.println("hget = " + hget);
    }


    //   操作zset的方式
    @Test
    public void test5() {
        Jedis jedis = new Jedis("192.168.115.129", 6379);

    }
}












