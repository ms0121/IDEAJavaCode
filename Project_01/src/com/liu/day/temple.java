package com.liu.day;

import java.util.ArrayList;

/**
 * @author lms
 * @date 2021-03-26 - 22:07
 * 快捷键
 */
public class temple {

    public void name() {

    }

    public static void main(String[] args) {
        ArrayList<Object> arrayList1 = new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer();


        int[] ints = new int[10];
        for (int i = 0; i < ints.length; i++) {
            int anInt = ints[i];
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(5);

        for (Integer integer : arrayList) {
            System.out.println(integer);
        }

        // list.fori  顺序输出
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(i);
        }

//        list.forr  逆序输出
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            // i.sout
            System.out.println(i);
        }

        boolean flag = true;
        if (flag) {
        }

        String st;



    }
}











