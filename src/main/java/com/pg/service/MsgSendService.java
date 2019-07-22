package com.pg.service;

import com.github.pagehelper.PageInfo;
import com.pg.bean.PgEmailLog;
import com.pg.bean.PgMsgLog;
import com.pg.common.dto.in.MsgIn;
import com.pg.common.dto.in.MsgPageIn;

import java.util.List;

/**
 * @Auther: admin
 * @Date: 2019/6/21 15:09
 * @Description:
 */
public interface MsgSendService {
    int sendMsg(MsgIn msgIn);
    int sendEmail(MsgIn msgIn) throws Exception;
   PageInfo<PgEmailLog> getEmailPage(MsgPageIn msgPageIn);
    PageInfo<PgMsgLog> getMsgPage(MsgPageIn msgPageIn);

}
