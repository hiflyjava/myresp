package com.pg.service;

import com.pg.mapper.MenuRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by pg on 2018/1/2.
 */
@Service
@Transactional
public class MenuRoleService {
    @Autowired
    MenuRoleMapper menuRoleMapper;

    /**
     * 根据角色id 删除菜单
     * 添加菜单
     * @param rid
     * @param mids
     * @return
     */
    public int updateMenuRole(Long rid, Long[] mids) {

        menuRoleMapper.deleteMenuByRid(rid);
        if (mids.length == 0) {
            return 0;
        }
        return menuRoleMapper.addMenu(rid, mids);
    }
}
