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
public class June09 {
    
    public static void main(String[] args) {
//        boolean ans = isSubsequence("axc","ahbgdc");
//        System.out.println(ans);
        Data d = new Data();
        d.addInteger(1);
    }
    
    public static boolean isSubsequence(String s, String t) {
        if(s.length()>t.length()){
            return false;
        }
        int J = 0;
        boolean flag = false;
        for(int i=0;i<s.length();i++){
            for(int j = J;j<t.length();j++){
                if(s.charAt(i)==t.charAt(j)){
                    J=j+1;
                    flag = true;
                    break;
                }
                if(j == t.length()-1 &&flag==false){
                    return false;
                }
                if(J>t.length() ){
                    return false;
                }
            }
            if(J>t.length()-1 && flag== false){
                return false;
            }
            flag = false;
        }
        return true;
    }
        
}
