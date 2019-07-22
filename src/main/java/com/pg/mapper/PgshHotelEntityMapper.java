package com.pg.mapper;


import com.pg.bean.PgshHotelEntity;
import com.pg.common.dto.in.HotelIn;

import java.util.List;

public interface PgshHotelEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PgshHotelEntity record);

    int insertSelective(PgshHotelEntity record);

    PgshHotelEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PgshHotelEntity record);

    int updateByPrimaryKey(PgshHotelEntity record);

    List<PgshHotelEntity> getAllHotelList();
    List<PgshHotelEntity> getOwnHotelList(Long id);
    PgshHotelEntity selectByEid(Long uid);
    //根据用户id 查询管辖宾馆
   List<PgshHotelEntity> selectHotelByUid(Long uid);
   List<PgshHotelEntity> searchHotelByItems(HotelIn hotelIn);

    PgshHotelEntity selectHotelByEid(HotelIn hotelIn);
}