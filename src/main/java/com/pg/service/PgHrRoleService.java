package com.pg.service;

import com.pg.common.utils.HrUtils;
import com.pg.mapper.HrRoleMapper;
import com.pg.mapper.PgHrEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: admin
 * @Date: 2019/5/14 11:18
 * @Description:
 */


@Service
@Transactional
public class PgHrRoleService {


    @Autowired
    HrRoleMapper hrRoleMapper;
    @Autowired
    PgHrEntityMapper hrEntityMapper;

    public int deleteRole(Long [] hrids){
        int a=0;
        for(int i=0;i<hrids.length;i++){
            //int i1 = hrids[i-1].intValue();
            a = hrRoleMapper.deleteByPrimaryKey(hrids[i].intValue());
        }
        //删除用户关联的宾馆
        for(int i=0;i<hrids.length;i++){
           hrEntityMapper.deleteByPrimaryKey(hrids[i].intValue());
        }

      return  a ;
    }
}
