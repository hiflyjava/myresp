package com.pg.mapper;

import com.pg.bean.PgMsgLog;
import com.pg.common.dto.in.MsgPageIn;

import java.util.List;

public interface PgMsgLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PgMsgLog record);

    int insertSelective(PgMsgLog record);

    PgMsgLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PgMsgLog record);

    int updateByPrimaryKey(PgMsgLog record);
    List<PgMsgLog> getMsgPage(MsgPageIn msgPageIn);
}