package com.pg.service;

import com.pg.bean.ChatResp;
import com.pg.constant.WebSocketConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: admin
 * @Date: 2019/7/2 15:25
 * @Description:
 */
@Service
public class WebSocketService    {

    @Autowired
    private SimpMessagingTemplate template;

    /**
     * 广播
     * 发给所有在线用户
     *
     * @param msg
     */
    public void sendMsg(ChatResp msg) {

        template.convertAndSend(WebSocketConstant.PRODUCERPATH, msg);
    }

    /**
     * 发送给指定用户
     *
     * @param users
     * @param msg
     */
    public void send2Users(List<String> users, ChatResp msg) {
        users.forEach(userName -> {
            template.convertAndSendToUser(userName, WebSocketConstant.P2PPUSHPATH, msg);
        });
    }

}
