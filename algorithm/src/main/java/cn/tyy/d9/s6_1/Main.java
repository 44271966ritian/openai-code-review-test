package cn.tyy.d9.s6_1;
//347. 前 K 个高频元素
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<int[]>pq = new PriorityQueue<>((p1,p2)->{
            return p2[1] - p1[1];
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new int[]{entry.getKey(),entry.getValue()});
        }
        int [] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll()[0];
        }

        return res;
    }
}
