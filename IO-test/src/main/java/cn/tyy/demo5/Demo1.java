package cn.tyy.demo5;

import java.io.File;

/*
* TODO 递归输出目录下的所有文件
* */
public class Demo1 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\ritian\\Desktop\\study-files\\暑假");
        listAllFiles(file);
    }
    public static void listAllFiles(File dir){
        if (dir == null||!dir.exists()){
            return;
        }
        if (dir.isFile()) {
            System.out.println(dir.getName());
            return;
        }
        File[] files = dir.listFiles();
        for (File file : files) {
            listAllFiles(file);
        }
    }
}

