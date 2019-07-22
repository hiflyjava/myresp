package com.pg.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pg.bean.PgStaff;
import com.pg.common.utils.MyDateUtils;
import com.pg.mapper.PgStaffMapper;
import com.pg.service.PgStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Auther: admin
 * @Date: 2019/7/5 18:44
 * @Description:
 */

@Service
@Transactional
public class PgStaffServiceImpl  implements PgStaffService {

    @Autowired
    PgStaffMapper staffMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(PgStaff record) {
        return 0;
    }

    @Override
    public int insertSelective(PgStaff record)  {
        record.setEnabled(1);
        String jointime = record.getJointime();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//yyyy-mm-dd, 会出现时间不对, 因为小写的mm是代表: 秒
        Date utilDate = null;
        try {
            utilDate = sdf.parse(jointime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(utilDate);//查看utilDate的值
        Date date = new java.sql.Date(utilDate.getTime());
        record.setJoinDate(date);
        return staffMapper.insertSelective(record);
    }

    @Override
    public PgStaff selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(PgStaff record) {

        if(record.getJointime() !=null &&  !"".equals(record.getJointime())){
            String jointime = record.getJointime();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//yyyy-mm-dd, 会出现时间不对, 因为小写的mm是代表: 秒
            Date utilDate = null;
            try {
                utilDate = sdf.parse(jointime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println(utilDate);//查看utilDate的值
            Date date = new java.sql.Date(utilDate.getTime());
            record.setJoinDate(date);
        }

        return  staffMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PgStaff record) {
        return 0;
    }

    @Override
    public PageInfo<PgStaff> getStaffsByKeywords(PgStaff pgStaff) {

        PageHelper.startPage(pgStaff.getCurrentPage(), pgStaff.getPageSize());

        List<PgStaff> staffs = staffMapper.getStaffsByKeywords(pgStaff);

        return new PageInfo<>(staffs);
    }
}
