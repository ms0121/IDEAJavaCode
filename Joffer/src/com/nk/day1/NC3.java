package com.nk.day1;

import java.util.HashMap;

/**
 * @author lms
 * @date 2021-09-12 - 19:58
 */
public class NC3 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        ListNode node5 = EntryNodeOfLoop(node);
        System.out.println("node5.val = " + node5.val);
    }

    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode cur = pHead;
        // 用于存放当前访问过的节点
        HashMap<ListNode, ListNode> hashMap = new HashMap<>();
        while (cur != null){
            // 如果map中不存在当前节点，则放入map中，如果存在，这说明当前的这个点就是入口节点
            if (!hashMap.containsKey(cur)){
                hashMap.put(cur, cur);
                cur = cur.next;
            }else {
                return cur;
            }
        }
        return null;
    }
}
