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
public class April28 {

    public static void main(String[] args) {
//        int[] nums = {809};
//        FirstUnique obj = new FirstUnique(nums);
//        System.out.println(obj.showFirstUnique());
//        obj.add(809);
//        
//        System.out.println(obj.showFirstUnique());
        Data d = new Data();
        int ans = d.getInteger();
        System.out.println(ans);
    }

}

class FirstUnique {

    HashMap<Integer, Integer> map;
    ArrayList<Integer> nums1;

    public FirstUnique(int[] nums) {
        map = new HashMap();
        nums1 = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            nums1.add(nums[i]);

            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
    }

    public int showFirstUnique() {
        HashMap<Integer,Integer> map1 = new HashMap();
        map1.putAll(map);
        for (Integer i : map1.keySet()) {
            if (map1.get(i) > 1) {
                map.remove(i);
            }

        }

        for (int i = 0; i < nums1.size(); i++) {
            int x = nums1.get(i);
            if (map.containsKey(x)) {
                if (map.get(x) == 1) {
                    return x;
                }
            }

        }

        return -1;
    }

    public void add(int value) {
        nums1.add(value);
        if (!map.containsKey((Integer) value)) {
            map.put((Integer) value, 1);
        } else {
            map.put(value, map.get((Integer) value) + 1);
        }
    }
}
