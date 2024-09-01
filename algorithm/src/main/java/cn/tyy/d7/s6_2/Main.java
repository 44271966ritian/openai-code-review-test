package cn.tyy.d7.s6_2;

//TODO KMP算法 next数组

public class Main {
    public static void main(String[] args) {
        int i = new Solution().strStr("sadbutsad", "sad");
        System.out.println("i = " + i);


    }
}

    class Solution {
        public int strStr(String haystack, String needle) {
            if(needle.length()==0){
                //如果字串长度为0，直接返回0
                return 0;
            }
            //获得next数组，该数组跳转需要加1
            int[] next = getNext(needle.toCharArray());


            int j = -1;
            for (int i = 0; i < haystack.length(); i++) {
                while (j>=0&&haystack.charAt(i)!=needle.charAt(j+1)){
                    j = next[j];
                }
                if(haystack.charAt(i) == needle.charAt(j+1)){
                    j++;
                }
                if(j == needle.length()-1){
                    return (i-needle.length()+1);
                }
            }

            return -1;


        }
        public int [] getNext(char[] s){
            int [] next = new int[s.length];
            int j = -1;
            next[0] = j;
            for (int i = 1; i < s.length; i++) {
                while (s[j+1]!=s[i]&&j>=0){
                    j = next[j];
                }
                if(s[j+1] == s[i]){
                    j++;
                }
                next[i] = j;
            }

            return next;
        }
    }



