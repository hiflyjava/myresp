package com.pg.mapper;

import com.pg.bean.PgStaffAttence;

public interface PgStaffAttenceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PgStaffAttence record);

    int insertSelective(PgStaffAttence record);

    PgStaffAttence selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PgStaffAttence record);

    int updateByPrimaryKey(PgStaffAttence record);
}