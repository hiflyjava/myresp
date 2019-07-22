package com.pg.service.impl;

import com.pg.bean.PgWorkTime;
import com.pg.mapper.PgWorkTimeMapper;
import com.pg.service.PgWorkTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: admin
 * @Date: 2019/7/4 11:10
 * @Description:
 */

@Service
@Transactional
public class PgWorkTimeServiceImpl implements PgWorkTimeService {

    @Autowired
    PgWorkTimeMapper workTimeMapper;

    @Override
    public List<PgWorkTime> getWorkTimeList() {
        return workTimeMapper.getWorkTimeList();
    }
}
