/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;

/**
 *
 * @author Shivam Patel
 */
public class Data {
    
    ArrayList<Integer> arr = new ArrayList();
    
    public void addInteger(int x){
        arr.add(x);
     
    }
    
    public int getInteger(){
        System.out.println(arr);
        return arr.get(0);
    }
    
}
