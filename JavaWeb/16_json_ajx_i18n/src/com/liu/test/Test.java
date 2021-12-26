package com.liu.test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.liu.pojo.Person;
import com.liu.pojo.PersonListType;
import com.liu.pojo.PersonMapType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lms
 * @date 2021-04-09 - 22:18
 */
public class Test {
    public static void main(String[] args) {
//        Person person = new Person(10, "zhangsan", 20);
//        Gson gson = new Gson();
//        beanAndJson(person, gson);
//        listAndJson(gson);

        mapAndJson();

    }

    // list和json的转换
    public static void listAndJson(Gson gson) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "liszu", 20));
        personList.add(new Person(2, "zhansgan", 30));

        // list转为json
        String s = gson.toJson(personList);
        System.out.println("s = " + s);

        // json转为list

    }


    // javaBean和Json的互相转换,还需要一个继承的类
    public static void beanAndJson(Person person, Gson gson) {
        // 将java对象转为json字符串
        String s = gson.toJson(person);
        System.out.println("s = " + s);

        // fromJson 把 json 字符串转换回 Java 对象
        // 第一个参数是 json 字符串
        // 第二个参数是转换回去的 Java 对象类型
        List<Person> list = gson.fromJson(s, new PersonListType().getType());
        System.out.println("person1 = " + list.get(0));
    }


    public static void mapAndJson(){
        Person person = new Person(12, "zhansgan", 2);
        Person person1 = new Person(13, "lisui", 89);

        Map<Integer, Person> map = new HashMap<>();
        map.put(1, person);
        map.put(2,person1);

        Gson gson = new Gson();
        String s = gson.toJson(map);
        System.out.println("s = " + s);

//        Map<Integer, Person> map1 = gson.fromJson(s, new PersonMapType().getType());

        // 直接使用匿名内部类
        Map<Integer, Person> map1 = gson.fromJson(s, new TypeToken<Map<Integer, Person>>(){}.getType());
        Person person2 = map1.get(1);
        System.out.println(person2);

    }


}











