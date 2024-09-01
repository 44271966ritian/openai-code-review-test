package cn.tyy.demo6;

public class Demo1 {
    public static void main(String[] args) {
        //TODO BIO 阻塞式IO的问题关键不在于是否使用了多线程处理请求，而在于accept、read的操作点都是被阻塞的
        //  我们模拟了20个客户端(用20根线程模拟)，
        //  利用JAVA的同步计数器CountDownLatch，
        //  保证这20个客户都初始化完成后然后同时向服务器发送请求，
        //  然后我们来观察一下Server这边接受信息的情况。



    }
}
