package com.pg.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pg.bean.Page;
import com.pg.bean.PgshRoomCustomer;
import com.pg.common.dto.in.CustomerPageIn;
import com.pg.common.utils.HrUtils;
import com.pg.mapper.PgshRoomCustomerMapper;
import com.pg.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Auther: admin
 * @Date: 2019/6/3 19:02
 * @Description:
 */

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    PgshRoomCustomerMapper customerMapper;


    @Override
    public PageInfo<PgshRoomCustomer> getAllCustomersByItems(CustomerPageIn pageIn) {

          pageIn.setHrid(HrUtils.getCurrentHr().getId());

        PageHelper.startPage(pageIn.getCurrentPage(), pageIn.getPageSize());

        List<PgshRoomCustomer> allCustomersByItems = customerMapper.getAllCustomersByItems(pageIn);

        return new PageInfo<>(allCustomersByItems);
    }

    @Override
    public int insertSelective(PgshRoomCustomer record) {
        record.setCreateDate(new Date());
         record.setTimes(1);//默认次数是一
        return customerMapper.insertSelective(record);
    }

    @Override
    public PgshRoomCustomer selectByPrimaryKey(PgshRoomCustomer record) {
        return customerMapper.selectByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(PgshRoomCustomer record) {
        return customerMapper.updateByPrimaryKeySelective(record);
    }


}
