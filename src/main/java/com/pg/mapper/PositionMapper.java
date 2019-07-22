package com.pg.mapper;

import com.pg.bean.Position;
import com.pg.bean.TDepartment;

import java.util.List;

public interface PositionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);

    List<Position> getPositionListByEid(Position position);

    List<Position> getChildrenDepsPosition(TDepartment tDepartment);


}