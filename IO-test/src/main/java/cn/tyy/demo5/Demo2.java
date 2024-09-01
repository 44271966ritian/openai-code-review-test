package cn.tyy.demo5;

import java.io.*;
import java.nio.ByteBuffer;

public class Demo2 {
    public static void main(String[] args) throws IOException {
        //做一个文件内容的输入和输出

        //源文件路径
        File src = new File("C:\\Users\\ritian\\Desktop\\study-files\\练习\\数据结构与算法\\untitled\\h1.txt");
        //目标文件路径
        File dist = new File("C:\\Users\\ritian\\Desktop\\study-files\\练习\\数据结构与算法\\untitled\\h2.txt");

        //输入输出流
        FileInputStream in = new FileInputStream(src);
        FileOutputStream out = new FileOutputStream(dist);


        //buffer数组
        byte[] buffer = new byte[1024];//1024一次传输一个字节大小的内容
        int read = 0;
        while ((read = in.read(buffer,0,buffer.length) )!= -1){
            out.write(buffer,0,read);
        }
    }
}
