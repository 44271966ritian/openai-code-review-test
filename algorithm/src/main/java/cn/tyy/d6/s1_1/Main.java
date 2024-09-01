package cn.tyy.d6.s1_1;

public class Main {
}

class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        int remain = s.length();
        int begin =  0;
        while (remain>2*k){
            String substring = s.substring(begin, begin + k);
            stringBuilder.append(reverse(substring.toCharArray()));
            substring = s.substring(begin+k, begin + 2 * k);
            stringBuilder.append(substring);
            remain -= 2*k;
            begin += 2*k;
        }
        //出来之后判断剩余字符数
        if(remain<k){
            String substring = s.substring(begin);
            stringBuilder.append(reverse(substring.toCharArray()));
        }else {
            String substring = s.substring(begin, begin + k);
            stringBuilder.append(reverse(substring.toCharArray()));
            substring = s.substring(begin+k);
            stringBuilder.append(substring);
        }
        return stringBuilder.toString();
    }
    public String reverse(char s[]){
        for (int i = 0; i < s.length/2; i++) {
            char temp = s[i];
            s[i] = s[s.length-i-1];
            s[s.length-i-1] = temp;
        }

        return new String(s);
    }
}
