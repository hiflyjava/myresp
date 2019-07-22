package com.pg.common.utils;

import com.pingenie.util.HttpClientUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: admin
 * @Date: 2019/6/20 12:14
 * @Description:
 */
public class MsgUtils {


    public  static  String  sendMsg(String telp){



        HttpClientUtil instance = HttpClientUtil.getInstance();

        Map<String,String> map =new HashMap<>();
        map.put("accesskey","");
        map.put("secret","");
        map.put("sign","");
        map.put("templateId","");
        map.put("mobile","");
        map.put("content","");
        map.put("mobile","");
        String post = instance.sendHttpPost("http://api.1cloudsp.com/api/v2/send", map);

    
        return  "";


    }


}
