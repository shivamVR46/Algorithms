/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Shivam Patel
 */
public class May05 {

    public static void main(String[] args) {
//        int[][] mat = {{1, 10, 10}, {1, 4, 5}, {2, 3, 6}};
//        int ans = kthSmallest(mat, 7);
//        System.out.println(ans);
        int[] nums = {0, 1, 0, 1};
        boolean ans1 = kLengthApart(nums, 1);
        System.out.println(ans1);
    }

    public static int kthSmallest(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        List<Integer> level = new ArrayList<>();
        level.add(0);

        for (int i = 0; i < m; i++) {
            List<Integer> nextLevel = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                for (int p = 0; p < Math.min(k, level.size()); p++) {
                    nextLevel.add(mat[i][j] + level.get(p));
                }
            }

            Collections.sort(nextLevel);
            level = nextLevel;
        }

        return level.get(k - 1);
    }

    public static boolean kLengthApart(int[] nums, int k) {
        int pI = -1;
        for (int i = 0; i < nums.length; i++) {
            if (pI != -1 && i - pI < k) {
                return false;
            }
            pI = i;
        }
        return true;
    }

}
