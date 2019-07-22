package com.pg.mapper;

import com.pg.bean.Hr;
import com.pg.bean.Role;
import com.pg.common.dto.HrDto;
import com.pg.common.dto.in.HrIn;
import com.pg.common.dto.in.HrPageIn;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by sang on 2017/12/28.
 */
public interface HrMapper {
    Hr loadUserByUsername(String username);

    List<Role> getRolesByHrId(Long id);

    int hrReg(@Param("username") String username, @Param("password") String password);

    List<Hr> getHrsByKeywords(HrPageIn hrPageIn);

    int updateHr(HrDto hr);

    int deleteRoleByHrId(Long hrId);

    int addRolesForHr(@Param("hrId") Long hrId, @Param("rids") Long[] rids);

    Hr getHrById(Long hrId);

    int deleteHr(Long hrId);
    int addHr(HrDto hr);
    List<Hr> getAllHr(@Param("currentId") Long currentId);
    List<Hr> getHrList();
    int batchDeleteHr(Long[] array);
}
