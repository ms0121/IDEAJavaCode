package com.data.dp;

import java.util.Stack;

/**
 * @author lms
 * @date 2021-10-17 - 18:00
 */
public class L25 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);
//        ListNode node1 = new ListNode(3);
//        ListNode node2 = new ListNode(4);
//        ListNode node3 = new ListNode(5);

//        head.next = node;
//        node.next = node1;
//        node1.next = node2;
//        node2.next = node3;

//        ListNode listNode = reverseKGroup(head, 2);


//        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        int i = removeDuplicates(arr);
//        System.out.println("i = " + i);

    }

    // 0,0,1,1,1,2,2,3,3,4
    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int pre = 0, next = 1;
        for (int i = 0; i < nums.length; i++) {
            if (next > nums.length) {
                break;
            }
            if (next < nums.length && nums[pre] != nums[next]) {
                pre = next;
                next = next + 1;
            } else {
                int cur = next;
                next = next + 1;
                while (next < nums.length) {
                    if (nums[next] != nums[pre]) {
                        nums[cur] = nums[next];
                        next = next;
                        break;
                    } else {
                        next = next + 1;
                    }
                }
            }
        }
        return pre;
    }


    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode pHead = null, cur = null;

        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (head != null) {
            int i = 0;
            while (i < k && head != null) {
                stack1.push(head);
                head = head.next;
                i++;
            }
            // 逆序输出
            if (stack1.size() == k) {
                while (!stack1.isEmpty()) {
                    ListNode node = stack1.pop();
                    if (pHead == null) {
                        pHead = node;
                        cur = node;
                    } else {
                        cur.next = node;
                        cur = node;
                    }
                }
            } else {
                // 正序输出
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
                while (!stack2.isEmpty()) {
                    ListNode node = stack2.pop();
                    if (pHead == null) {
                        pHead = node;
                        cur = node;
                    } else {
                        cur.next = node;
                        cur = node;
                    }
                }
            }
        }
        cur.next = null;
        return pHead;
    }
}
