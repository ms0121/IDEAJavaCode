package com.liu.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liu.entity.Province;

/**
 * @author lms
 * @date 2021-04-23 - 19:25
 */
public class JsonTest {

    public static void main(String[] args) throws JsonProcessingException {

        Province province = new Province(1, "河北", "冀", "石家庄");

        // 使用jackson将province实体转为json数据的形式
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(province);
        System.out.println("s = " + s);
    }
}
