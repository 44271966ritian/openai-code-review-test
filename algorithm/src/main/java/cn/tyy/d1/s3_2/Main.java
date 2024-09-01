package cn.tyy.d1.s3_2;

//TODO 242. 有效的字母异位词 数组解法
public class Main {
    public static void main(String[] args) {
        new Solution().isAnagram(" ","");
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {

        int [] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)-'a'] ++;
        }
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i)-'a'] --;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0){
                return false;
            }
        }

        return true;
    }
}