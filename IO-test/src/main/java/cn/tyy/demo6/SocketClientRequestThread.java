package cn.tyy.demo6;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;

import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;
import org.apache.commons.logging.Log;


//TODO   一个SocketClientRequestThread线程模拟一个客户端请求。
public class SocketClientRequestThread implements Runnable{

    static {
        BasicConfigurator.configure();
    }

    private static final Log LOGGER = LogFactory.getLog(SocketClientRequestThread.class);
    private CountDownLatch countDownLatch;
    private Integer clientIndex;

    public SocketClientRequestThread(CountDownLatch countDownLatch, Integer clientIndex) {
        this.countDownLatch = countDownLatch;
        this.clientIndex = clientIndex;
    }

    /**
     * countDownLatch是java提供的同步计数器。
     * 当计数器数值减为0时，所有受其影响而等待的线程将会被激活。这样保证模拟并发请求的真实性
     */

    @Override
    public void run() {
        Socket socket = null;
        OutputStream clientRequest = null;
        InputStream clientResponse = null;

        try {
            socket = new Socket("localhost",8080);
            clientRequest = socket.getOutputStream();
            clientResponse = socket.getInputStream();

            //阻塞当前线程，直到 SocketClientDemo 完成所有线程的启动
            this.countDownLatch.await();

            //发送请求消息
            clientRequest.write(("这是第" + this.clientIndex + " 个客户端的请求。").getBytes());
            clientRequest.flush();

            SocketClientRequestThread.LOGGER.info("第" + this.clientIndex + "个客户端的请求发送完成，" +
                    "等待服务器返回信息");
            int maxLen = 1024;
            byte[] bytes = new byte[maxLen];
            int readLen;
            String message = "";
            while ((readLen = clientResponse.read(bytes,0,maxLen))!=-1){
                message += new String(bytes,0,readLen);
            }
            SocketClientRequestThread.LOGGER.info("接收到来自服务器的信息:" + message);

        }catch (Exception e){
            SocketClientRequestThread.LOGGER.error(e.getMessage(), e);
        }finally {
            try {
                if(clientRequest != null){
                    clientRequest.close();
                }
                if (clientResponse != null){
                    clientResponse.close();
                }
            }catch (IOException e){
                SocketClientRequestThread.LOGGER.error(e.getMessage(), e);
            }
        }

    }
}
