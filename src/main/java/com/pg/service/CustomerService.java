package com.pg.service;

import com.github.pagehelper.PageInfo;
import com.pg.bean.PgshRoomCustomer;
import com.pg.common.dto.in.CustomerPageIn;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: admin
 * @Date: 2019/6/3 19:02
 * @Description:
 */

@Service
@Transactional
public interface CustomerService {


    PageInfo<PgshRoomCustomer> getAllCustomersByItems(CustomerPageIn pageIn);

    int insertSelective(PgshRoomCustomer record);

    PgshRoomCustomer selectByPrimaryKey(PgshRoomCustomer record);

    int updateByPrimaryKeySelective(PgshRoomCustomer record);

}
