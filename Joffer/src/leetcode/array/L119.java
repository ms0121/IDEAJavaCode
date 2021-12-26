package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lms
 * @date 2021-10-24 - 9:49
 */
public class L119 {
    public static void main(String[] args) {
        List<Integer> list = getRow(0);
    }

    public static List<Integer> getRow(int rowIndex) {
        int[][] yh = new int[rowIndex+1][rowIndex+1];
        for(int i=0;i<=rowIndex;i++){
            yh[i][0] = 1;
            yh[i][i] = 1;
        }
        for(int i=1;i<=rowIndex;i++){
            for(int j=1;j<=i;j++){
                yh[i][j] = yh[i-1][j] + yh[i-1][j-1];
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            list.add(yh[rowIndex][i]);
        }
        System.out.println("list = " + list);
        return list;
    }


}
