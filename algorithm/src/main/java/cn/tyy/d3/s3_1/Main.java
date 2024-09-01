package cn.tyy.d3.s3_1;

import java.util.ArrayList;
import java.util.List;

//TODO 202. 快乐数
public class Main {
}

class Solution {
    public boolean isHappy(int n) {
        //TODO 知道一个规律，一直循环如果不能得到1，那么就会循环回去
        List<Integer> list = new ArrayList<>();
        while (!list.contains(n)){
            list.add(n);
            n = sum(n);
            if(n==1){
                return true;
            }
        }
        return false;
    }

    public int sum(int n){
        int sum = 0;
        while (n>0){
            int tmp = n%10;
            sum += tmp*tmp;
            n /= 10;
        }
        return sum;
    }
}