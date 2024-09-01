package cn.tyy.d10.s2_1;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//347. 前 K 个高频元素
public class Main {
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int [] res = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        //统计频率
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //大顶堆
        PriorityQueue<int[]> bigQueue = new PriorityQueue<>((p1,p2)->{
            return p2[1] - p1[1];
        });
        //entrySet结构拿到key和value
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            bigQueue.add(new int []{entry.getKey(),entry.getValue()});
        }
        for (int i = 0; i < k; i++) {
            int[] poll = bigQueue.poll();
            res[i] = poll[0];
        }
        return res;
    }
}