package cn.tyy.d9.s5_1;

import java.util.ArrayDeque;
import java.util.Arrays;

//239. 滑动窗口最大值
public class Main {
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int [] result = new int[nums.length-k+1];
        ArrayDeque<Integer> res = new ArrayDeque<>();
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            //头节点不在范围内就移除
            if (!res.isEmpty()&&res.peek()<i-k+1){
                res.poll();
            }
            while (!res.isEmpty()&&nums[i]>=nums[res.peekLast()]){
                res.pollLast();
            }
            res.offer(i);
            if(i>=k-1){
                result[num++] = nums[res.peek()];
            }
        }
        return result;
    }
}