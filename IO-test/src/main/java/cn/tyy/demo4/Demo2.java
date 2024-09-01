package cn.tyy.demo4;

import java.io.*;

public class Demo2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\ritian\\Desktop\\study-files\\练习\\数据结构与算法\\untitled\\h1.txt");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        bufferedOutputStream.write(1);
        bufferedOutputStream.flush();
    }
}
