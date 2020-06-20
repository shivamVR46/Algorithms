/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Shivam Patel
 */
public class May06 {

    static List<List<Integer>> nums = new ArrayList();
    static List<Integer> ar;

    private static void insert(int[] arr) {
        ar = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            ar.add(arr[i]);
        }

    }

    public static void main(String[] args) {
        int[] n1 = {1, 2};
        insert(n1);
        nums.add(ar);
        int[] n2 = {7};
        insert(n2);
        nums.add(ar);
//        int[] n3 = {7, 8, 9};
//        insert(n3);
//        nums.add(ar);
        int x[] = findDiagonalOrder(nums);
        for(int i=0;i<x.length;i++){
            System.out.print(" " + x[i]);
        }
    }

    public static int[] findDiagonalOrder(List<List<Integer>> nums) {
        
        List<List<Integer>> list = new ArrayList();
        for(int i=nums.size()-1;i>=0;i--){
            for(int j=0;j<nums.get(i).size();j++){
                while(list.size()<=(i+nums.get(i).size())){
                    list.add(new ArrayList());
                }
                list.get(i+j).add(nums.get(i).get(j));
            }
        }
        
        ArrayList<Integer> res = new ArrayList();
        for(int i=0;i<list.size();i++){
            for(Integer v : list.get(i)){
                res.add(v);
            }
        }
        
        return res.stream().mapToInt(Integer::intValue).toArray();

    }

}
