package cn.tyy.d4.s3_3;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

//TODO
//  15. 三数之和 双指针
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{-1,0,1,2,-1,-4};
        new Solution().threeSum(arr);
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int p1 = i+1;
            int p2 = nums.length-1;
            while (p1<p2){
                int sum = nums[p1]+nums[p2];
                if(sum<-nums[i]){
                    p1++;
                }else if(sum>-nums[i]){
                    p2--;
                }else {
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(nums[i]);
                    integers.add(nums[p1]);
                    integers.add(nums[p2]);
                    res.add(integers);
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
        return res;
    }
}