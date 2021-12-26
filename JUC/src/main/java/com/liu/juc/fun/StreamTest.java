package com.liu.juc.fun;

import java.util.Arrays;
import java.util.List;

/**
 * @author lms
 * @date 2021-09-05 - 16:44
 * 链式计算
 * 题目要求： 一分钟内完成此题，只能使用一行代码实现
 * 现在有5个用户！筛选：
 *  1. ID必须是偶数
 *  2. 年龄必须大于23岁
 *  3，用户名转为大写字母
 *  4，用户名字母倒着排序
 *  5.只输出一个用户信息
 */
public class StreamTest {
    public static void main(String[] args) {
        User user1 = new User(1, "a", 21);
        User user2 = new User(2, "b", 22);
        User user3 = new User(3, "c", 23);
        User user4 = new User(4, "d", 24);
        User user5 = new User(6, "e", 25);

        // 先将用户转为list集合，然后在使用stream进行处理
        List<User> users = Arrays.asList(user1, user2, user3, user4, user5);

        // 链式计算
        users.stream()
                .filter((user) -> {return user.getId() % 2 == 0;})
                // 形参是Predicate型，一个输入一个输出(true/false),因此返回值是一个一个id为偶数的user对象
                .filter((user -> {return user.getAge() > 23;}))
                // 返回值是id > 23 的user
                .map(user -> {return user.getName().toUpperCase();})
                // 形参Function,有输入和输出(两者类型相同)
                // 返回值是user.getName()，即用户名，并且转为大写,默认顺序是 D E
                .sorted((o1,o2) -> {return o2.compareTo(o1);})
                // 形参Comparator，可以重写比较函数, 然后排序后得到的结果是 E D
                .limit(1)  // 取出第一个
                .forEach(System.out::println);
                // 形参Consumer有输入值，没有返回值，只有输出值，
                // 将得到的结果 E 进行输出
    }
}
