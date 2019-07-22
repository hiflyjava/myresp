package com.pg.mapper;

import com.pg.bean.Menu;
import com.pg.common.dto.in.HrIn;

import java.util.List;

/**
 * Created by sang on 2017/12/28.
 */
public interface MenuMapper {
    List<Menu> getAllMenu();

    List<Menu> getMenusByHrId(Long hrId);

    List<Menu> getDifferLagMenusByHrId(HrIn hrIn);

    List<Menu> menuTree();

    List<Long> getMenusByRid(Long rid);

    int addMenu(Menu menu);

    int updateMenu(Menu menu);
    List<Menu> getMenuById(Long id);

    //List<Menu> getMenusByHrIdTest(Long id);
 }
