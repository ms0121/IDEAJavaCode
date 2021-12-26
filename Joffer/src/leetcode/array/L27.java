package leetcode.array;

/**
 * @author lms
 * @date 2021-10-19 - 18:19
 */
public class L27 {

    public static void main(String[] args) {

    }

    public int removeElement(int[] nums, int val) {
        int k = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == val){
                k = i;
            }else{
                if(k != -1){
                    nums[k] = nums[i];
                    k = -1;
                }
            }
        }
        return -1;
    }
}
