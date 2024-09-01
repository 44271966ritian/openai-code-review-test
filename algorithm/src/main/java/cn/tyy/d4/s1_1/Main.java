package cn.tyy.d4.s1_1;

public class Main {
}

/*
* TODO 454. 四数相加 II 最简单的方法，暴力循环
*  在时间限制的情况下大概率超时
* */
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int sum = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                for (int k = 0; k < nums3.length; k++) {
                    for (int l = 0; l < nums4.length; l++) {
                        if(nums1[i]+nums2[j]+nums3[k]+nums4[l]==0){
                            sum++;
                        }
                    }
                }
            }
        }

        return sum;
    }
}
