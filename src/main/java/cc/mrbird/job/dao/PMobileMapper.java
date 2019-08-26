package cc.mrbird.job.dao;


import cc.mrbird.job.domain.PMobile;

import java.util.List;

public interface PMobileMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PMobile record);

    int insertSelective(PMobile record);

    PMobile selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PMobile record);

    int updateByPrimaryKey(PMobile record);

    int  insertMobileForeach(List<PMobile> list);
}