package com.pg.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.pg.bean.Position;
import com.pg.bean.TDepartment;
import com.pg.common.utils.HrUtils;
import com.pg.mapper.DepartmentMapper;
import com.pg.mapper.PositionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.List;

/**
 * Created by pg on 2018/1/10.
 */
@Service
@Transactional
public class PositionService {
    @Autowired
    PositionMapper positionMapper;
   @Autowired
    DepartmentMapper departmentMapper;


    public  List<Position> getPositionListByEid(Position position){
        position.setUid(HrUtils.getCurrentHr().getId());
       return   positionMapper.getPositionListByEid(position);
    }


    /**
     * 新增岗位
     * @param position
     * @return
     */
    public Integer  addPosition(Position position){
        position.setUid(HrUtils.getCurrentHr().getId());
        position.setCreatedate(new Date());
        position.setEnabled(1);
        position.setCreateby(HrUtils.getCurrentHr().getUsername());
      return   positionMapper.insertSelective(position);

    }

    /**
     * 修改岗位
     * @param position
     * @return
     */
    public Integer  updatePosition(Position position){
               position.setUpdateby(HrUtils.getCurrentHr().getUsername());
               position.setUpdatedate(new Date());
        return   positionMapper.updateByPrimaryKeySelective(position);

    }


    /**
     * 根据部门id查询岗位
     * @param tDepartment
     * @return
     */
    public List<Position>  getChildrenDepsPosition(TDepartment tDepartment){
        System.out.println("部门id：=======>>"+tDepartment.getId());
         if(tDepartment.getId()==null || "".equals(tDepartment.getId())){
             tDepartment.setDepPath("");
         }else {
            tDepartment = departmentMapper.getDepPathById(tDepartment);
         }

        List<Position> allPos = positionMapper.getChildrenDepsPosition(tDepartment);
       // System.out.println("allpos==size=====>>>"+allPos.size());
        return  allPos;
    }

//  public boolean deletePosById(String pids) {
//        String[] split = pids.split(",");
//        return positionMapper.deletePosById(split) == split.length;
//    }



}
