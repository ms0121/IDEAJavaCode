package com.nk.day2;

import java.util.*;

/**
 * @author lms
 * @date 2021-10-06 - 8:23
 * LRU结构：使用双向链表，
 */
public class NC93 {
    public static void main(String[] args) {
//        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
//        map.put("1", 11);
//        map.put("2", 22);
//        map.put("3", 33);
//        map.put("4", 44);
//
//        Set<String> set = map.keySet();
//        System.out.println("set = " + set);
//
//        Iterator<String> iterator = map.keySet().iterator();
//        Integer remove = map.remove(iterator.next());
//        System.out.println("remove = " + remove);

        int[][] arr = {{1,1,1},{1,2,2},{2,1},{1,3,3},{2,2},{1,4,4},{2,1},{2,3},{2,4}};
        int[] lru = LRU(arr, 2);
        for (int i = 0; i < lru.length; i++) {
            System.out.println(lru[i] + " ");
        }
    }


    // 设置LRU结构，实现缓存的结构
    public static int[] LRU(int[][] operators, int k) {
        // 具有先进先出的结构
        Map<Integer, Integer> map = new LinkedHashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int[] operator : operators) {
            int opt = operator[0];
            int key = operator[1];
            switch (opt) {
                // 进行set方式的注入操作
                case 1:
                    // 取出当前要set的值
                    int value = operator[2];
                    // 判断map是否达到满
                    if (map.size() < k) {
                        map.put(key, value);
                    } else {
                        // 获取所有的key值
                        Iterator<Integer> iterator = map.keySet().iterator();
                        //移除先插入的元素，然后将后来的值插入到map中
                        map.remove(iterator.next());
                        map.put(key, value);
                    }
                    break;

                // 进行get操作
                case 2:
                    if (map.containsKey(key)) {
                        int val = map.get(key);
                        list.add(val);
                        // 目的就是将使用/查询过的值更新，将其重新插入，将其放在队列的尾部，将之前插入未操作过的值往后移
                        map.remove(key);
                        map.put(key, val);
                    } else {
                        list.add(-1);
                    }
                    break;
            }
        }
        int[] res = new int[list.size()];
        int i = 0;
        for (int val : list) {
            res[i++] = val;
        }
        return res;
    }

}
