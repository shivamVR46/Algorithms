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
public class May09 {

    public static void main(String[] args) {
        String s = "croakcroakcrcroacroakkoak";
//        int ans = minNumberOfFrogs(s);
//        System.out.println(ans);
        int x = findMinFibonacciNumbers(513314);
        System.out.println(x);

    }

    private static int minNumberOfFrogs(String s) {
        int count[] = new int[s.length()];
        int frog = 0, max = 0;

        for (Character c : s.toCharArray()) {
            switch (c) {

                case 'c':
                    count[0]++;

                    frog++;
                    max = Math.max(max, frog);
                    break;

                case 'r':
                    if (count[0] == 0) {
                        return -1;
                    }
                    count[0]--;
                    count[1]++;
                    break;

                case 'o':
                    if (count[1] == 0) {
                        return -1;
                    }
                    count[1]--;
                    count[2]++;
                    break;

                case 'a':
                    if (count[2] == 0) {
                        return -1;
                    }
                    count[2]--;
                    count[3]++;
                    break;

                case 'k':
                    if (count[3] == 0) {
                        return -1;
                    }
                    count[3]--;
                    count[4]++;
                    frog--;
                    break;

            }
        }

        return frog == 0 ? max : -1;

    }

    public static int[] numberOfFibonacci(int n) {
        int[] mem = new int[n + 1];
        
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                mem[i] = 0;
            } else if (i <= 2) {
                mem[i] = 1;
            } else {
                mem[i] = mem[i - 1] + mem[i - 2];
            }
        }

        return mem;
    }

    public static int findMinFibonacciNumbers(int k) {
        int[] arr = numberOfFibonacci(k);
        int count = 0;

        while (k != 0) {
            int closest = Integer.MIN_VALUE;
            for (int i = 0; i <arr.length; i++) {
                if (arr[i] <= k) {
                    closest = Math.max(closest, arr[i]);

                }
            }
            k = k - closest;
            count++;
        }

        return count;

    }

}
