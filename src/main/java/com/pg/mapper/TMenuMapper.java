package com.pg.mapper;

import com.pg.bean.TMenu;

import java.util.List;

public interface TMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TMenu record);

    int insertSelective(TMenu record);

    TMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TMenu record);

    int updateByPrimaryKeyWithBLOBs(TMenu record);

    int updateByPrimaryKey(TMenu record);
    List<TMenu> getTmenuByUid(Long uid);
}