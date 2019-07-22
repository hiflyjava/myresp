package com.pg.controller.customer;

import com.github.pagehelper.PageInfo;
import com.pg.bean.PgSmtlkDeviceEventLog;
import com.pg.bean.PgStaff;
import com.pg.bean.PgStaffAttence;
import com.pg.bean.RespBean;
import com.pg.common.dto.in.PgAttenceOneDayIn;
import com.pg.common.dto.in.StaffAttencePageIn;
import com.pg.common.dto.out.*;
import com.pg.common.poi.MyExecelUtils;
import com.pg.common.poi.PoiUtils;
import com.pg.service.PgStaffAttenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: admin
 * @Date: 2019/7/9 12:25
 * @Description:
 */

@RestController
@RequestMapping("/sys/attence")
public class AttenceController {

    @Autowired
    PgStaffAttenceService  attenceService;


    /**
     * 查询当前公司员工一天的考勤
     * @param oneDayIn
     * @return
     */
    @RequestMapping("/getStaffAttenceByOneDay")
    public RespBean getStaffAttenceByOneDay(@RequestBody PgAttenceOneDayIn oneDayIn){
        if(oneDayIn.getEntityId() ==null || "".equals(oneDayIn.getEntityId())){
            return  RespBean.error("please take entityId");
        }
        StaffOneDayAttenceOut staffAttenceByOneDay = attenceService.getStaffAttenceByOneDay(oneDayIn);
        return  RespBean.ok("staffAttenceByOneDay", staffAttenceByOneDay);
    }


    /**
     * 查询当前公司员工不同时间段的考勤
     * @param oneDayIn
     * @return
     */
    @RequestMapping("/getStaffAttenceByDays")
    public RespBean getStaffAttenceByDays(@RequestBody PgAttenceOneDayIn oneDayIn){
        if(oneDayIn.getEntityId() ==null || "".equals(oneDayIn.getEntityId())){
            return  RespBean.error("please take entityId");
        }
        StaffDaysAttenceOut staffAttenceByDays = attenceService.getStaffAttenceByDays(oneDayIn);
        return  RespBean.ok("staffAttenceByDays", staffAttenceByDays);
    }



    /**
     * 查询当天或者范围时间内的打卡记录
     * @param oneDayIn
     * @return
     */
    @RequestMapping("/getClockLogByDays")
    public RespBean getClockLogByDays(@RequestBody PgAttenceOneDayIn oneDayIn){
        if(oneDayIn.getEntityId() ==null || "".equals(oneDayIn.getEntityId())){
            return  RespBean.error("please take entityId");
        }
        PageInfo<PgSmtlkDeviceEventLog>  logByDays = attenceService.getClockLogByDays(oneDayIn);
        return  RespBean.ok("logByDays", logByDays);
    }

    /**
     * 查询当天或者范围时间内的打卡记录
     * @param oneDayIn
     * @return
     */
    @RequestMapping("/getClockTypeLogByToday")
    public RespBean getClockTypeLogByToday(@RequestBody PgAttenceOneDayIn oneDayIn){
        if(oneDayIn.getEntityId() ==null || "".equals(oneDayIn.getEntityId())){
            return  RespBean.error("please take entityId");
        }
        PageInfo<PgSmtlkDeviceEventLog>  logTypeByToday = attenceService.getClockTypeLogByToday(oneDayIn);
        return  RespBean.ok("logTypeByToday", logTypeByToday);
    }


    /**
     *
     * @param pageIn
     * @return
     */
    @RequestMapping("/getStaffsByDid")
    public RespBean getClockTypeLogByToday(@RequestBody StaffAttencePageIn pageIn){
        if(pageIn.getEntityId() ==null || "".equals(pageIn.getEntityId())){
            return  RespBean.error("please take entityId");
        }
        PageInfo<StaffsManyDayAttenceOut>  staffs = attenceService.getStaffsByDid(pageIn);

        return  RespBean.ok("staffs", staffs);
    }


    /**
     *
     * @param pageIn
     * @return
     */
    @RequestMapping("/getStaffsByDidTest")
    public RespBean getStaffsByDidTest(@RequestBody StaffAttencePageIn pageIn){
        if(pageIn.getEntityId() ==null || "".equals(pageIn.getEntityId())){
            return  RespBean.error("please take entityId");
        }
        PageInfo<StaffsManyDayAttenceOut> staffs = attenceService.getStaffsByDidTest(pageIn);
        return  RespBean.ok("staffs", staffs);
    }



    /**
     *
     * @param pageIn
     * @return
     */
    @RequestMapping("/getOneStaffByDidTest")
    public RespBean getOneStaffByDidTest(@RequestBody StaffAttencePageIn pageIn){
        if(pageIn.getEntityId() ==null || "".equals(pageIn.getEntityId())){
            return  RespBean.error("please take entityId");
        }
        List<TestAttenceOut> oneStaffByDidTest = attenceService.getOneStaffByDidTest(pageIn);
        return  RespBean.ok("oneStaffByDidTest", oneStaffByDidTest);
    }


    /**
     * 查询员工原始考勤记录
     * @param pageIn
     * @return
     */
    @RequestMapping("/getOriginalAttenceLog")
    public RespBean getOriginalAttenceLog(@RequestBody StaffAttencePageIn pageIn){
        if(pageIn.getEntityId() ==null || "".equals(pageIn.getEntityId())){
            return  RespBean.error("please take entityId");
        }
        List<OriginalAttenceLogOut> originalAttenceLog = attenceService.getExecelOrgAttOut(pageIn);
        return  RespBean.ok("originalAttenceLog", originalAttenceLog);
    }


    @RequestMapping("/getDepAttenceOut")
    public RespBean getDepAttenceOut(@RequestBody StaffAttencePageIn pageIn){
        if(pageIn.getEntityId() ==null || "".equals(pageIn.getEntityId())){
            return  RespBean.error("please take entityId");
        }
        PageInfo<DepAttenceOut> depAttenceOut = attenceService.getDepAttenceOut(pageIn);
        return  RespBean.ok("depAttenceOut", depAttenceOut);
    }


    @RequestMapping("/getTestExecel")
    public RespBean getTestExecel(@RequestBody StaffAttencePageIn pageIn){
        if(pageIn.getEntityId() ==null || "".equals(pageIn.getEntityId())){
            return  RespBean.error("please take entityId");
        }
        List<OriginalAttenceLogOut> depAttenceOut = attenceService.getExecelOrgAttOut(pageIn);

        return  RespBean.ok("depAttenceOut", depAttenceOut);
    }


    @RequestMapping("/downOriginalExecel")
    public ResponseEntity<byte[]> exportEmps2(@RequestParam Long staffId,
                                              @RequestParam Integer entityId,
                                              @RequestParam String startTime,
                                              @RequestParam String endTime) {
        StaffAttencePageIn staffAttencePageIn1 =new StaffAttencePageIn();
        staffAttencePageIn1.setStartTime(startTime);
        staffAttencePageIn1.setEndTime(endTime);
        staffAttencePageIn1.setEntityId(entityId);
        staffAttencePageIn1.setStaffId(staffId);
        List<OriginalAttenceLogOut> originalAttenceLog = attenceService.getExecelOrgAttOut(staffAttencePageIn1);
       return PoiUtils.exportEmp2Excel2(originalAttenceLog);

    }

    @RequestMapping(value = "/exportEmps" ,method = RequestMethod.GET)
    public ResponseEntity<byte[]> exportEmps( @RequestParam Long staffId,
                                             @RequestParam Integer entityId,
                                             @RequestParam String startTime,
                                             @RequestParam String endTime) {
        StaffAttencePageIn staffAttencePageIn1 =new StaffAttencePageIn();
        staffAttencePageIn1.setStartTime(startTime);
        staffAttencePageIn1.setEndTime(endTime);
        staffAttencePageIn1.setEntityId(entityId);
        staffAttencePageIn1.setStaffId(staffId);
        List<StaffsManyDayAttenceOut> staffsByDidTestForExecel = attenceService.getStaffsByDidTestForExecel(staffAttencePageIn1);
        return PoiUtils.exportEmp2Excel(staffsByDidTestForExecel);
    }


    @RequestMapping(value = "/exportOriginal" ,method = RequestMethod.GET)
    public ResponseEntity<byte[]> exportOriginal(@RequestParam Long staffId,
                                   @RequestParam Integer entityId,
                                   @RequestParam String startTime,
                                   @RequestParam String endTime, HttpServletResponse response) {
        StaffAttencePageIn staffAttencePageIn1 =new StaffAttencePageIn();
        staffAttencePageIn1.setStartTime(startTime);
        staffAttencePageIn1.setEndTime(endTime);
        staffAttencePageIn1.setEntityId(entityId);
        staffAttencePageIn1.setStaffId(staffId);
        List<OriginalAttenceLogOut> originalAttenceLog = attenceService.getExecelOrgAttOut(staffAttencePageIn1);
        return PoiUtils.exportEmp2Excel2(originalAttenceLog);
//
//        //List<Role> list = this.roleService.findAllRole(role);
//
//        List<String> strings = new ArrayList<>();
//        // strings.add("第一列");
//        strings.add("编号");
//        strings.add("部门");
//        strings.add("职位");
//        strings.add("名字");
//        strings.add("姓");
//        strings.add("机器号");
//        originalAttenceLog.get(0).getOriginalAttenceDates()
//        for (TestUser testUser : users) {
//            strings.add(testUser.getUserName());
//        }
//
//
//        String[] rowsName = new String[strings.size()];
//        for (int k = 0; k < strings.size(); k++) {
//            rowsName[k] = strings.get(k);
//        }
//
//
//        List<Object[]> dataList = new ArrayList<>();
//        Object[] objs = null;
//        for (int i = 0; i < list.size(); i++) {
//            Roles main = list.get(i);
//            objs = new Object[rowsName.length];
//            objs[0] = i;
//            objs[1] =  main.getRoleId();
//
//            objs[2] = main.getRemark();
//
//            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            String date1 = df.format(main.getCreateTime());
//            objs[3] = date1;
//            String date2 = df.format(main.getModifyTime());
//            objs[4] = date2;
//            try {
//                for (int y = 0; y< main.getUsers().size(); y++) {
//                    int p=5+y;
//                    objs[p] = main.getUsers().get(y).getUserDep();
//
//                }
//
//            }catch (ArrayIndexOutOfBoundsException a){
//
//            }
//            dataList.add(objs);
//        }
//
//        MyExecelUtils ex = new MyExecelUtils("角色表", rowsName, dataList);
//        ex.export(response);


      // return  RespBean.ok("");
    }

    /**
     * 手动添加考勤记录
     * @param log
     * @return
     */

    @RequestMapping("/addAttenceLog")
    public RespBean addAttenceLog(@RequestBody PgSmtlkDeviceEventLog log){
        if(log.getUserId() ==null || "".equals(log.getUserId())){
            return  RespBean.error("please take userId");
        }
        int i = attenceService.insertSelective(log);
        if(i>=1){
            return  RespBean.ok("add success");
        }else {
            return  RespBean.error("add failed");
        }
    }

    @RequestMapping("/updateAttenceLog")
    public RespBean updateAttenceLog(@RequestBody PgSmtlkDeviceEventLog log){
        if(log.getUserId() ==null || "".equals(log.getUserId())){
            return  RespBean.error("please take userId");
        }
        int i = attenceService.updateByPrimaryKeySelective(log);
        if(i>=1){
            return  RespBean.ok("update success");
        }else {
            return  RespBean.error("update failed");
        }
    }


    @RequestMapping("/getAddAttenceLog")
    public RespBean getAddAttenceLog(@RequestBody PgSmtlkDeviceEventLog log){
        if(log.getUserId() ==null || "".equals(log.getUserId())){
            return  RespBean.error("please take userId");
        }
        List<PgSmtlkDeviceEventLog> staffTimesLog = attenceService.getOneStaffTimesLog(log);
        return  RespBean.ok("staffTimesLog", staffTimesLog);
    }


    @RequestMapping("/deleteAddAttenceLog")
    public RespBean deleteAddAttenceLog(@RequestBody PgSmtlkDeviceEventLog log){
        if(log.getUserId() ==null || "".equals(log.getUserId())){
            return  RespBean.error("please take userId");
        }
        int i = attenceService.deleteAddAttenceLog(log);
        if(i>=1){
            return  RespBean.ok("delete success");
        }else {
           return  RespBean.error("delete failed");
        }

    }

}

