package cc.mrbird.job.service;

import cc.mrbird.job.domain.PMobileSuccess;

public interface PMobileSuccessService {
    int deleteByPrimaryKey(Long id);

    int insert(PMobileSuccess record);

    int insertSelective(PMobileSuccess record);

    PMobileSuccess selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PMobileSuccess record);

    int updateByPrimaryKey(PMobileSuccess record);

}
