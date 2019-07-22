package com.pg.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pg.bean.Page;
import com.pg.bean.Role;
import com.pg.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pg on 2018/1/1.
 */
@Service
@Transactional
public class RoleService {
    @Autowired
    RoleMapper roleMapper;

    public List<Role> roles() {
        return roleMapper.roles();
    }

    public int addNewRole(Role role) {
        String name = role.getName();
//        String[] names = name.split(",");
        String substring = name.substring(0, 5);
        if("ROLE_".equals(name.substring(0, 5))){
            return roleMapper.addNewRole(role);
        }
      return 0;
    }

    public int deleteRoleById(Long rid) {
        return roleMapper.deleteRoleById(rid);
    }

    public PageInfo<Role> getRoleList(Page page){

        PageHelper.startPage(page.getCurrentPage(),page.getPageSize());

        List<Role> roleList = roleMapper.getRoleList();
        return  new PageInfo<>(roleList);
    }

    public int updateRoleById(Role role){

        return  roleMapper.updateRoleById(role);
    }

    public Role getRoleById(Long id){

        return  roleMapper.getRoleById(id);
    }
}
