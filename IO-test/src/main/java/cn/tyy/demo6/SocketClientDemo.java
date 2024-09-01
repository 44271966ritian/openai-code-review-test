package cn.tyy.demo6;

import java.util.concurrent.CountDownLatch;

public class SocketClientDemo {
    public static void main(String[] args) throws InterruptedException {
        Integer clientNumber = 20;//创建20个客户端
        CountDownLatch countDownLatch = new CountDownLatch(clientNumber);

        //分别启动20个客户端
        for (int i = 0; i < clientNumber; i++,countDownLatch.countDown()) {
            SocketClientRequestThread client = new SocketClientRequestThread(countDownLatch, i);
            new Thread(client).start();
        }

        //这个wait不涉及到具体的实验逻辑，只是为了保证守护线程在启动所有线程后，进入等待状态
        synchronized (SocketClientDemo.class){
            SocketClientDemo.class.wait();
        }
    }
}
