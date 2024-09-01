package cn.tyy.d1.s3_1;

import java.util.HashMap;
import java.util.Map;

//TODO 242. 有效的字母异位词 两个HashMap

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isAnagram("anagram", "nagaram"));
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {

        Map<Character,Integer> m1 = new HashMap<>();
        Map<Character,Integer> m2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            m1.put(s.charAt(i),m1.getOrDefault(s.charAt(i),0)+1);
        }
        for (int i = 0; i < t.length(); i++) {
            m2.put(t.charAt(i),m2.getOrDefault(t.charAt(i),0)+1);
        }

        return m1.equals(m2);
    }
}
