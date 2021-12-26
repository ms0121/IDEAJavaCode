package com.xxxx.crm3;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.management.QueryEval;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        int arr[] = {2,2,3,4,3};
        int maxLen = maxLen(arr);
        System.out.println("maxLen = " + maxLen);
    }

    public static int maxLen(int arr[]){
        Queue<Integer> queue = new LinkedList<>();
        int max = 0;
        for (int i : arr) {
            while (queue.contains(i)){
                queue.poll();
            }
            queue.add(i);
            max = Math.max(max, queue.size());
        }
        return max;
    }
}
