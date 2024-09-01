package cn.tyy.d4.s2_1;

import java.util.HashMap;
import java.util.Map;

public class Main {
}
/*
* TODO 383. 赎金信
*  哈希表
*   每个字符只能够使用一次，指的是单个字符而不是单个种类的字符
* */
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            map.put(magazine.charAt(i),map.getOrDefault(magazine.charAt(i),0)+1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (map.containsKey(ransomNote.charAt(i))) {
                map.put(ransomNote.charAt(i),map.get(ransomNote.charAt(i))-1);
                if(map.get(ransomNote.charAt(i))<0){
                    return false;
                }
            }else {
                return false;
            }
        }
        return true;
    }
}
