package cn.tyy.d4.s3_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
}
/*
* TODO 15. 三数之和
*   暴力循环肯定是会超时的
*   我的解答是不重复的下标，我感觉我回答的题还要难一点
*
* */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        //TODO 要防止重复的三元组，就不能回头拿数字
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (map.containsKey(-nums[i]-nums[j])) {
                    ArrayList<Integer> arrayList = map.get(-nums[i] - nums[j]);
                    for (Integer index : arrayList) {
                        ArrayList<Integer> integers1 = new ArrayList<>();
                        integers1.add(i);
                        integers1.add(j);
                        integers1.add(index);
                        res.add(integers1);
                    }
                }else {
                    ArrayList<Integer> orDefault = map.getOrDefault(map.get(nums[j]), new ArrayList<Integer>());
                    orDefault.add(j);
                    map.put(nums[j],orDefault);
                }
            }
            //TODO 每一趟需要清空map，不然会重复
            map.clear();
        }

        return res;
    }
}
