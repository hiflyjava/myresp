package com.pg.mapper;

import com.pg.bean.Role;

import java.util.List;

/**
 * Created by pg on 2018/1/1.
 */
public interface RoleMapper {
    List<Role> roles();

    int addNewRole(Role role);

    int deleteRoleById(Long rid);

    List<Role> getRoleList();

    int updateRoleById(Role role);

    Role getRoleById(long id);
}
