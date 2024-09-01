package cn.tyy.d7.s5_1;

import java.util.Scanner;

//TODO 右旋字符串 额外空间

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        String s = scanner.next();
        char[] charArray = s.toCharArray();
        for (int j = 0; j < charArray.length; j++) {
            for (int k = 0; k < i; k++) {
                charArray[(j+i)%charArray.length] = s.charAt(j);
            }
        }
        for (int j = 0; j < charArray.length; j++) {
            System.out.print(charArray[j]);
        }

    }
}


