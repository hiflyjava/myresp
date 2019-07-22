package com.pg.service;

import com.github.pagehelper.PageInfo;
import com.pg.bean.PgSmtlkDeviceEventLog;
import com.pg.bean.PgStaff;
import com.pg.bean.PgStaffAttence;
import com.pg.common.dto.in.PgAttenceOneDayIn;
import com.pg.common.dto.in.StaffAttencePageIn;
import com.pg.common.dto.out.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: admin
 * @Date: 2019/7/9 11:34
 * @Description:
 */

@Service
@Transactional
public interface PgStaffAttenceService {

    int deleteByPrimaryKey(Long id);

    int insert(PgSmtlkDeviceEventLog record);

    int insertSelective(PgSmtlkDeviceEventLog record);

    PgSmtlkDeviceEventLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PgSmtlkDeviceEventLog record);

    int updateByPrimaryKey(PgSmtlkDeviceEventLog record);

    StaffOneDayAttenceOut getStaffAttenceByOneDay(PgAttenceOneDayIn oneDayIn);
    StaffDaysAttenceOut getStaffAttenceByDays(PgAttenceOneDayIn oneDayIn);

   PageInfo<PgSmtlkDeviceEventLog> getClockLogByDays(PgAttenceOneDayIn oneDayIn);

    PageInfo<PgSmtlkDeviceEventLog>  getClockTypeLogByToday(PgAttenceOneDayIn oneDayIn);

    PageInfo<StaffsManyDayAttenceOut>  getStaffsByDid(StaffAttencePageIn staffAttencePageIn);

    PageInfo<StaffsManyDayAttenceOut>  getStaffsByDidTest(StaffAttencePageIn staffAttencePageIn);


    List<StaffsManyDayAttenceOut>  getStaffsByDidTestForExecel(StaffAttencePageIn staffAttencePageIn);

    List<TestAttenceOut>  getOneStaffByDidTest(StaffAttencePageIn staffAttencePageIn);


    List<OriginalAttenceLogOut> getOriginalAttenceLog(StaffAttencePageIn staffAttencePageIn);



    List<OriginalAttenceLogOut> getExecelOrgAttOut(StaffAttencePageIn staffAttencePageIn);

    PageInfo<DepAttenceOut> getDepAttenceOut(StaffAttencePageIn staffAttencePageIn);


    List<PgSmtlkDeviceEventLog> getOneStaffTimesLog(PgSmtlkDeviceEventLog log);

    int deleteAddAttenceLog(PgSmtlkDeviceEventLog log);

}
