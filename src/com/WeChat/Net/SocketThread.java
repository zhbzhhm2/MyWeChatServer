package com.WeChat.Net;

import com.MyWeChat.Model.Pack;
import com.WeChat.Net.Service.MainService;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by zhang on 17-5-19.
 */
public class SocketThread implements Runnable{
    Socket socket;

    public SocketThread(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run() {
        InputStream inputStream=null;
        try {
            inputStream=socket.getInputStream();
            Pack pack=new Pack(inputStream);

            OutputStream stream=socket.getOutputStream();
            byte[] bb=new MainService(pack).getReq().toBytes();
            stream.write(bb);
            stream.flush();



        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    int getInt(byte []bytes,int off){
        if (bytes.length-off<4) {
            System.out.println("ERROR");
            return 0;
        }
        int ret=0;
        for (int i=0;i<4;i++){
            ret=(ret<<8)+bytes[off+i];
        }
        return ret;
    }
}
