package cn.tyy.demo2;

import java.io.*;

/*
* TODO
*  IO 装饰者模式
*
*
* */
public class Demo2 {
    public static void main(String[] args) throws IOException {
        /*
        * TODO 装饰者(Decorator)和具体组件(ConcreteComponent)都继承自组件(Component)，
        *  具体组件的方法实现不需要依赖于其它对象，而装饰者组合了一个组件，这样它可以装饰其它装饰者或者具体组件。
        *  所谓装饰，就是把这个装饰者套在被装饰者之上，从而动态扩展被装饰者的功能。装饰者的方法有一部分是自己的，
        *  这属于它的功能，然后调用被装饰者的方法实现，从而也保留了被装饰者的功能。可以看到，
        *  具体组件应当是装饰层次的最低层，因为只有具体组件的方法实现不需要依赖于其它对象。
        * */

        String filePath = new String("C:\\Users\\ritian\\Desktop\\study-files\\练习\\数据结构与算法\\untitled\\h1.txt");
        FileInputStream fileInputStream = new FileInputStream(filePath);
        //TODO 实例化一个具有缓存功能的字节流对象时，只需要在 FileInputStream 对象上再套一层 BufferedInputStream 对象即可
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\ritian\\Desktop\\study-files\\练习\\数据结构与算法\\untitled\\h2.txt");


        InputStream inputStream = InputStream.nullInputStream();
        byte arr[] = new byte[1024];
        int read = 0;
        int len = 0;
//        while ((read = bufferedInputStream.read(arr,len,1)) != -1){
//            len++;
//        }
        int available = bufferedInputStream.available();
        bufferedInputStream.read(arr);
        outputStream.write(arr,0,available);

    }
}
