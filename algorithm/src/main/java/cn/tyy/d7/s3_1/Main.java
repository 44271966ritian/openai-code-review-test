package cn.tyy.d7.s3_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                stringBuilder.append("number");
            }else {
                stringBuilder.append(s.charAt(i));
            }
        }
        System.out.print(stringBuilder.toString());
    }
}


