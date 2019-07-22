package com.pg.common.utils;

/**
 * @Auther: admin
 * @Date: 2019/4/16 14:28
 * @Description:
 */
public class OrderNumUtils {

    public  static  String  getOrderNums(){
        int r1=(int)(Math.random()*(10));//产生2个0-9的随机数
        int r2=(int)(Math.random()*(10));
        long now = System.currentTimeMillis();//一个13位的时间戳
        String paymentID =String.valueOf(r1)+String.valueOf(r2)+String.valueOf(now);// 订单ID
          return  paymentID;
    }

}
