package com.pg.mapper;


import com.pg.bean.PgshRoomCustomer;
import com.pg.common.dto.in.CustomerPageIn;

import java.util.List;

public interface PgshRoomCustomerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PgshRoomCustomer record);

      int insertSelective(PgshRoomCustomer record);

    PgshRoomCustomer selectByPrimaryKey(PgshRoomCustomer record);

    int updateByPrimaryKeySelective(PgshRoomCustomer record);

    int updateByPrimaryKey(PgshRoomCustomer record);
    PgshRoomCustomer selectByIdCard(String idCard);

    PgshRoomCustomer selectCustomerByIdCard(String idCard);

    List<PgshRoomCustomer> getAllCustomersByItems(CustomerPageIn pageIn);

}