package com.pg.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pg.bean.Page;
import com.pg.bean.PgHrEntity;
import com.pg.bean.PgshHotelEntity;
import com.pg.bean.TDepartment;
import com.pg.common.dto.in.HotelIn;
import com.pg.common.utils.HrUtils;
import com.pg.mapper.DepartmentMapper;
import com.pg.mapper.PgHrEntityMapper;
import com.pg.mapper.PgshHotelEntityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by pg on 2017/12/28.
 */
@Service
@Transactional
public class PgshHotelEntityService {

     private  static  final Logger logger= LoggerFactory.getLogger(PgshHotelEntity.class);

    @Autowired
    PgshHotelEntityMapper pgshHotelEntityMapper;
    @Autowired
    PgHrEntityMapper pgHrEntityMapper;
    @Autowired
    DepartmentMapper departmentMapper;

    /**
     * 新增公司
     *
      */
   public  int  addHotel(PgshHotelEntity pgshHotelEntity){
       //pgshHotelEntity.setUid(HrUtils.getCurrentHr().getId());
       pgshHotelEntity.setCreatedDate(new Date());
       pgshHotelEntity.setCreatedBy(HrUtils.getCurrentHr().getUsername());
       int i = pgshHotelEntityMapper.insertSelective(pgshHotelEntity);
       PgHrEntity pgHrEntity =new PgHrEntity();
       pgHrEntity.setHrId(Integer.parseInt(HrUtils.getCurrentHr().getId()+""));
       pgHrEntity.setHotelEntityId(Integer.parseInt(pgshHotelEntity.getId()+""));
       pgHrEntityMapper.insertSelective(pgHrEntity);
       if(i>=1){
           TDepartment tDepartment =new TDepartment();
           tDepartment.setEntityId(Integer.parseInt(pgshHotelEntity.getId()+""));
           tDepartment.setParentId(0l);
           tDepartment.setName(pgshHotelEntity.getName());
           departmentMapper.addDeps(tDepartment);
       }
       return  i;
   }

    /**
     * 得到hotellist
     * @return
     */
   public PageInfo<PgshHotelEntity> getHotelList(Page page){

       PageHelper.startPage(page.getCurrentPage(), page.getPageSize());

       List<PgshHotelEntity> hotelList = pgshHotelEntityMapper.selectHotelByUid(HrUtils.getCurrentHr().getId());


         for(PgshHotelEntity hotelEntity :hotelList){
             if(hotelEntity.getStatus().equals("A")){
                 hotelEntity.setStatuss(true);
             }else {
                 hotelEntity.setStatuss(false);
             }
         }
       return  new PageInfo<>(hotelList);
   }


    /**
     * 得到hotellist
     * @return
     */
    public List<PgshHotelEntity> getHotelLists( ){

        return pgshHotelEntityMapper.selectHotelByUid(HrUtils.getCurrentHr().getId());



    }




    /**
     * c查询宾馆
     * @return
     */
    public List<PgshHotelEntity> searchHotelByItems(HotelIn hotelIn){
        hotelIn.setUid(Integer.parseInt(HrUtils.getCurrentHr().getId()+""));
        List<PgshHotelEntity> hotelList = pgshHotelEntityMapper.searchHotelByItems(hotelIn);
        return  hotelList;

    }


    /**
     * 修改hotel
     * @param pgshHotelEntity
     * @return
     */
   public int updateHotel(PgshHotelEntity pgshHotelEntity){
              pgshHotelEntity.setUpdatedDate(new Date());
              pgshHotelEntity.setUpdatedBy(HrUtils.getCurrentHr().getUsername());
    return    pgshHotelEntityMapper.updateByPrimaryKeySelective(pgshHotelEntity);
   }

    /**
     * 根据id查询hotel
     * @param pgshHotelEntity
     * @return
     */
   public  PgshHotelEntity getHotelById(PgshHotelEntity pgshHotelEntity){
       return  pgshHotelEntityMapper.selectByPrimaryKey(pgshHotelEntity.getId());
   }

    /**
     * 跟据当前用户查询其管辖的宾馆
     * @return
     */
   public List <PgshHotelEntity> selectHotelByUid(){

       List<PgshHotelEntity> entities = pgshHotelEntityMapper.selectHotelByUid(HrUtils.getCurrentHr().getId());
       for(PgshHotelEntity hotelEntity:entities){
           if(hotelEntity.getStatus().equals("A")){
               hotelEntity.setStatuss(true);
           }else {
               hotelEntity.setStatuss(false);
           }
       }
       return entities;
   }

    public Integer deleteOne(Long eid){
       //删除宾馆  需要删除跟用户的关系
        pgHrEntityMapper.deleteByEid(eid);
        return  pgshHotelEntityMapper.deleteByPrimaryKey(eid);

    }


    /**
     *
     * @param hotelIn
     * @return
     */

    public PgshHotelEntity selectHotelByEid(HotelIn hotelIn){

        hotelIn.setUserId(HrUtils.getCurrentHr().getId());
      return   pgshHotelEntityMapper.selectHotelByEid(hotelIn);
    }

}
