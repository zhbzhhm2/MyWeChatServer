package com.WeChat.Net;


import com.MyWeChat.Model.Global;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhang on 17-5-19.
 */
public class Server {
    private static boolean runFlag=true;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(Global.PORT);
        ExecutorService executorService= Executors.newCachedThreadPool();

        while (runFlag){
           Socket socket= serverSocket.accept();
           SocketThread thread=new SocketThread(socket);
           executorService.execute(thread);
        }
    }
}
