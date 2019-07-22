package com.pg.controller.hotel;

import com.github.pagehelper.PageInfo;
import com.pg.base.ResultVo;
import com.pg.bean.*;
import com.pg.common.aop.MustLogin;
import com.pg.common.dto.in.HotelIn;
import com.pg.common.dto.in.RoomListIn;
import com.pg.mapper.PgHrEntityMapper;
import com.pg.mapper.PgshHotelEntityMapper;
import com.pg.service.PgWorkClassService;
import com.pg.service.PgWorkTimeService;
import com.pg.service.PgshHotelEntityService;

import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: admin
 * @Date: 2019/4/3 16:10
 * @Description:
 */

@RestController
@RequestMapping("/system/hotel")
public class PgshHotelEntityController {

    private  static  final Logger logger= LoggerFactory.getLogger(PgshHotelEntityMapper.class);


    @Autowired
    private PgshHotelEntityService pgshHotelEntityService;

    @Autowired
    private PgHrEntityMapper pgHrEntityMapper;

    @Autowired
    private PgWorkTimeService workTimeService;


    /**
     * 查询当前用户管辖的宾馆ok
     * @return
     */
    @RequestMapping("/userHotelList")
    public  RespBean userHotelList(){

        List<PgshHotelEntity> hotelList = pgshHotelEntityService.getHotelLists();

        return  RespBean.ok("hotelList", hotelList);
    }






      @RequestMapping("/addHotel")
      public RespBean addRoom(@RequestBody PgshHotelEntity pgshHotelEntity){
       if(pgshHotelEntityService.addHotel(pgshHotelEntity)==1){
           return  RespBean.ok("添加成功");
       }else {
           return  RespBean.error("添加失败");
       }

      }
    @RequestMapping("/updateHotel")
    public RespBean updateRoom(@RequestBody PgshHotelEntity pgshHotelEntity){
        if(pgshHotelEntityService.updateHotel(pgshHotelEntity)==1){
            return  RespBean.ok("修改成功");
        }else {
            return  RespBean.error("修改失败");
        }

    }

    /**
     * 分页展示宾馆
     * @return
     */
    @RequestMapping("/hotelList")
    public  ResultVo getHotelList(@RequestBody Page page){
        ResultVo resultVo =new ResultVo();
        PageInfo<PgshHotelEntity> hotelList = pgshHotelEntityService.getHotelList(page);
        resultVo.setData(hotelList);
        return  resultVo;
    }

    /**
     * 搜索宾馆
     * @return
     */
    @RequestMapping("/searchHotelByItems")
    public  ResultVo searchHotelByItems(@RequestBody HotelIn hotelIn){
        ResultVo resultVo =new ResultVo();
        List<PgshHotelEntity> hotelList = pgshHotelEntityService.searchHotelByItems(hotelIn);
        resultVo.setData(hotelList);
        return  resultVo;
    }


    @RequestMapping("/getHotelInfoById")
    public ResultVo rre(@RequestBody PgshHotelEntity pgshHotelEntity){

        ResultVo resultVo =new ResultVo();
        resultVo.setData(pgshHotelEntityService.getHotelById(pgshHotelEntity));
        return  resultVo;
    }

    /**
     * 查询当前用户所管辖的宾馆
     * @return
     */
    @RequestMapping("/selectHotelByUid")
    public  ResultVo selectHotelByUid(){
        ResultVo resultVo =new ResultVo();
    List<PgshHotelEntity> pgshHotelEntities = pgshHotelEntityService.selectHotelByUid();
    resultVo.setData(pgshHotelEntities);
    return  resultVo;

}


    /**
     * 删除hotel
     * @return
     */
    @RequestMapping("/delateHotelById")
    public  RespBean delateHotelById(@RequestBody PgshHotelEntity pgshHotelEntity){

        try{
            Integer deleteOne = pgshHotelEntityService.deleteOne(pgshHotelEntity.getId());
            if(deleteOne >=1){
                return RespBean.ok("delete success");
            }
            return  RespBean.error("delete failed");
        }catch (Exception e)
        {
           logger.error("删除宾馆失败", e);
           return  RespBean.error("删除宾馆失败，请联系系统管理员");
        }

    }

    /**
     * 查询单个公司的详情
     * @param hotelIn
     * @return
     */

    @RequestMapping("/selectOfficeByEid")
    public  RespBean selectHotelByEid(@RequestBody HotelIn hotelIn){

           if(hotelIn.getEid() ==null || "".equals(hotelIn.getEid())){
               return  RespBean.error("please take eid");
           }else {


             PgshHotelEntity pgshHotelEntity = pgshHotelEntityService.selectHotelByEid(hotelIn);

               return RespBean.ok("pgshOfficeEntity", pgshHotelEntity);
           }
    }


    @RequestMapping("/getWorkTimeList")
    public  RespBean selectHotelByEid(){
        List<PgWorkTime> workTimeList = workTimeService.getWorkTimeList();
        return  RespBean.ok("workTimeList", workTimeList);
    }

    //查询当前公司的上下班时间
    @RequestMapping("/getThisOfficeWorkTime")
    public  RespBean getThisOfficeWorkTime(@RequestBody PgshHotelEntity pgshHotelEntity){
        PgshHotelEntity hotel = pgshHotelEntityService.getHotelById(pgshHotelEntity);
        return  RespBean.ok("officeWorkTime", hotel);
    }

}

