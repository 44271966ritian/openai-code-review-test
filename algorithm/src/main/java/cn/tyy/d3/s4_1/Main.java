package cn.tyy.d3.s4_1;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//TODO 1. 两数之和 最简单就是暴力for循环 n2的时间复杂度
//  HashMap，
public class Main {
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int res[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int t = target-nums[i];
            if (map.containsKey(t)) {
                res[0] = i;
                res[1] = map.get(t);
                return res;
            }else {
                map.put(nums[i],i);
            }
        }

        return null;
    }
}
