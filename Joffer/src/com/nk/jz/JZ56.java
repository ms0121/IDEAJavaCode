package com.nk.jz;

import java.util.*;

/**
 * @author lms
 * @date 2021-10-13 - 22:10
 */
public class JZ56 {
    public static void main(String[] args) {
//        ListNode node = new ListNode(2);
//        ListNode node0 = new ListNode(4);
//        ListNode node1 = new ListNode(3);
//
//        ListNode node2 = new ListNode(5);
//        ListNode node3 = new ListNode(6);
//        ListNode node4 = new ListNode(4);
//
//        node.next = node0;
//        node0.next = node1;
//
//        node2.next = node3;
//        node3.next = node4;
//
//        addTwoNumbers(node, node2);
        int arr[] = {1, 2, 3};
        int arr2[] = {2, 1, 3};
        TreeNode root = buildTree(arr, arr2);
        postOrder(root);

//        // deleteDuplication(node);
//        int[] arr = {1,2,3,1};
//        boolean duplicate = containsDuplicate(arr);
//        System.out.println(duplicate);
//
//        HashMap<Integer, Integer> map = new HashMap<>();
//        Queue<Integer> list = new LinkedList<>();
//        list.poll();
    }

    public static void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + ", ");
        }
    }


    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        // write code here
        TreeNode root = builder(preorder, inorder, 0, 0, preorder.length);
        return root;

    }

    public static TreeNode builder(int[] preorder, int[] inorder, int preS, int inS, int len) {
        if (len == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preS]);
        int k = 0;
        while (preorder[preS] != inorder[inS + k]) {
            k++;
        }
        root.left = builder(preorder, inorder, preS + 1, preS, k);
        root.right = builder(preorder, inorder, preS + k + 1, inS + k + 1, len - k - 1);
        return root;
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (Integer i : nums1) {
            list.add(i);
        }
        for (Integer i : nums2) {
            list.add(i);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        double sum = 0;
        int index = list.size() / 2;
        if (list.size() % 2 == 0) {
            sum = list.get(index - 1) + list.get(index);
        } else {
            sum = list.get(index);
        }
        return sum;
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = l1, cur = null;
        int carry = 0, x = 0, y = 0;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                x = l1.val;
            }
            if (l2 != null) {
                y = l2.val;
            }
            int sum = x + y + carry;
            if (l1 == null) {
                ListNode node = new ListNode(sum % 10);
                l1 = node;
                cur.next = l1;
            }
            l1.val = sum % 10;
            carry = sum / 10;
            if (l2 != null) {
                l2 = l2.next;
            }
            if (l1 != null) {
                cur = l1;
                l1 = l1.next;
            }
            x = 0;
            y = 0;
        }
        return head;
    }


    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else {
                return new int[]{map.get(target - nums[i]), i};
            }
        }
        return new int[]{};
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        if (nums.length != set.size()) {
            return false;
        }
        return true;
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            ArrayList subList = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                subList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(subList);
        }
        return result;
    }

    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        while (pHead != null) {
            if (!map.containsKey(pHead.val)) {
                map.put(pHead.val, 1);
            } else {
                map.put(pHead.val, map.get(pHead.val) + 1);
            }
            pHead = pHead.next;
        }
        pHead = null;
        if (map.size() == 1) {
            return pHead;
        }
        ListNode cur = null;
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() == 1) {
                int key = entry.getKey();
                ListNode node = new ListNode(key);
                if (pHead == null) {
                    pHead = node;
                    cur = node;
                } else {
                    cur.next = node;
                    cur = node;
                }
            }
        }
        cur.next = null;
        return pHead;
    }


}
