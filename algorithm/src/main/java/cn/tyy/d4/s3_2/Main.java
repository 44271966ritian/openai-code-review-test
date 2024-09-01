package cn.tyy.d4.s3_2;

import java.util.*;

/*
* TODO 15. 三数之和
*   我这应该算是哈希解法
*   耗时很狗屎，但是过了
* */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,-2,-2,0,1,2,2,2,3};
        List<List<Integer>> lists = new Solution().threeSum(nums);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (set.contains(-nums[i]-nums[j])){
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(nums[i]);
                    integers.add(-nums[i]-nums[j]);
                    integers.add(nums[j]);
                    res.add(integers);
                    while (j<nums.length-1&&nums[j]==nums[j+1]){
                        j++;
                    }
                }else {
                    set.add(nums[j]);
                }
            }
            set.clear();
        }

        return res;
    }
}
