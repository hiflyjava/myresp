package com.pg.mapper;

import com.pg.bean.PgHrEntity;
import com.pg.bean.PgshHotelEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PgHrEntityMapper {
    int deleteByPrimaryKey(Integer id);
    int deleteByEid(Long eid);
    int insert(PgHrEntity record);

    int insertSelective(PgHrEntity record);

    PgHrEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PgHrEntity record);

    int updateByPrimaryKey(PgHrEntity record);
    int addEntitysForHr(@Param("hrId") Integer hrId,@Param("eidsss")Integer[] eidsss);
    // List<PgshHotelEntity> getEntityByUid(Integer uid);
}