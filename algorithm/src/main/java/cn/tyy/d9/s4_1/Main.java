package cn.tyy.d9.s4_1;

import java.util.Scanner;
import java.util.Stack;
//150. 逆波兰表达式求值
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String s = scanner.next();
//        switch (s){
//            case "+":
//                System.out.println("+");
//                break;
//            case "-":
//                System.out.println("-");
//                break;
//            case "*":
//                System.out.println("*");
//                break;
//            case "/":
//                System.out.println("/");
//                break;
//        }

        String [] arr = new String[]{"4","13","5","/","+"};
        int i = new Solution().evalRPN(arr);
        System.out.println("i = " + i);
    }
}

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("+")||tokens[i].equals("-")||tokens[i].equals("*")||tokens[i].equals("/")){
                String s1 = stack.pop();
                String s2 = stack.pop();
                long n2 = Long.parseLong(s1);
                long n1 = Long.parseLong(s2);
                long num = 0l;
                if(tokens[i].equals("+")){
                    num = n1+n2;
                }else if(tokens[i].equals("-")){
                    num = n1-n2;
                }else if(tokens[i].equals("*")){
                    num = n1*n2;
                }else if(tokens[i].equals("/")){
                    num = n1/n2;
                }

                stack.push(String.valueOf(num));
            }else {
                stack.push(tokens[i]);
            }
        }
        String pop = stack.pop();

        return Integer.parseInt(pop);
    }
}
