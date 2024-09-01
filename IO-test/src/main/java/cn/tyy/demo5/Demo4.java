package cn.tyy.demo5;

import java.io.*;

public class Demo4 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        A abc = new A(123, "abc");
        String objectFile = "C:\\Users\\ritian\\Desktop\\study-files\\练习\\数据结构与算法\\untitled\\h1.txt";
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(objectFile));
        outputStream.writeObject(abc);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(objectFile));
        A a2 = (A) objectInputStream.readObject();
        System.out.println(a2);
        
    }

    private static class A implements Serializable{
        private int x;
        private String y;

        public A(int x, String y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "x = "+x+" "+"y = "+y;
        }
    }
}

