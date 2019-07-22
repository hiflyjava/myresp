package com.pg.mapper;

import com.pg.bean.Hr;
import com.pg.bean.PgStaff;
import com.pg.common.dto.in.HrPageIn;
import com.pg.common.dto.in.StaffAttencePageIn;
import com.pg.common.dto.out.StaffsManyDayAttenceOut;

import java.util.List;

public interface PgStaffMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PgStaff record);

    int insertSelective(PgStaff record);

    PgStaff selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PgStaff record);

    int updateByPrimaryKey(PgStaff record);

    List<PgStaff> getStaffsByKeywords(PgStaff pgStaff);
    List<PgStaff> getStaffsByEid(Integer entityId);
    List<StaffsManyDayAttenceOut> getStaffsByDid(StaffAttencePageIn staffAttencePageIn);
}