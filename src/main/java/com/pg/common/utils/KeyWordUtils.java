package com.pg.common.utils;

/**
 * @Auther: admin
 * @Date: 2019/4/23 10:23
 * @Description:
 */
public class KeyWordUtils {

    public static String getKeyWords(int b){
        StringBuilder rs =new StringBuilder();
        for(int a=1;a<=b;a++){
            int r=(int)(Math.random()*(10));//产生2个0-9的随机数
            rs.append(r);
        }

        return  rs.toString();
    }

}
