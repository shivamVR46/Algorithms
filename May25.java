/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Shivam Patel
 */
public class May25 {

    public static void main(String[] args) {
        int[][] A = {{1, 2}, {1, 3}, {2, 3}};
        boolean ans = possibleBipartition(A);
        System.out.println(ans);
    }

    public static boolean possibleBipartition(int[][] dislikes) {

            ArrayList<Integer> arr1 = new ArrayList();
            ArrayList<Integer> arr2 = new ArrayList();
            ArrayList<int []> rem = new ArrayList();
            arr1.add(dislikes[0][0]);
            arr2.add(dislikes[0][1]);
            
            for(int i=0;i<dislikes.length;i++){
                int a = dislikes[i][0];
                int b = dislikes[i][1];
                
                if(arr1.contains(a) && arr1.contains(b)){
                    return false;
                }
                else if(arr2.contains(a) && arr2.contains(b)){
                    return false;
                }
                else if(arr1.contains(a) && arr2.contains(b)){
                    continue;
                }
                else if(arr1.contains(b) && arr2.contains(a)){
                    continue;
                }
                else if(arr1.contains(a)){
                    arr2.add(b);
                }
                else if(arr1.contains(b)){
                    arr2.add(a);
                }
                else if(arr2.contains(a)){
                    arr1.add(b);
                }
                else if(arr2.contains(b)){
                    arr1.add(a);
                }
                else{
                    rem.add(dislikes[i]);
                }
                
            }
        return true;
    }

}
