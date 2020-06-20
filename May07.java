/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Shivam Patel
 */
public class May07 {

    public static void main(String[] args) {
        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        int x = maxScore(cardPoints, 3);
        String s = "101010";
       
        System.out.println(x);
    }

    public static int maxScore(int[] cardPoints, int k) {
        int res = 0, n = cardPoints.length;
        for (int i = n - k; i < n; i++) {
            res += cardPoints[i];
        }

        for (int i = 0, sum = res; i < k; i++) {
            sum -= cardPoints[n - k + i];
            sum += cardPoints[i];
            res = Math.max(res, sum);
        }
        return res;

    }

}
