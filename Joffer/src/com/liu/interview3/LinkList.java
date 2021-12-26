package com.liu.interview3;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lms
 * @date 2021-08-10 - 22:04
 */
public class LinkList {
    public static void main(String[] args) {
       ListNode listNode1 = new ListNode(1);
       ListNode listNode2 = new ListNode(2);
       ListNode listNode3 = new ListNode(3);
       ListNode listNode4 = new ListNode(4);
       ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode4;

//        boolean circle = isCircle(listNode1);
        boolean hasCycle = hasCycle(listNode1);
        System.out.println("circle = " + hasCycle);
    }

    /**
     * 使用双指针的方式判断当前的链表是否有环
     * 条件，如果有环,快指针和满指针一定会在环内相遇，即相等的条件
     * @param head
     */
    public static boolean hasCycle(ListNode head){
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head, quick = head.next;
        while (quick != null){
            if (slow == quick){
                return true;
            }else {
                slow = slow.next;
                // 这里必须设置为quick比slow快一步，否则即使出现环都会交替错过
                quick = quick.next.next;
            }
        }
        return false;
    }



    /**
     * 方法1：
     * 判断当前链表是否存在环
     * 直接使用set集合进行判断：首先不断地将链表中的节点添加到set中，然后进行判断set中是否存在重复的节点
     * @param head
     * @return  true: 有环  false：无环
     */
    public static boolean isCircle(ListNode head){
        if (head == null){
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if (!set.add(head)){  // 如果set中已经存在要添加的节点，则会返回false
                return true;
            }
            head = head.next;
        }
        return false;
    }

}
