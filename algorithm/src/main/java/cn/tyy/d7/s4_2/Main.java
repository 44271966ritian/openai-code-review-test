package cn.tyy.d7.s4_2;

public class Main {
}

class Solution {
    public String reverseWords(String s) {
        //去除首尾和多余空格
        StringBuilder sb = removeSpace(s);
        //反转整个字符串
        reverseString(sb,0,sb.length()-1);
        //反转单个单词
        reverseEachWord(sb);

        return sb.toString();
    }

    public void reverseEachWord(StringBuilder sb){
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start<n){
            while (end<n&&sb.charAt(end)!=' '){
                end++;
            }
            reverseString(sb,start,end-1);
            start = end+1;
            end = start+1;
        }
    }
    public void reverseString(StringBuilder sb,int start,int end){
        while (start<=end){
            char temp = sb.charAt(start);
            sb.setCharAt(start,sb.charAt(end));
            sb.setCharAt(end,temp);
            start++;
            end--;
        }
    }
    public StringBuilder removeSpace(String s){
        //去除首尾空格
        int be = 0;
        int en = s.length()-1;
        while (s.charAt(be)==' '){
            be++;
        }
        while (s.charAt(en)==' '){
            en--;
        }

        StringBuilder sb = new StringBuilder();
        while (be<=en){
            char c = s.charAt(be);
            if(c!=' '||sb.charAt(sb.length()-1)!=' '){
                sb.append(c);//只留一个空格来分割，其余不要
            }
            be++;
        }

        return sb;
    }
}
