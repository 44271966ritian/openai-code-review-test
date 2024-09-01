package cn.tyy.d9.s2_1;

import java.util.Stack;
//20. 有效的括号
public class Main {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        stack.push('1');
        System.out.println(stack.lastElement());
    }
}

class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if(!stack.empty()){
                if(stack.lastElement().equals('(')&&s.charAt(i)==')'){
                    stack.pop();
                }else if(stack.lastElement().equals('[')&&s.charAt(i)==']'){
                    stack.pop();
                }else if(stack.lastElement().equals('{')&&s.charAt(i)=='}'){
                    stack.pop();
                }else {
                    stack.push(s.charAt(i));
                }
            }else {
                stack.push(s.charAt(i));
            }

        }
        return stack.isEmpty();
    }
}