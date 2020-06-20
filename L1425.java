/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * @author Shivam Patel
 */
public class L1425 {

    public static void main(String[] args) {
        int[] nums = {4681, 6466, 9411, -5130, 6047};
        int ans = constrainedSubsetSum(nums, 3);
        System.out.println(ans);
    }

    public static int constrainedSubsetSum(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Deque<Integer> deque = new LinkedList<>();
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int max = Math.max(0, deque.isEmpty() ? 0 : dp[deque.peekFirst()]);
            dp[i] = arr[i] + max;
            ans = Math.max(ans, dp[i]);
            while (!deque.isEmpty() && dp[i] >= dp[deque.peekLast()]) { // If dp[i] >= deque.peekLast() -> Can discard the tail since it's useless
                deque.pollLast();
            }
            deque.addLast(i);
            if (i - deque.peekFirst() + 1 > k) { // remove the last element of range k
                deque.removeFirst();
            }
        }
        return ans;

    }

}
