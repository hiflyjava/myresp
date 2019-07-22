package com.pg.mapper;

import com.pg.bean.PgSmtlkDevice;

public interface PgSmtlkDeviceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PgSmtlkDevice record);

    int insertSelective(PgSmtlkDevice record);

    PgSmtlkDevice selectByPrimaryKey(String deviceId);

    int updateByPrimaryKeySelective(PgSmtlkDevice record);

    int updateByPrimaryKey(PgSmtlkDevice record);
}