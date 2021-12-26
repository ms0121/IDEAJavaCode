package com.nk.jz;

import java.util.*;

/**
 * @author lms
 * @date 2021-10-16 - 13:39
 */
public class JZ73 {
    public static void main(String[] args) {
//        String str = "nowcoder. a am I";
//        String sentence = ReverseSentence(str);
//        System.out.println(sentence);

//        int[] nums1 = {4,1,2}, nums2 = {1,3,4,2};
//        int[] res = nextGreaterElement(nums1, nums2);
//        for (int i = 0; i < res.length; i++) {
//            System.out.println(res[i] + ", ");
//        }


//        int[] nums = {4,3,8,5,6,10};
//        quickSort(0, nums.length - 1, nums);
//        for (int i = 0; i < nums.length; i++) {
//            System.out.print(nums[i] + ", ");
//        }
////        int target = 0;
//        List<List<Integer>> lists = fourSum(nums, target);
//        System.out.println(lists);
        int[] arr = {1, 1, 2};
        int duplicates = removeDuplicates(arr);
        System.out.println("duplicates = " + duplicates);
    }


    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int pre = 0, next = 1;
        for (int i = 0; next < nums.length && i < nums.length; i++) {
            if (nums[pre] != nums[next]) {
                pre = next;
                next = next + 1;
            } else {
                int cur = next;
                next = next + 1;
                while (next < nums.length && nums[next] != nums[pre]) {
                    nums[cur] = nums[next];
                    pre = cur;
                    next = next + 1;
                }
            }
        }
        return pre + 1;
    }


    public static void quickSort(int first, int last, int[] arr) {
        if (first > last) {
            return;
        }
        int pivot = arr[first];
        int low = first, high = last;
        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                high--;
            }
            arr[low] = arr[high];

            while (low < high && arr[low] <= pivot) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        // 左边进行快速排序
        quickSort(first, low - 1, arr);
        quickSort(low + 1, last, arr);
    }


    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length == 0 || nums.length < 4) {
            return new ArrayList();
        }
        Arrays.sort(nums);
        ArrayList<List<Integer>> res = new ArrayList<>();
        HashSet<List<Integer>> lists = new HashSet<>();


        for (int i = 0; i < nums.length; i++) {
            //if(i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                //  if(j > 0 && nums[j] == nums[j-1]) continue;
                int value = (nums[i] + nums[j]);
//                if (target == 0) {
//                    value = -value;
//                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum == (target - value)) {
                        lists.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        //去重
                        //while(left < right && nums[left] == nums[++left]);
                        //while(left < right && nums[right] == nums[--right]);
                        left++;
                        right--;
                    } else if (sum < value) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        Iterator<List<Integer>> iterator = lists.iterator();
        while (iterator.hasNext()) {
            res.add(iterator.next());
        }
        return res;
    }


    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        int x = 0;
        for (int i = 0; i < nums1.length; i++) {
            int cur = nums1[i];
            for (int j = 0; j < nums2.length; j++) {
                int k = nums2[j];
                if (k == cur) {
                    for (int h = j; h < nums2.length; h++) {
                        if (cur < nums2[h]) {
                            res[x] = nums2[h];
                            break;
                        }
                        res[x] = -1;
                    }
                    x = x + 1;
                }
            }
        }
        return res;
    }


    public int duplicate(int[] numbers) {
        // write code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (Integer i : numbers) {
            if (list.contains(i)) {
                return i;
            } else {
                list.add(i);
            }
        }
        return -1;
    }

    public static String ReverseSentence(String str) {
        Stack<String> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            while (str.charAt(i) == ' ') {
                stack.push(str.substring(j, i));
                j = i;
                i++;
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.toString();
    }


    public boolean Find(int target, int[][] array) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                list.add(array[i][j]);
            }
        }
        return list.contains(target);
    }
}
