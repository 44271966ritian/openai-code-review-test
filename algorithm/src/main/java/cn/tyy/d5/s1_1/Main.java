package cn.tyy.d5.s1_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
* TODO 18. 四数之和 双指针
* */
public class Main {
    public static void main(String[] args) {
//        int[] nums = new int[]{-2,-1,-1,1,1,2,2};
//        new Solution().fourSum(nums,0);
        long a1 = 1000000000;
        long a2 = 1000000000;
        long a3 = 1000000000;
        long a4 = 1000000000;
        long sum = a1+a2+a3+a4;
        int maxValue = Integer.MAX_VALUE;
        int minValue = Integer.MIN_VALUE;
        System.out.println("minValue = " + minValue);
        System.out.println("maxValue = " + maxValue);
        System.out.println("sum = " + sum);
    }
}
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        //TODO 思路和三数之和差不多、
        //  确定a 然后 target-a = b+c+d 然后 target1 = target-a -b = c+d

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            for (int j = i+1; j < nums.length; j++) {
                if(j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                int p1 = j+1;
                int p2 = nums.length-1;
                long target2 = (long)target-(long)nums[i]-(long)nums[j];
                while (p1<p2){
                    long sum = (long)nums[p1]+(long)nums[p2];
                    if(sum<target2){
                        p1++;
                    }else if(sum>target2){
                        p2--;
                    }else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[p1]);
                        list.add(nums[p2]);

                        res.add(list);

                        while (p1<nums.length-1&&nums[p1]==nums[p1+1]){
                            p1++;
                        }
                        while (p2>0&&nums[p2]==nums[p2-1]){
                            p2--;
                        }
                        p1++;
                        p2--;
                    }
                }
            }
        }
        return res;
    }
}