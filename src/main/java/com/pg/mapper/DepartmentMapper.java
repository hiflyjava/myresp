package com.pg.mapper;

import com.pg.bean.Department;
import com.pg.bean.TDepartment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by sang on 2018/1/7.
 */
public interface DepartmentMapper {
    void addDep(@Param("dep") Department department);

    Integer addDeps(TDepartment department);
    void deleteDep(@Param("dep") Department department);

    List<TDepartment> getDepByPid(Department department);
    List<TDepartment> getChildrenDep(TDepartment department);
    List<TDepartment> getParentDep(TDepartment department);



    List<Department> getAllDeps();

    Integer updateByPrimaryKeySelective(TDepartment tDepartment);

    TDepartment getDepPathById(TDepartment tDepartment);

}
