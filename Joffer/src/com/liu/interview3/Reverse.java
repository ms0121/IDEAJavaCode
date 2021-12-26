package com.liu.interview3;

/**
 * @author lms
 * @date 2021-08-08 - 17:20
 */
public class Reverse {

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

        print(listNode1);
//        reverse1(listNode1);
        recursion(listNode1);
        print(listNode5);

    }

    public static void print(ListNode head){
        ListNode cur = head;
        while (cur != null){
            System.out.print(cur.val + " => ");
            cur = cur.next;
        }
        System.out.println();
    }

    // 方法一：
    // 迭代的方式:指针逆向指,即在头结点处设置一个新的节点(空节点)，last指向当前节点的下一个节点，然后让当前节点
    // 指向前面一个节点，然后更新前一个节点pre的值为当前节点cur，再让当前节点cur指向last节点，即逆向即可
    public static void reverse1(ListNode head){
        ListNode cur = head, pre = null, last;
        while (cur != null){
            last = cur.next;
            cur.next = pre;
            pre = cur;
            cur = last;
        }
    }


    // 方法2：
    // 递归的方式：也就是将一个大的问题转为每两个节点之间的问题：即两个节点进行互换指针的指向，
    // 但是必须先找到最后一个节点，用最后一个节点和导数第二个进行交换。
    public static ListNode recursion(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        recursion(head.next);
        head.next.next = head;
        head.next = null;
        return null;
    }
}
