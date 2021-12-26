package com.nk.day1;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author lms
 * @date 2021-09-14 - 17:30
 */
public class NC51 {
    public static void main(String[] args) {

    }

    // 使用优先队列的方式进行排序
    public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        // 优先队列
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (ListNode list : lists) {
            while (list != null){
                queue.offer(list.val);
            }
        }
        ListNode head = null, cur = null;
        while (!queue.isEmpty()){
            Integer data = queue.poll();
            ListNode node = new ListNode(data);
            if (head == null){
                head = node;
                cur = node;
            }else {
                cur.next = node;
                cur = node;
            }
        }
        return head;
    }

}
