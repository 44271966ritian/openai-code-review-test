package cn.tyy.d8.s1_1;
//459. 重复的子字符串
/*
* 1.找出能够整除的长度
* 2.因为一定是从0号位开始的字串，所以从o和o+i开始比较，如果能匹配上，就行
* */
public class Main {
}
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i * 2 <= n; ++i) {
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; ++j) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }
}

