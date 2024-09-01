package cn.tyy.d4.s2_2;

/*
* TODO 383. 赎金信 这种简单的可以使用小容量的数组完成的题目，使用Map反而增加了开销
*   所以使用数组再写一次
* */
public class Main {
    public static void main(String[] args) {
        char c = 'a';
        System.out.println(c-'a');
    }
}

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        //TODO ransomNote 和 magazine 由小写英文字母组成
        //  意味着可以使用26位的数组来存储
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i)-'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if(--arr[ransomNote.charAt(i)-'a']<0){
                return false;
            }
        }
        return true;
    }
}
