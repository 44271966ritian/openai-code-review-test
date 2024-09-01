package cn.tyy.d5.s2_1;

/*
* TODO 344. 反转字符串
*   一个for循环的事情
* */
public class Main {
}

class Solution {
    public void reverseString(char[] s) {
        int len = s.length/2;
        for (int i = 0; i < len; i++) {
            char temp = s[i];
            s[i] = s[s.length-i-1];
            s[s.length-i-1] = temp;
        }
    }
}