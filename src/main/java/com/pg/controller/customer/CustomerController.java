package com.pg.controller.customer;

import com.github.pagehelper.PageInfo;
import com.pg.base.ResultVo;
import com.pg.bean.*;
import com.pg.common.dto.in.CustomerPageIn;
import com.pg.mapper.PgshHotelEntityMapper;
import com.pg.service.CustomerService;
import com.pg.service.PgCountryService;
import com.pg.service.PgStaffService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

/**
 * @Auther: admin
 * @Date: 2019/6/3 19:06
 * @Description:
 */




@RestController
@RequestMapping("/system/staff")
public class CustomerController  {

    private  static  final Logger logger= LoggerFactory.getLogger(PgshHotelEntityMapper.class);


    @Autowired
    PgStaffService pgStaffService;

    @Autowired
    PgCountryService countryService;


    @RequestMapping("/addStaff")
    public RespBean addStaff(@RequestBody PgStaff pgStaff){

       if(pgStaff.getEntityId() ==null || "".equals(pgStaff.getEntityId())){
            return  RespBean.error("please take entityId");
        }else {
           int i = 0;
           try {
               i = pgStaffService.insertSelective(pgStaff);
           } catch (ParseException e) {
               e.printStackTrace();
           }
           if(i==1){
                return  RespBean.ok("add success");
            }else {
                return  RespBean.error("add failed ");
            }
        }

    }


    /**
     * 查询所有的国家
     * @return
     */
    @RequestMapping("/countrys")
    public RespBean getCountrys(@RequestBody PgCountry pgCountry){
        List<PgCountry> countrys = countryService.getCountrys(pgCountry);
        return  RespBean.ok("countrys",countrys);
    }


    @RequestMapping("/updateStaff")
    public RespBean updateStaff(@RequestBody PgStaff pgStaff){

        if(pgStaff.getId() ==null || "".equals(pgStaff.getId())){
            return  RespBean.error("please take id");
        }else {
            int i = pgStaffService.updateByPrimaryKeySelective(pgStaff);
            if(i==1){
                return  RespBean.ok("update success");
            }else {
                return  RespBean.error("update failed ");
            }
        }

    }


    @RequestMapping("/getStaffList")
    public ResultVo getStaffList(@RequestBody PgStaff pgStaff){
           ResultVo resultVo =new ResultVo();
        if(pgStaff.getEntityId() ==null || "".equals(pgStaff.getEntityId())){
            resultVo.setErrorMessage("please take entityId");
        }else {
            PageInfo<PgStaff> staffsByKeywords = pgStaffService.getStaffsByKeywords(pgStaff);
            resultVo.setData(staffsByKeywords);
        }
        return  resultVo;
    }

}
