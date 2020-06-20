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
public class May01 extends VersionControl {

    static May01 my = new May01();
    public static  int global ;
    public static void main(String[] args) {
        System.out.println(firstBadVersion(2126753390));
    }
    
          
    public static int firstBadVersion(int n) {
       int left = 1,right = n,ans = -1;
        
        while(left<=right){
            int mid = left +(right-left)/2;
            if(my.isBadVersion(mid)){
                ans = mid;
                right = mid -1;
            }
            else{
                left = mid + 1;
            }
        }
        return ans;

    }
//1702766719 1063376695
}
