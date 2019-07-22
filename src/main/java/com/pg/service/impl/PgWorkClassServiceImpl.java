package com.pg.service.impl;

import com.pg.bean.PgWorkClass;
import com.pg.mapper.PgWorkClassMapper;
import com.pg.service.PgWorkClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: admin
 * @Date: 2019/7/4 10:58
 * @Description:
 */


@Service
@Transactional
public class PgWorkClassServiceImpl implements PgWorkClassService {

    @Autowired
    PgWorkClassMapper workClassMapper;

    @Override
    public List<PgWorkClass> getWorkTimeList() {
        return  workClassMapper.getWorkTimeList();
    }
}
