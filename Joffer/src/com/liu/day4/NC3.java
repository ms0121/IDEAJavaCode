package com.liu.day4;

import java.util.HashMap;

/**
 * @author lms
 * @date 2021-08-18 - 23:03
 */
public class NC3 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = head;
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
//        head.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node3;

        ListNode listNode = EntryNodeOfLoop(head);
        System.out.println("listNode.val = " + listNode);

    }

    /**
     * 查找链表中是否存在环的状态
     *
     * @param pHead
     * @return
     */
    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode p = pHead;
        int i = 0, index = -1;
        while (p != null) {
            if (!map.containsValue(p)){
                map.put(i, p);
                i++;
                p = p.next;
            }else {
                return p;
            }
        }
        return null;
    }

}
