package com.WeChat.Net.Service;


import com.MyWeChat.Model.Pack;

/**
 * Created by zhang on 17-5-19.
 */
public class LoginService implements Service {

    @Override
    public Pack doService(Pack pack) {
        if (pack.getId()!=101)
            return null;

        String name=pack.getValue("name");
        String passwd=pack.getValue("passWord");

        if ("111".equals(name)&&"111".equals(passwd)){

            Pack ret=new Pack((short)201,pack.getSeq(),0,0,null,null);
            return ret;
        }else{
            String info=new String("info:无效的用户名或密码;");
            byte[] bytes=info.getBytes();

            Pack p=new Pack((short)301,pack.getSeq(),bytes.length,0,bytes,null);
            return p;
        }

    }
}
