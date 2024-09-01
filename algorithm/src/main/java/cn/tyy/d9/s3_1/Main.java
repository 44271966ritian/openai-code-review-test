package cn.tyy.d9.s3_1;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

//1047. 删除字符串中的所有相邻重复项
public class Main {
}

class Solution {
    public String removeDuplicates(String s) {
        if(s.length()==1){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            if(index>=0&&s.charAt(i)==sb.charAt(index)){
                sb.deleteCharAt(index);
                index--;
            }else {
                sb.append(s.charAt(i));
                index++;
            }
        }
        return sb.toString();
    }
}