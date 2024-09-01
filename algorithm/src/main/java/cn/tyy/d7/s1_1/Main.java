package cn.tyy.d7.s1_1;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public void reverseString(char[] s) {
        int length = s.length;
        for (int i = 0; i < s.length/2; i++) {
            char temp = s[length-i-1];
            s[length-i-1] = s[i];
            s[i] = temp;
        }
    }
}

// a b c 1