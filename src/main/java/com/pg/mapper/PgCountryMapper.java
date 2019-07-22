package com.pg.mapper;

import com.pg.bean.PgCountry;

import java.util.List;

public interface PgCountryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PgCountry record);

    int insertSelective(PgCountry record);

    PgCountry selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PgCountry record);

    int updateByPrimaryKey(PgCountry record);
    List<PgCountry> getCountrys(PgCountry pgCountry);
}