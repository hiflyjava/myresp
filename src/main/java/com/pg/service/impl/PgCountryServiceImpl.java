package com.pg.service.impl;

import com.pg.bean.PgCountry;
import com.pg.mapper.PgCountryMapper;
import com.pg.service.PgCountryService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class PgCountryServiceImpl implements PgCountryService {

    @Autowired
    PgCountryMapper countryMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(PgCountry record) {
        return 0;
    }

    @Override
    public int insertSelective(PgCountry record) {
        for(int i=0;i<400;i++){
            PgCountry pgCountry =new PgCountry();
            pgCountry.setCode(i+"");
            countryMapper.insertSelective(pgCountry);

        }
        return 1;
    }

    @Override
    public PgCountry selectByPrimaryKey(Integer id) {
        return countryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PgCountry record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(PgCountry record) {
        return 0;
    }

    @Override
    public List<PgCountry> getCountrys(PgCountry pgCountry) {
        return countryMapper.getCountrys(pgCountry);
    }
}
