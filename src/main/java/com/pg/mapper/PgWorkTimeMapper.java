package com.pg.mapper;

import com.pg.bean.PgWorkTime;

import java.util.List;

public interface PgWorkTimeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PgWorkTime record);

    int insertSelective(PgWorkTime record);

    PgWorkTime selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PgWorkTime record);

    int updateByPrimaryKey(PgWorkTime record);

    List<PgWorkTime>  getWorkTimeList();

}