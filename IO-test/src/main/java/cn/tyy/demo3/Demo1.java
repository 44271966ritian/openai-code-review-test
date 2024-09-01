package cn.tyy.demo3;

import java.io.*;
import java.nio.ByteBuffer;

//TODO jdk11新增的空对象模式 nullInputStream
public class Demo1 {
    public static void main(String[] args) throws FileNotFoundException {

        InputStream inputStream1 = FileInputStream.nullInputStream();
    }
}
