package com.pg.constant;

/**
 * @Auther: admin
 * @Date: 2019/7/2 15:24
 * @Description:
 */
public class WebSocketConstant {


    //webSocket相关配置
    //链接地址
    public static String WEBSOCKETPATHPERFIX = "/ws-push";
    public static String WEBSOCKETPATH = "/wsendpoint";
    //消息代理路径
    public static String WEBSOCKETBROADCASTPATH = "/topic";
    //前端发送给服务端请求地址
    public static final String FORETOSERVERPATH = "/welcome";
    //服务端生产地址,客户端订阅此地址以接收服务端生产的消息
    public static final String PRODUCERPATH = "/topic/getResponse";
    //点对点消息推送地址前缀
    public static final String P2PPUSHBASEPATH = "/user";
    //点对点消息推送地址后缀,最后的地址为/user/用户识别码/msg
    public static final String P2PPUSHPATH = "/msg";
}
