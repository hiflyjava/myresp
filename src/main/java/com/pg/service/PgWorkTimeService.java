package com.pg.service;

import com.pg.bean.PgWorkClass;
import com.pg.bean.PgWorkTime;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: admin
 * @Date: 2019/7/4 11:09
 * @Description:
 */
@Service
@Transactional
public interface PgWorkTimeService {

    List<PgWorkTime> getWorkTimeList();
}
