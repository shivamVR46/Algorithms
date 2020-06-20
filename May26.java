/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author Shivam Patel
 */
public class May26 {

    public static void main(String[] args) {
        int[] nums = new int[2];
        int[][] p = {{1,0}};
//        int ans = findMaxLength(nums);
//        System.out.println(ans);
        
        for(int i=0;i<p.length;i++){
            nums[p[i][0]]++;
        }
        
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
        
    }
    
    

    public static int findMaxLength(int[] nums) {
        int count0 = 0, count1 = 0, max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count0 += 1;
            } else {
                count1 += 1;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == 0) {
                    count0 += 1;
                } else {
                    count1 += 1;
                }

                max = Math.max(max, count0 + count1);
            }
            count0 = 0;
            count1 = 0;
                    
        }

        return max;
    }

}
