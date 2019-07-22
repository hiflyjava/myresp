package com.pg.service;

import com.pg.bean.PgCountry;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: admin
 * @Date: 2019/6/11 11:47
 * @Description:
 */

@Service
@Transactional
public interface PgCountryService {

    int deleteByPrimaryKey(Integer id);

    int insert(PgCountry record);

    int insertSelective(PgCountry record);

    PgCountry selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PgCountry record);

    int updateByPrimaryKey(PgCountry record);

    List<PgCountry> getCountrys(PgCountry pgCountry);
}
