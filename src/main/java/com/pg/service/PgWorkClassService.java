package com.pg.service;

import com.pg.bean.PgWorkClass;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: admin
 * @Date: 2019/7/4 10:55
 * @Description:
 */

@Service
@Transactional
public interface PgWorkClassService {

    List<PgWorkClass> getWorkTimeList();

}
