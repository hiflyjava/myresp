package cc.mrbird.job.service;

import cc.mrbird.common.util.RespBean;
import cc.mrbird.job.domain.PMobile;
import cc.mrbird.system.domain.User;

import java.io.IOException;
import java.util.List;

public interface PMobileService {


    int deleteByPrimaryKey(Long id);

    int insert(PMobile record);

    int insertSelective(PMobile record);

    PMobile selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PMobile record);

    int updateByPrimaryKey(PMobile record);

    RespBean insertMobileForeach(List<String> list,String content) throws Exception;

    String getBalanceSms() throws IOException;

}
