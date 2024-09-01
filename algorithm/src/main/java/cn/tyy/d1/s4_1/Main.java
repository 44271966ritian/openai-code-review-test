package cn.tyy.d1.s4_1;

import java.util.HashSet;
import java.util.Set;

//TODO 349. 两个数组的交集 HashSet

public class Main {
}


class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> set = new HashSet();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i])){
                res.add(nums2[i]);
            }
        }
//        int arr[] = new int[res.size()];
//        int len = 0;
//        for (Integer i : res) {
//            arr[len++] = i;
//        }

        //TODO stream流
        int[] arr = res.stream().mapToInt(x -> x).toArray();

        return arr;

    }
}