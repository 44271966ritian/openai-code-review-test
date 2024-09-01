package cn.tyy.d10.s1_1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
}
//15. 三数之和
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //排序方便指针移动
        Arrays.sort(nums);
        //外面一层循环
        for (int i = 0; i < nums.length - 2; i++) {
            if(nums[i] > 0){
                return res;
            }
            //存在一个问题，就是a+b+c，a重复怎么办？
            //-1 -1 2是满足条件的，在第一个-1是不能够跳过的，因为要用到，第二个可以跳过
            //我们判断是否能够跳过的思路是这个元素作为a是否使用了，前面的-1作为a在比后面的-1作为a的更大的区间内，找到了满足的所有情况
            //那么后面的-1就没必要再去找重复的三元组了
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int p1 = i+1;
            int p2 = nums.length-1;
            while (p1<p2){
                int sum = nums[p1]+nums[p2]+nums[i];
                if(sum == 0){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[p1]);
                    temp.add(nums[p2]);
                    res.add(temp);
                    //等于不代表就结束了，-4 2 2和-4 1 3都满足条件
                    while (p1 < p2 && nums[p1] == nums[p1+1]){
                        p1++;
                    }
                    while (p1 < p2 && nums[p2] == nums[p2-1]){
                        p2--;
                    }
                    p1++;
                    p2--;
                }else if(sum<0){
                    p1++;
                }else {
                    p2--;
                }
            }
        }
        return res;
    }
}
