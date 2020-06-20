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
public class May04 {
    
    public static void main(String[] args) {
        System.out.println(findComplement(5));
    }
    
    public static int findComplement(int num) {
        
        int cp = num;
        int sum = 0;
        while (num > 0) {
            sum = (sum << 1) + 1;
            System.out.println(sum);
            num >>= 1;
        }
        
        return sum - cp;
        
    }
    
}
