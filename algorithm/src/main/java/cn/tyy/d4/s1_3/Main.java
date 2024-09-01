package cn.tyy.d4.s1_3;

import java.util.HashMap;
import java.util.Map;

/*
* TODO 454. 四数相加 II
*  让chatGpt优化代码，加快运行速度
*   具体优化点
    减少变量声明和使用：
    原始代码中，sum 变量在哈希表填充和查找过程中没有必要。我们直接用 count 变量记录结果。
    1.增强 for 循环的使用：
    使用增强 for 循环 (for-each)，使代码更加简洁和易读，并可能略微提高性能。
    2.减少哈希表的大小初始化：
    初始哈希表大小为 40000 可能会浪费内存。在这种情况下，JVM 会动态调整哈希表的大小，因此不需要指定一个很大的初始容量。
* */
public class Main {
}


class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();

        // Populate the map with sums of elements from nums1 and nums2
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                int sum = num1 + num2;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int count = 0;

        // Calculate the sums of elements from nums3 and nums4 and check against the map
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                int sum = num3 + num4;
                count += map.getOrDefault(-sum, 0);
            }
        }

        return count;
    }
}

