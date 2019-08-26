package cc.mrbird.job.service.impl;

import cc.mrbird.job.domain.PMobileSuccess;
import cc.mrbird.job.service.PMobileSuccessService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class PMobileSuccessServiceImpl implements PMobileSuccessService {
    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(PMobileSuccess record) {
        return 0;
    }

    @Override
    public int insertSelective(PMobileSuccess record) {
        return 0;
    }

    @Override
    public PMobileSuccess selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(PMobileSuccess record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(PMobileSuccess record) {
        return 0;
    }
}
