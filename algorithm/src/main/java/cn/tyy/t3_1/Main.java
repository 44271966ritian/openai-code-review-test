package cn.tyy.t3_1;
//1137. 第 N 个泰波那契数
public class Main {
}

class Solution {
    public int tribonacci(int n) {
        if(n == 0){
            return 0;
        }
        if(n <= 2){
            return 1;
        }
        int a = 0,b = 0,c = 1,r = 1;//n = 4
        for (int i = 3; i <=     n; i++) {
            a = b;
            b = c;
            c = r;
            r = a + b + c;
        }

        return r;
    }
}