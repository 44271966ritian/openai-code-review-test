package cn.tyy.d7.s4_1;
//TODO 使用了函数 split
public class Main {
    public static void main(String[] args) {
        String s = new Solution().reverseWords("a good   example");
    }
}

class Solution {
    public String reverseWords(String s) {
        //识别单词
        //split 分隔符
        String[] s1 = s.split(" ");
        for (String string : s1) {
            string = string.trim();
            System.out.println(string);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s1.length-1; i >= 0; i--) {
            if(s1[i].length()>0){
                stringBuilder.append(s1[i]+" ");
            }

        }
        return stringBuilder.toString().trim();

    }
}
