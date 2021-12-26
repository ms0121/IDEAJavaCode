package com.liu.interview3;

/**
 * @author lms
 * @date 2021-08-12 - 23:59
 * 找零钱，[5,10,20]，意思就是如果当前是5块没问题，下一个是10块，那么可以使用5块进行
 * 找零，如果是20，可以是由10+5块，或者有至少3个5块才能满足找零的条件
 */
public class FindMoney {
    public static void main(String[] args) {
        int[] arr = {5,5,10};
        boolean change = change(arr);
        System.out.println("change = " + change);
    }

    // 找零
    public static boolean change(int[] arr){
        int five = 0, ten = 0;
        for (int bill : arr) {
            if (bill == 5){
                five++;
            }else if (bill == 10){
                if (five > 0){
                    five--;
                }else {
                    return false;
                }
            }else {
                if (five > 0 && ten > 0){
                    five--;
                    ten--;
                }else if (five >= 3){
                    five -= 3;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
