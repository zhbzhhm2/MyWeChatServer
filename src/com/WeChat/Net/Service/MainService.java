package com.WeChat.Net.Service;


import com.MyWeChat.Model.Pack;

/**
 * Created by zhang on 17-5-19.
 */
public class MainService {
    Pack pack=null;
    public MainService(Pack pack){
        this.pack=pack;
    }

    public Pack getReq(){
        Service service=null;
        switch (pack.getId()){
            case 101:
                service=new LoginService();
                break;
        }
       return  service.doService(pack);
    }
}
