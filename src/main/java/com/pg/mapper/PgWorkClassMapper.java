package com.pg.mapper;

import com.pg.bean.PgWorkClass;

import java.util.List;

public interface PgWorkClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PgWorkClass record);

    int insertSelective(PgWorkClass record);

    PgWorkClass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PgWorkClass record);

    int updateByPrimaryKey(PgWorkClass record);
    List<PgWorkClass>  getWorkTimeList();
}