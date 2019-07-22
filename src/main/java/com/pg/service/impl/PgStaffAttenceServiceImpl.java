package com.pg.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pg.bean.*;
import com.pg.common.dto.in.PgAttenceOneDayIn;
import com.pg.common.dto.in.StaffAttencePageIn;
import com.pg.common.dto.out.*;
import com.pg.common.utils.MyDateUtils;
import com.pg.mapper.DepartmentMapper;
import com.pg.mapper.PgSmtlkDeviceEventLogMapper;
import com.pg.mapper.PgStaffAttenceMapper;
import com.pg.mapper.PgStaffMapper;
import com.pg.service.PgStaffAttenceService;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Auther: admin
 * @Date: 2019/7/9 11:35
 * @Description:
 */
@Service
@Transactional
public class PgStaffAttenceServiceImpl implements PgStaffAttenceService {


    @Autowired
    PgSmtlkDeviceEventLogMapper  eventLogMapper;

    @Autowired
    PgStaffAttenceMapper staffAttenceMapper;

    @Autowired
    PgStaffMapper staffMapper;


    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(PgSmtlkDeviceEventLog record) {
        return 0;
    }

    @Override
    public int insertSelective(PgSmtlkDeviceEventLog record) {
        record.setType(2);//自定义增加的考勤记录是 可以修改的类型
       record.setEventCode(4+"");
        record.setCreatedDate(new Date());
        return   eventLogMapper.insertSelective(record);

    }

    @Override
    public PgSmtlkDeviceEventLog selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(PgSmtlkDeviceEventLog record) {
        record.setUpdatedDate(new Date());
       return eventLogMapper.updateByPrimaryKeySelective(record);

    }

    @Override
    public int updateByPrimaryKey(PgSmtlkDeviceEventLog record) {
        return 0;
    }

    /**
     * 一个公司某一天的考勤
     * @param oneDayIn
     * @return
     */

    @Override
    public StaffOneDayAttenceOut getStaffAttenceByOneDay(PgAttenceOneDayIn oneDayIn) {

        //
        List<String> daysBetwAnd = MyDateUtils.getDaysBetwAnd(oneDayIn.getStartToday(), oneDayIn.getEndToday());


        List<PgStaff> staffs = staffMapper.getStaffsByEid(oneDayIn.getEntityId());//得到公司所有的员工
        Integer allStaffs = staffs.size();//公司所有的员工
        List<PgSmtlkDeviceEventLog> staffLateAndLateMinute = eventLogMapper.getStaffAttenceByOneDay(oneDayIn);//得到当前部门迟到的人数 和迟到多少分钟
        Integer arriveStaffs = staffLateAndLateMinute.size();//到了公司打卡的人
         Integer noArriveStaffs =allStaffs-arriveStaffs;//没有打卡的人
         Integer lateStaffs=0;
         Integer earlyStaffs=0;
         Integer addStaffs=0;
        List<PgStaffAttence> attences =new ArrayList<>();
        for(PgSmtlkDeviceEventLog  attenceStaff :staffLateAndLateMinute){
            PgStaffAttence pgStaffAttence =new PgStaffAttence();
             pgStaffAttence.setFristTime(attenceStaff.getMintime());//第一次打卡
             pgStaffAttence.setLastTime(attenceStaff.getMaxtime());//最后一次打卡
            pgStaffAttence.setStaffId(attenceStaff.getId());
            pgStaffAttence.setStaffName(attenceStaff.getName());
            pgStaffAttence.setStartWorkTime( attenceStaff.getStartTime().substring(11));
            pgStaffAttence.setEndWorkTime(attenceStaff.getEndTime().substring(11));
            pgStaffAttence.setAddWorkTime(attenceStaff.getAddTime().substring(11));
           // pgStaffAttence.setStartWorkTime();
            pgStaffAttence.setTodayTime(oneDayIn.getTodayDate());//设置查询的日期
             if(attenceStaff.getLateMinute()<=0){
                pgStaffAttence.setIslate(1);//1 没有迟到
                 pgStaffAttence.setLateTime(0l);
             }else {
                 pgStaffAttence.setIslate(2);//迟到
                 pgStaffAttence.setLateTime(attenceStaff.getLateMinute());//迟到的时间
                 lateStaffs++;//计算迟到的人数
             }

             if(attenceStaff.getEarlyMinute()<=0){//早退了
               pgStaffAttence.setIsearly(2);
               pgStaffAttence.setEarlyTime(attenceStaff.getEarlyMinute());
               earlyStaffs++;//计算早退的人数
             }else {//没有早退
                 pgStaffAttence.setIsearly(1);
                 pgStaffAttence.setEarlyTime(0l);
             }

             if(attenceStaff.getAddMinute()>=0){//加班了
               pgStaffAttence.setIsadd(1);
               pgStaffAttence.setAddTime(attenceStaff.getAddMinute());
               addStaffs++;//计算加班的人数
             }else {//没有加班
                 pgStaffAttence.setIsadd(2);
                 pgStaffAttence.setAddTime(0l);
             }
             attences.add(pgStaffAttence);
        }
        StaffOneDayAttenceOut oneDayAttenceOut =new StaffOneDayAttenceOut();
        oneDayAttenceOut.setAddStaffs(addStaffs);//加班人数
        oneDayAttenceOut.setLateStaffs(lateStaffs);//迟到人数
        oneDayAttenceOut.setEarlyStaffs(earlyStaffs);//早退人数
        oneDayAttenceOut.setAllStaffs(allStaffs);//所有考勤人数
        oneDayAttenceOut.setArriveStaffs(arriveStaffs);//参与打卡的人数
        oneDayAttenceOut.setNoArriveStaffs(noArriveStaffs);//没打卡的人数
        oneDayAttenceOut.setStaffAttences(attences);//打卡人的考勤统计
        return oneDayAttenceOut;
        //650
    }

    @Override
    public StaffDaysAttenceOut getStaffAttenceByDays(PgAttenceOneDayIn oneDayIn) {
        List<String> daysBetwAnd = MyDateUtils.getDaysBetwAnd(oneDayIn.getStartToday(), oneDayIn.getEndToday());
        List<PgStaff> staffs = staffMapper.getStaffsByEid(oneDayIn.getEntityId());//得到公司所有的员工
        Integer allStaffs = staffs.size();//公司所有的员工
        Integer arriveStaffsCount=0;//这段时间总共打卡的人数
        Integer noArriveStaffsCount=0;//这段时间没有打卡的人数
        Integer lateStaffsCount=0;//这段时间迟到的人数
        Integer earlyStaffsCount=0;//这段时间早退的人数
        Integer addStaffsCount=0;//这段时间加班的人数


        try {

            for(int i=0;i<daysBetwAnd.size();i++){
                oneDayIn.setStartToday(daysBetwAnd.get(i));
                oneDayIn.setEndToday(daysBetwAnd.get(i+1));
                oneDayIn.setTodayDate(daysBetwAnd.get(i).substring(0,10));
                List<PgSmtlkDeviceEventLog> staffLateAndLateMinute = eventLogMapper.getStaffAttenceByOneDay(oneDayIn);//得到当前部门迟到的人数 和迟到多少分钟
                Integer arriveStaffs = staffLateAndLateMinute.size();//到了公司打卡的人
                Integer noArriveStaffs =allStaffs-arriveStaffs;//没有打卡的人
                Integer lateStaffs=0;
                Integer earlyStaffs=0;
                Integer addStaffs=0;
                List<PgStaffAttence> attences =new ArrayList<>();
                for(PgSmtlkDeviceEventLog  attenceStaff :staffLateAndLateMinute){
                    PgStaffAttence pgStaffAttence =new PgStaffAttence();
                    pgStaffAttence.setFristTime(attenceStaff.getMintime());//第一次打卡
                    pgStaffAttence.setLastTime(attenceStaff.getMaxtime());//最后一次打卡
                    pgStaffAttence.setStaffId(attenceStaff.getId());
                    pgStaffAttence.setStaffName(attenceStaff.getName());
                    pgStaffAttence.setStartWorkTime( attenceStaff.getStartTime().substring(11));
                    pgStaffAttence.setEndWorkTime(attenceStaff.getEndTime().substring(11));
                    pgStaffAttence.setAddWorkTime(attenceStaff.getAddTime().substring(11));
                    // pgStaffAttence.setStartWorkTime();
                    pgStaffAttence.setTodayTime(oneDayIn.getTodayDate());//设置查询的日期
                    if(attenceStaff.getLateMinute()<=0){
                        pgStaffAttence.setIslate(1);//1 没有迟到
                        pgStaffAttence.setLateTime(0l);
                    }else {
                        pgStaffAttence.setIslate(2);//迟到
                        pgStaffAttence.setLateTime(attenceStaff.getLateMinute());//迟到的时间
                        lateStaffs++;//计算迟到的人数
                    }

                    if(attenceStaff.getEarlyMinute()<=0){//早退了
                        pgStaffAttence.setIsearly(2);
                        pgStaffAttence.setEarlyTime(attenceStaff.getEarlyMinute());
                        earlyStaffs++;//计算早退的人数
                    }else {//没有早退
                        pgStaffAttence.setIsearly(1);
                        pgStaffAttence.setEarlyTime(0l);
                    }

                    if(attenceStaff.getAddMinute()>=0){//加班了
                        pgStaffAttence.setIsadd(1);
                        pgStaffAttence.setAddTime(attenceStaff.getAddMinute());
                        addStaffs++;//计算加班的人数
                    }else {//没有加班
                        pgStaffAttence.setIsadd(2);
                        pgStaffAttence.setAddTime(0l);
                    }
                    attences.add(pgStaffAttence);
                }

                 arriveStaffsCount+= arriveStaffs;//这段时间总共打卡的人数
                 noArriveStaffsCount+=noArriveStaffs;//这段时间没有打卡的人数
                 lateStaffsCount+=lateStaffs;//这段时间迟到的人数
                 earlyStaffsCount +=earlyStaffs;//这段时间早退的人数
                 addStaffsCount +=addStaffs;//这段时间加班的人数

            }

        } catch (IndexOutOfBoundsException e) {

        }

        StaffDaysAttenceOut daysAttenceOut =new StaffDaysAttenceOut();
        daysAttenceOut.setAddStaffsCount(addStaffsCount);
        daysAttenceOut.setAllStaffs(allStaffs);
        daysAttenceOut.setArriveStaffsCount(arriveStaffsCount);
        daysAttenceOut.setEarlyStaffsCount(earlyStaffsCount);
        daysAttenceOut.setLateStaffsCount(lateStaffsCount);
        daysAttenceOut.setNoArriveStaffsCount(noArriveStaffsCount);
        return  daysAttenceOut;

    }

    @Override
    public PageInfo<PgSmtlkDeviceEventLog> getClockLogByDays(PgAttenceOneDayIn oneDayIn) {

        PageHelper.startPage(oneDayIn.getCurrentPage(), oneDayIn.getPageSize());
        List<PgSmtlkDeviceEventLog> clockLogByDays = eventLogMapper.getClockLogByDays(oneDayIn);
        return new PageInfo<>(clockLogByDays);
    }

    @Override
    public PageInfo<PgSmtlkDeviceEventLog> getClockTypeLogByToday(PgAttenceOneDayIn oneDayIn) {
        PageHelper.startPage(oneDayIn.getCurrentPage(), oneDayIn.getPageSize());
        List<PgSmtlkDeviceEventLog> clockTypeLogByToday = eventLogMapper.getClockTypeLogByToday(oneDayIn);
        return new PageInfo<>(clockTypeLogByToday);
    }

    @Override
    public PageInfo<StaffsManyDayAttenceOut> getStaffsByDid(StaffAttencePageIn staffAttencePageIn) {
        PageHelper.startPage(staffAttencePageIn.getCurrentPage(), staffAttencePageIn.getPageSize());
        List<StaffsManyDayAttenceOut> staffs = staffMapper.getStaffsByDid(staffAttencePageIn);
        List<String> daysBetwAnd = MyDateUtils.getDaysBetwAnd(staffAttencePageIn.getStartTime(), staffAttencePageIn.getEndTime());
        for(StaffsManyDayAttenceOut staff :staffs){
            staffAttencePageIn.setStaffId(staff.getId());
            staffAttencePageIn.setTodayDate(staffAttencePageIn.getStartTime().substring(0, 10));
                    String xc="";
                    StaffsManyDayAttenceOut attence = eventLogMapper.getOneStaffAttenceByDays(staffAttencePageIn);//这是一天的考勤
                    if(attence.getMaxtimes() ==null){
                        xc="";
                    }else {
                        if(attence.getMmMinute()==0){ //只有一次打卡
                            if(attence.getSxMinute()>0){
                                xc=attence.getMintimes().substring(11, 16)+"-"+"";
                            }else {
                                xc=""+"-"+attence.getMintimes().substring(11, 16);
                            }
                        }else {//正常两次打卡
                            xc=attence.getMintimes().substring(11, 16)+"-"+attence.getMaxtimes().substring(11, 16);
                        }
                    }
                    staff.setInDateAttence(xc);
                    staff.setInDateTime(staffAttencePageIn.getTodayDate());
                }
        return new PageInfo<>(staffs);
    }

    @Override
    public PageInfo<StaffsManyDayAttenceOut> getStaffsByDidTest(StaffAttencePageIn staffAttencePageIn) {
        PageHelper.startPage(staffAttencePageIn.getCurrentPage(), staffAttencePageIn.getPageSize());
        List<StaffsManyDayAttenceOut> staffs = staffMapper.getStaffsByDid(staffAttencePageIn);
        List<String> daysBetwAnd = MyDateUtils.getDaysBetwAnd(staffAttencePageIn.getStartTime(), staffAttencePageIn.getEndTime());

        for(StaffsManyDayAttenceOut staff :staffs){
            List<TestAttenceOut> list =new ArrayList<>();

            try {

                for(int a=0;a<daysBetwAnd.size();a++){
                    TestAttenceOut testAttenceOut =new TestAttenceOut();
                    String xc=null;
                    staffAttencePageIn.setStaffId(staff.getId());
                    staffAttencePageIn.setStartTime(daysBetwAnd.get(a));
                    staffAttencePageIn.setEndTime(daysBetwAnd.get(a+1));
                    staffAttencePageIn.setTodayDate(daysBetwAnd.get(a).substring(0, 10));
                    StaffsManyDayAttenceOut attence = eventLogMapper.getOneStaffAttenceByDays(staffAttencePageIn);//这是一天的考勤
                    if(attence.getMaxtimes() ==null){
                        xc="";
                    }else {
                        if(attence.getMmMinute()==0){ //只有一次打卡
                            if(attence.getSxMinute()>0){
                                xc=attence.getMintimes().substring(11, 16)+"-"+"";
                            }else {
                                xc=""+"-"+attence.getMintimes().substring(11, 16);
                            }
                        }else {//正常两次打卡
                            xc=attence.getMintimes().substring(11, 16)+"-"+attence.getMaxtimes().substring(11, 16);
                        }
                    }
                     testAttenceOut.setDates(daysBetwAnd.get(a).substring(0, 10));
                    testAttenceOut.setDatas(xc);
                    list.add(testAttenceOut);
                }

            }catch (IndexOutOfBoundsException e){

            }finally {

            }
            staff.setAttenceOutList(list);
        }
        return new PageInfo<>(staffs);
    }

    @Override
    public List<StaffsManyDayAttenceOut> getStaffsByDidTestForExecel(StaffAttencePageIn staffAttencePageIn) {

        List<StaffsManyDayAttenceOut> staffs = staffMapper.getStaffsByDid(staffAttencePageIn);
        List<String> daysBetwAnd = MyDateUtils.getDaysBetwAnd(staffAttencePageIn.getStartTime(), staffAttencePageIn.getEndTime());

        for(StaffsManyDayAttenceOut staff :staffs){
            List<TestAttenceOut> list =new ArrayList<>();

            try {

                for(int a=0;a<daysBetwAnd.size();a++){
                    TestAttenceOut testAttenceOut =new TestAttenceOut();
                    String xc=null;
                    staffAttencePageIn.setStaffId(staff.getId());
                    staffAttencePageIn.setStartTime(daysBetwAnd.get(a));
                    staffAttencePageIn.setEndTime(daysBetwAnd.get(a+1));
                    staffAttencePageIn.setTodayDate(daysBetwAnd.get(a).substring(0, 10));
                    StaffsManyDayAttenceOut attence = eventLogMapper.getOneStaffAttenceByDays(staffAttencePageIn);//这是一天的考勤
                    if(attence ==null){
                      xc="";
                    }else {
                        if(attence.getMaxtimes() ==null){
                            xc="";
                        }else {
                            if(attence.getMmMinute()==0){ //只有一次打卡
                                if(attence.getSxMinute()>0){
                                    xc=attence.getMintimes().substring(11, 16)+"-"+"";
                                }else {
                                    xc=""+"-"+attence.getMintimes().substring(11, 16);
                                }
                            }else {//正常两次打卡
                                xc=attence.getMintimes().substring(11, 16)+"-"+attence.getMaxtimes().substring(11, 16);
                            }
                        }
                    }

                    testAttenceOut.setDates(daysBetwAnd.get(a).substring(0, 10));
                    testAttenceOut.setDatas(xc);
                    list.add(testAttenceOut);
                }

            }catch (IndexOutOfBoundsException e){

            }finally {

            }
            staff.setAttenceOutList(list);
        }
        return staffs;
    }

    @Override
    public List<TestAttenceOut> getOneStaffByDidTest(StaffAttencePageIn staffAttencePageIn) {

      if("".equals(staffAttencePageIn.getStartTime()) || "".equals( staffAttencePageIn.getEndTime())){
          return  null;
      }

        List<String> daysBetwAnd = MyDateUtils.getDaysBetwAnd(staffAttencePageIn.getStartTime(), staffAttencePageIn.getEndTime());

            List<TestAttenceOut> list =new ArrayList<>();

            try {

                for(int a=0;a<daysBetwAnd.size();a++){
                    TestAttenceOut testAttenceOut =new TestAttenceOut();
                   // String xc=null;
                    staffAttencePageIn.setStartTime(daysBetwAnd.get(a));
                    staffAttencePageIn.setEndTime(daysBetwAnd.get(a+1));
                    staffAttencePageIn.setTodayDate(daysBetwAnd.get(a).substring(0, 10));
                    StaffsManyDayAttenceOut attence = eventLogMapper.getOneStaffAttenceByDays(staffAttencePageIn);//这是一天的考勤
                    if(attence.getMaxtimes() ==null){
                       // xc="";
                        testAttenceOut.setFirstLog("");
                        testAttenceOut.setLastLog("");
                    }else {
                        if(attence.getMmMinute()==0){ //只有一次打卡
                            if(attence.getSxMinute()>0){
                               // xc=attence.getMintimes().substring(11, 16)+"-"+"";
                                testAttenceOut.setFirstLog(attence.getMintimes().substring(11, 16));
                                testAttenceOut.setLastLog("");
                            }else {
                               // xc=""+"-"+attence.getMintimes().substring(11, 16);
                                testAttenceOut.setFirstLog("");
                                testAttenceOut.setLastLog(attence.getMaxtimes().substring(11, 16));
                            }
                        }else {//正常两次打卡
                            //xc=attence.getMintimes().substring(11, 16)+"-"+attence.getMaxtimes().substring(11, 16);
                            testAttenceOut.setFirstLog(attence.getMintimes().substring(11, 16));
                            testAttenceOut.setLastLog(attence.getMaxtimes().substring(11, 16));
                        }
                    }
                    testAttenceOut.setDates(daysBetwAnd.get(a).substring(0, 10));
                    list.add(testAttenceOut);
                }

            }catch (IndexOutOfBoundsException e){

            }finally {
            }
        return  list;
    }

    @Override
    public List<OriginalAttenceLogOut> getOriginalAttenceLog(StaffAttencePageIn staffAttencePageIn) {

        if(staffAttencePageIn.getDepartmentId() !=null && !"".equals(staffAttencePageIn.getDepartmentId())){
            TDepartment tDepartment =new TDepartment();
            tDepartment.setId(Long.parseLong(staffAttencePageIn.getDepartmentId()+""));
            tDepartment.setEntityId(staffAttencePageIn.getEntityId());
            TDepartment path = departmentMapper.getDepPathById(tDepartment);
            staffAttencePageIn.setDepPath(path.getDepPath());
        }

        return eventLogMapper.getOriginalAttenceLog(staffAttencePageIn);

    }

    @Override
    public List<OriginalAttenceLogOut> getExecelOrgAttOut(StaffAttencePageIn staffAttencePageIn) {

        if(staffAttencePageIn.getDepartmentId() !=null && !"".equals(staffAttencePageIn.getDepartmentId())){
            TDepartment tDepartment =new TDepartment();
            tDepartment.setId(Long.parseLong(staffAttencePageIn.getDepartmentId()+""));
            tDepartment.setEntityId(staffAttencePageIn.getEntityId());
            TDepartment path = departmentMapper.getDepPathById(tDepartment);
            staffAttencePageIn.setDepPath(path.getDepPath());
        }
        List<String> daysBetwAnd = MyDateUtils.getDaysBetwAnd(staffAttencePageIn.getStartTime(), staffAttencePageIn.getEndTime());
        List<OriginalAttenceLogOut> originalAttenceLog = eventLogMapper.getOriginalAttenceLog(staffAttencePageIn);
        for(OriginalAttenceLogOut log :originalAttenceLog){//遍历每个人
            List<OriginalAttenceDates> originalAttenceDates = log.getOriginalAttenceDates();//莫个人的考勤数据
            List<OriginalAttenceDates> originalAttenceDatesTest = new ArrayList<>();//那些日期没有数据的list


            for(int r=0;r<daysBetwAnd.size()-1;r++){
               // System.out.println(log.getStaffName());
                OriginalAttenceDates dates =new OriginalAttenceDates();

                for(int a=0;a<originalAttenceDates.size();a++){

                 //  System.out.println(daysBetwAnd.get(r).substring(0, 10).equals(originalAttenceDates.get(a).getDates()));
                    if( !daysBetwAnd.get(r).substring(0, 10).toString().equals( originalAttenceDates.get(a).getDates().toString())){
                        dates.setDates(daysBetwAnd.get(r).substring(0, 10));
                        dates.setOriginalAttenceDatas(null);

                    }
                }
                if(dates.getDates() !=null){
                    originalAttenceDatesTest.add(dates);
                }

            }
              for(int z=0; z<originalAttenceDatesTest.size();z++){//组成的空数据
                  for(int u=0;u< originalAttenceDates.size();u++){//实际有的数据

                      if( originalAttenceDatesTest.get(z).getDates() !=null){
                          if(originalAttenceDatesTest.get(z).getDates().equals(originalAttenceDates.get(u).getDates())){
                              originalAttenceDatesTest.get(z).setDates(null);
                          }
                      }
                  }
              }

            List<OriginalAttenceDates> originalAttenceDatesTest1 = new ArrayList<>();
              for(OriginalAttenceDates attenceDates: originalAttenceDatesTest){
                  if(attenceDates.getDates()!=null){
                      originalAttenceDatesTest1.add(attenceDates);
                  }
              }
            originalAttenceDates.addAll(originalAttenceDatesTest1);



              for(int g=0;g<originalAttenceDates.size();g++){
                  List<OriginalAttenceDatas> datasList = originalAttenceDates.get(g).getOriginalAttenceDatas();
                  String datass="";
                  if(datasList==null){
                      datass="";
                  }else {
                      String max=originalAttenceDates.get(g).getOriginalAttenceDatas().get(0).getDatas();
                      String min=originalAttenceDates.get(g).getOriginalAttenceDatas().get(originalAttenceDates.get(g).getOriginalAttenceDatas().size()-1).getDatas();
//                      System.out.println("min===>"+max);
//                      System.out.println("max===>"+min);
                      String sfStartTime=originalAttenceDates.get(g).getDates()+" "+log.getStartTime();
                      String sfEndTime=originalAttenceDates.get(g).getDates()+" "+log.getEndTime();
                      String sfFirstTime=originalAttenceDates.get(g).getDates()+" "+max+":00";
                      String sfLastTime=originalAttenceDates.get(g).getDates()+" "+min+":00";
                      long sfFirst=0;
                      long sfLast=0;
                      long endDatas=0;
                      long startDatas=0;
                      try {
                         sfFirst= MyDateUtils.dateToStamplongHms(sfFirstTime);//第一次打卡时间
                         sfLast= MyDateUtils.dateToStamplongHms(sfLastTime);//最后一次打卡时间
                         endDatas = MyDateUtils.dateToStamplongHms(sfEndTime);//下班时间
                        startDatas=  MyDateUtils.dateToStamplongHms(sfStartTime);//上班时间
                          if(sfFirst==sfLast){//
                              if(startDatas<sfFirst){//
                                  originalAttenceDates.get(g).getOriginalAttenceDatas().get(0).setStatus(1);//迟到
                              }else {
                                   if(endDatas>sfLast){
                                       originalAttenceDates.get(g).getOriginalAttenceDatas().get(0).setStatus(2);//早退
                                   }
                              }
                          }else {

                              if(startDatas<sfFirst){//迟到

                                  if(endDatas>sfLast){//迟到加早退
                                      originalAttenceDates.get(g).getOriginalAttenceDatas().get(0).setStatus(1);//迟到
                                      originalAttenceDates.get(g).getOriginalAttenceDatas().get(originalAttenceDates.get(g).getOriginalAttenceDatas().size()-1).setStatus(3);//早退
                                  }else {//只有迟到
                                      originalAttenceDates.get(g).getOriginalAttenceDatas().get(0).setStatus(1);//迟到
                                      originalAttenceDates.get(g).getOriginalAttenceDatas().get(originalAttenceDates.get(g).getOriginalAttenceDatas().size()-1).setStatus(4);
                                  }

                              }else {//没有迟到
                                  if(endDatas>sfLast){
                                      originalAttenceDates.get(g).getOriginalAttenceDatas().get(0).setStatus(4);//
                                      originalAttenceDates.get(g).getOriginalAttenceDatas().get(originalAttenceDates.get(g).getOriginalAttenceDatas().size()-1).setStatus(2);//早退
                                  }else {
                                      originalAttenceDates.get(g).getOriginalAttenceDatas().get(0).setStatus(4);//没有迟到
                                      originalAttenceDates.get(g).getOriginalAttenceDatas().get(originalAttenceDates.get(g).getOriginalAttenceDatas().size()-1).setStatus(4);//没有早退
                                  }
                              }

                          }



                      } catch (ParseException e) {
                          e.printStackTrace();
                      }


                      for(OriginalAttenceDatas datas:datasList){


                          String datas1 = datas.getDatas();
                          datass=datas1+"   "+datass;
                      }
                  }

                 originalAttenceDates.get(g).setDatas(datass);
              }

            Collections.sort(originalAttenceDates, new Comparator<OriginalAttenceDates>() {
                @Override
                public int compare(OriginalAttenceDates o1, OriginalAttenceDates o2) {
                    String dates = o1.getDates();
                    String dates1 = o2.getDates();
                    try {
                        long l = MyDateUtils.dateToStamplong(dates);
                        long l1 = MyDateUtils.dateToStamplong(dates1);
                        if(l-l1>0){
                            return 1;
                        }else if (l-l1<0){
                            return  -1;
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return 0;
                }

            });

        }

//        for(OriginalAttenceLogOut logOut:originalAttenceLog){
//            for(int y=0;y<logOut.getOriginalAttenceDates().size();y++){
//                if(logOut.getOriginalAttenceDates().get(y).getOriginalAttenceDatas().size()>0){
//
//                }
//
//            }
//        }
      //  List<ExecelOrgAttOut> execelOrgAttOut = eventLogMapper.getExecelOrgAttOut(staffAttencePageIn);
        return originalAttenceLog;


    }

//    @Override
//    public List<OriginalAttenceLogOut> getOriginalAttenceLogExecel(StaffAttencePageIn staffAttencePageIn) {
//        if(staffAttencePageIn.getDepartmentId() !=null && !"".equals(staffAttencePageIn.getDepartmentId())){
//            TDepartment tDepartment =new TDepartment();
//            tDepartment.setId(Long.parseLong(staffAttencePageIn.getDepartmentId()+""));
//            tDepartment.setEntityId(staffAttencePageIn.getEntityId());
//            TDepartment path = departmentMapper.getDepPathById(tDepartment);
//            staffAttencePageIn.setDepPath(path.getDepPath());
//        }
//
//        List<OriginalAttenceLogOut> originalAttenceLog = eventLogMapper.getOriginalAttenceLog(staffAttencePageIn);
//        List<String> daysBetwAnd = MyDateUtils.getDaysBetwAnd(staffAttencePageIn.getStartTime(), staffAttencePageIn.getEndTime());
//        for(String day:daysBetwAnd){
//            day.substring(0, 10)
//        }
//
//
//        return  nul''
//    }nul





    @Override
    public PageInfo<DepAttenceOut> getDepAttenceOut(StaffAttencePageIn staffAttencePageIn) {

        PageHelper.startPage(staffAttencePageIn.getCurrentPage(), staffAttencePageIn.getPageSize());

        List<DepAttenceOut> depAttenceOut = eventLogMapper.getDepAttenceOut(staffAttencePageIn);

        return  new PageInfo<>(depAttenceOut);
    }

    @Override
    public List<PgSmtlkDeviceEventLog> getOneStaffTimesLog(PgSmtlkDeviceEventLog log) {
        return eventLogMapper.getOneStaffTimesLog(log);
    }

    @Override
    public int deleteAddAttenceLog(PgSmtlkDeviceEventLog log) {
      return   eventLogMapper.deleteByPrimaryKey(log);

    }
}
