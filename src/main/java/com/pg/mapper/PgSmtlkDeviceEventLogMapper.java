package com.pg.mapper;

import com.pg.bean.PgSmtlkDeviceEventLog;
import com.pg.bean.PgStaffAttence;
import com.pg.common.dto.in.PgAttenceOneDayIn;
import com.pg.common.dto.in.StaffAttencePageIn;
import com.pg.common.dto.out.DepAttenceOut;
import com.pg.common.dto.out.ExecelOrgAttOut;
import com.pg.common.dto.out.OriginalAttenceLogOut;
import com.pg.common.dto.out.StaffsManyDayAttenceOut;

import java.util.List;

public interface PgSmtlkDeviceEventLogMapper {
    int deleteByPrimaryKey(PgSmtlkDeviceEventLog record);

    int insert(PgSmtlkDeviceEventLog record);

    int insertSelective(PgSmtlkDeviceEventLog record);

    PgSmtlkDeviceEventLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PgSmtlkDeviceEventLog record);

    int updateByPrimaryKey(PgSmtlkDeviceEventLog record);

    List<PgSmtlkDeviceEventLog> getStaffAttenceByOneDay(PgAttenceOneDayIn oneDayIn);

    List<PgSmtlkDeviceEventLog>   getClockLogByDays(PgAttenceOneDayIn oneDayIn);

    List<PgSmtlkDeviceEventLog>   getClockTypeLogByToday(PgAttenceOneDayIn oneDayIn);
    StaffsManyDayAttenceOut getOneStaffAttenceByDays(StaffAttencePageIn staffAttencePageIn);
    List<OriginalAttenceLogOut> getOriginalAttenceLog(StaffAttencePageIn staffAttencePageIn);

    List<ExecelOrgAttOut> getExecelOrgAttOut(StaffAttencePageIn staffAttencePageIn);

    List<DepAttenceOut> getDepAttenceOut(StaffAttencePageIn staffAttencePageIn);

    List<PgSmtlkDeviceEventLog> getOneStaffTimesLog(PgSmtlkDeviceEventLog log);
}