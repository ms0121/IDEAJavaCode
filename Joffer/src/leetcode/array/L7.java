package leetcode.array;

/**
 * @author lms
 * @date 2021-11-02 - 21:55
 */
public class L7 {

    public static void main(String[] args) {
        reverse(1534236469);
    }


    public static int reverse(int x) {
        if (x == 0){
            return x;
        }
        boolean flag = false;
        if(x < 0){
            x = -x;
            flag = true;
        }
        StringBuilder builder = new StringBuilder();
        while(x != 0){
            builder.append(x % 10);
            x = x / 10;
        }
        x = Integer.valueOf(builder.toString());
        if (flag){
            x = -x;
        }
        return x;
    }

}
