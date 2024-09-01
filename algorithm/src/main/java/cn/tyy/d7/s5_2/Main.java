package cn.tyy.d7.s5_2;

//TODO 右旋字符串 无额外空间

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        String s = scanner.next();
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        int mid = length - i-1;
        int start = 0;
        int end = mid;
        reverse(charArray,start,end);
        start = mid+1;
        end = length-1;
        reverse(charArray,start,end);
        start = 0;
        end = length-1;
        reverse(charArray,start,end);
        for (int j = 0; j < charArray.length; j++) {
            System.out.print(charArray[j]);
        }



    }

    public static void reverse(char[] charArray,int start,int end){
        while (start<=end){
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
        }
    }
}
