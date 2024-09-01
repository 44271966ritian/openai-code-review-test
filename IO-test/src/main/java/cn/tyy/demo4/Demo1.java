package cn.tyy.demo4;

import java.io.*;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        OutputStream outputStream = new FileOutputStream("C:\\Users\\ritian\\Desktop\\study-files\\练习\\数据结构与算法\\untitled\\h1.txt");
        //TODO 传入int数据到输出流时，高24位被舍弃，保留低八位，就是字面意思
        //  原因是write方法用于将一个字节的数据写入输出流
        String s = new String("你好啊 world");
        outputStream.write(s.getBytes());
        byte[] bytes = s.getBytes();
        int length = bytes.length;
        System.out.println("length = " + length);


    }
}
