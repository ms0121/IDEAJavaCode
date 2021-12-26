package com.liu.jedis;

/**
 * @author lms
 * @date 2021-05-02 - 21:56
 */

import redis.clients.jedis.Jedis;
import sun.plugin2.message.GetAppletMessage;

import java.util.Random;

/**
 * 实现手机验证码的模拟操作：
 *  1、输入手机号，点击发送随机的6位数字码，2分钟内有效
 *  2、输入验证，点击验证，返回成功或者失败
 *  3、每个手机号每天只能输入3次
 */
public class PhoneCode {

    public static void main(String[] args) {
//        模拟验证码的发送
        verifyCode("18811338693");

//        模拟验证登录
//        getRedisCode("18811338693", "893892");

    }

    // 3.验证码的校验
    public static void getRedisCode(String phone, String code){
        // 从redis中获取验证码
        Jedis jedis = new Jedis("192.168.115.128", 6379);
        // 验证码
        String codeKey = "VerifyCode" + phone + ":code";
        String redisCode = jedis.get(codeKey);
        // 判断
        if (redisCode.equals(code)){
            System.out.println("成功!");
        }else {
            System.out.println("失败!");
        }
        jedis.close();
    }


    // 2. 每个手机每天只能发送三次，验证码放到redis中，设置过期时间
    public static void verifyCode(String phone) {
        // 连接redis
        Jedis jedis = new Jedis("192.168.115.128", 6379);

        // 拼接key,作为每一个手机号的 key 值
        // 手机发送次数key
        String countKey = "VerifyCode" + phone + ":count";
        // 验证码key
        String codeKey = "VerifyCode" + phone + ":code";

        // 设置每个手机每天只能发送三次
        String count = jedis.get(countKey);
        if (count == null){
            // 没有发送次数，这是第一次发送
            // 设置发送次数是1
            jedis.setex(countKey, 24*60*60, "1");
        }else if (Integer.parseInt(count) <= 2){
            // 发送次数 +1,该函数相当于: countKey += 1
            jedis.incr(countKey);
        } else  if (Integer.parseInt(count) > 2){
            // 发送3次，不能再进行发送
            System.out.println("今天的发送次数已经超过三次!");
            jedis.close();
        }

        // 2.把要发送的验证码放在redis里面
        String vcode = getCode();
        jedis.setex(codeKey, 120, vcode);
        jedis.close();
    }


    // 1. 生成验证码
    public static String getCode() {
        Random random = new Random();
        String code = "";
        for (int i = 0; i < 6; i++) {
            int rand = random.nextInt(10);
            code += rand;
        }
        return code;
    }

}
















