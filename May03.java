/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Shivam Patel
 */
public class May03 {

    public static void main(String[] args) {
        int x = firstUniqChar("leetcode");
        System.out.println(x);
//        System.out.println(canConstruct("fffbfg", "effjfggbffjdgbjjhhdegh"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {

        ArrayList<Character> c = new ArrayList();
        int[] cc = new int[26];
        int[] mm = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';
            cc[index]++;
        }

        for (int j = 0; j < magazine.length(); j++) {
            int index = magazine.charAt(j) - 'a';
            mm[index]++;
        }
        for (int i = 0; i < cc.length; i++) {
            if (cc[i] > mm[i]) {
                return false;
            }
        }
        return true;
    }

    public static int firstUniqChar(String s) {
        int ans = Integer.MAX_VALUE;
        
        for (char c = 'a'; c <= 'z'; c++) {
            int i = s.indexOf(c);

            if (i != -1 && i == s.lastIndexOf(c)) {
                ans = Math.min(ans, i);
            }
        }
        if(ans ==Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }

}
