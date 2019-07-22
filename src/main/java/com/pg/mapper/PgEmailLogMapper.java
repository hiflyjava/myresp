package com.pg.mapper;

import com.pg.bean.PgEmailLog;
import com.pg.common.dto.in.MsgPageIn;

import java.util.List;

public interface PgEmailLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PgEmailLog record);

    int insertSelective(PgEmailLog record);

    PgEmailLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PgEmailLog record);

    int updateByPrimaryKey(PgEmailLog record);

    List<PgEmailLog> getEmailPage(MsgPageIn msgPageIn);
}