package com.pg.service;

import com.pg.bean.PgshRoomCustomer;
import com.pg.bean.RespBean;
import com.pg.mapper.PgshRoomCustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: admin
 * @Date: 2019/4/24 16:58
 * @Description:
 */

@Service
@Transactional
public class PgshRoomCustomerService {

    @Autowired
    private PgshRoomCustomerMapper pgshRoomCustomerMapper;



    public RespBean  insertSelective(PgshRoomCustomer pgshRoomCustomer){

       int i=0;
        //如果返回null 就是新guest  如果返回对象，就说明是老guest
        PgshRoomCustomer pgshRoomCustomer1 = pgshRoomCustomerMapper.selectByIdCard(pgshRoomCustomer.getIdCard());
        if(pgshRoomCustomer1 ==null ){

          i=  pgshRoomCustomerMapper.insertSelective(pgshRoomCustomer);
        }else {
            pgshRoomCustomer1.setTimes(pgshRoomCustomer1.getTimes()+1);
          i=  pgshRoomCustomerMapper.updateByPrimaryKeySelective(pgshRoomCustomer1);

        }


        if(i>=1){
            return  RespBean.ok("success");
        }else {
            return  RespBean.error("failed");
        }

    }

}
