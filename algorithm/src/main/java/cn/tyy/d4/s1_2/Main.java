package cn.tyy.d4.s1_2;

import java.util.HashMap;
import java.util.Map;

public class Main {
}

/*
* TODO 454. 四数相加 II
*  两两组合 n2的时间复杂度
*  加入了预设容量，但是这一共200的大小，也没有加快多少啊
*  上面纯属放屁，n2，忘记平方了
* */
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int sum = 0;
        Map <Integer,Integer> map = new HashMap<>(40000);
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int add = nums1[i]+nums2[j];
                map.put(add,map.getOrDefault(add,0)+1);
            }
        }

        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int add = nums3[i]+nums4[j];
                if (map.containsKey(-add)) {
                    sum += map.get(-add);
                }
            }
        }

        return sum;
    }
}

