package com.liu.array;

/**
 * @author lms
 * @date 2021-03-31 - 23:00
 */
public class LC495 {

    public static void main(String[] args) {
        int[] arr = {1, 4};
        int poisonedDuration = findPoisonedDuration(arr, 2);
        System.out.println("poisonedDuration = " + poisonedDuration);
    }

    //    输入: [1,4], 2
//    输出: 4
//    原因: 第 1 秒初，提莫开始对艾希进行攻击并使其立即中毒。中毒状态会维持 2 秒钟，直到第 2 秒末结束。
//    第 4 秒初，提莫再次攻击艾希，使得艾希获得另外 2 秒中毒时间。
//    所以最终输出 4 秒。
//    [1, 4] = 4
//    [1, 2] = 3

//    解题思路：假设中毒的持续时间是t，只要数组中每个元素的间隔都大于t，那么总时间就是数组的长度*t。因为下一个攻击的
//    时间还没到，中毒的持续时间就已经完成了，到下一个攻击的时间还可以继续攻击。比如中毒持续时间是2，攻击时间序列
//    是[1，3，6，8]，那么中毒的总时间就是2*4=8。
//    如果数组的间隔小于中毒的持续时间，下次攻击的时候时间上就会出现重叠，我们要做的就是减去这个重叠的时间。
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0 || duration == 0) {
            return 0;
        }
        // 第一个未知的持续时间一定是duration
        int count = duration;
        for (int i = 1; i < timeSeries.length; i++) {
            // 进行判断每两个元素之间的值之差是否大于duration，大于持续的时间就是duration，否则就返回
            // 两者之间的差
            count += Math.min(timeSeries[i] - timeSeries[i - 1], duration);
        }
        return count;
    }
}










