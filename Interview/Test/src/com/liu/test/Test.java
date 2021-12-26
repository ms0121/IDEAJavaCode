package com.liu.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) {

        try {
            int a = 1 / 0;
        } catch (Exception e) {
            String message = e.getMessage();
            System.out.println("message = " + message);
            e.printStackTrace();
        }


        HashMap<String, String> map = new HashMap<>();
        map.put("1", "11");
        map.put("2", "22");

        // 获取的是map中所有的key值
        Set<String> keySet = map.keySet();
        // 获取的是map中一个个的键值对
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            // 获取每个entry中的键key和对应的值value
            System.out.println(entry.getKey() + " , " + entry.getValue());
        }
    }
}
