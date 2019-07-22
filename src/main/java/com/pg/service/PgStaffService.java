package com.pg.service;

import com.github.pagehelper.PageInfo;
import com.pg.bean.PgStaff;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;

/**
 * @Auther: admin
 * @Date: 2019/7/5 18:43
 * @Description:
 */

@Service
@Transactional
public interface PgStaffService {


    int deleteByPrimaryKey(Integer id);

    int insert(PgStaff record);

    int insertSelective(PgStaff record) throws ParseException;

    PgStaff selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PgStaff record);

    int updateByPrimaryKey(PgStaff record);

    PageInfo<PgStaff> getStaffsByKeywords(PgStaff pgStaff);
}
