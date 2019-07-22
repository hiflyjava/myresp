package com.pg.mapper;

import com.pg.bean.PgDeviceHub;

public interface PgDeviceHubMapper {
    int deleteByPrimaryKey(String did);

    int insert(PgDeviceHub record);

    int insertSelective(PgDeviceHub record);

    PgDeviceHub selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PgDeviceHub record);

    int updateByPrimaryKey(PgDeviceHub record);
}