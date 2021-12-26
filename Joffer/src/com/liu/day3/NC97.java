package com.liu.day3;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lms
 * @date 2021-09-06 - 21:53
 */
public class NC97 {
    public static void main(String[] args) {
        String[] strings = {"a", "b", "c", "b"};
        topKstrings(strings, 2);

    }

    public static String[][] topKstrings (String[] strings, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            if (!map.containsKey(strings[i])){
                map.put(strings[i], 1);
            }else {
                map.put(strings[i], map.get(strings[i]) + 1);
            }
        }
        String[][] res = new String[k][k];
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        // 先是按出现次数降序比较，相同则再按照字符ASCII码降序比较
        Collections.sort(list,
                (o1, o2) ->
                        (o1.getValue().compareTo(o2.getValue()) ==
                                0 ? o1.getKey().compareTo(o2.getKey()) :
                                o2.getValue().compareTo(o1.getValue()))
        );
        // 返回topK
        for (int i = 0; i < k; i++) {
            res[i][0] = list.get(i).getKey();
            res[i][1] = String.valueOf(list.get(i).getValue());
        }
        return res;
    }
}
