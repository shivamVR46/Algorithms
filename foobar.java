/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.HashMap;

/**
 *
 * @author Shivam Patel
 */
public class foobar {
    public static void main(String[] args) {
        System.out.println(solution("abccbaabccba"));
    }
    public static int solution(String s){
        char first = s.charAt(0);
        String s1 ="";
        int seq =1;
        for(int i=1;i<s.length()-1;i++){
            if(!s.contains(s.substring(0,i))){
                s1 = s.substring(0, i);
                break;
            }
        }
        System.out.println(s1);
        return seq;
    }
    
}
