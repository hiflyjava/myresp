package com.pg.service;

import com.pg.bean.Menu;
import com.pg.bean.TMenu;
import com.pg.bean.Tree;
import com.pg.common.dto.in.HrIn;
import com.pg.common.dto.in.HrPageIn;
import com.pg.common.utils.HrUtils;
import com.pg.common.utils.TreeUtils;
import com.pg.mapper.MenuMapper;
import com.pg.mapper.TMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pg on 2017/12/28.
 */
@Service
@Transactional
//@CacheConfig(cacheNames = "menus_cache")
public class MenuService {
    @Autowired
    MenuMapper menuMapper;

    @Autowired
    TMenuMapper tMenuMapper;

    //    @Cacheable(key = "#root.methodName")
    public List<Menu> getAllMenu() {
        return menuMapper.getAllMenu();
    }

    public List<Menu> getMenusByHrId() {
       // List<Menu> munus = menuMapper.getMenusByHrId(HrUtils.getCurrentHr().getId());

        return menuMapper.getMenusByHrId(HrUtils.getCurrentHr().getId());
    }

    public List<Menu> getDifferLagMenusByHrId(HrIn hrIn) {
        // List<Menu> munus = menuMapper.getMenusByHrId(HrUtils.getCurrentHr().getId());
         hrIn.setHrId(HrUtils.getCurrentHr().getId());
        return menuMapper.getDifferLagMenusByHrId(hrIn);
    }

    //getMenusByHrIdTest

    public List<Tree<TMenu>> getTmenuByUid() {
        List<TMenu> menus = tMenuMapper.getTmenuByUid(HrUtils.getCurrentHr().getId());

        List<Tree<TMenu>> trees = new ArrayList<>();
        menus.forEach(menu -> {
            Tree<TMenu> tree = new Tree<>();
            tree.setId(menu.getId().toString());
            tree.setParentId(menu.getParentid().toString());
            tree.setName(menu.getName());
           // tree.setIcon(menu.getIcons());
            //tree.setUrl(menu.getUrl());
            tree.setPath(menu.getPath());
            tree.setComponent(menu.getComponent());
            trees.add(tree);
        });
        Tree<TMenu> tMenuTree = TreeUtils.build(trees);
        List<Tree<TMenu>> children = tMenuTree.getChildren();

        return children;

    }
    public List<Menu> menuTree() {
        return menuMapper.menuTree();
    }

    public int addMenu(Menu menu) {
        return menuMapper.addMenu(menu);
    }

    public int updateMenu(Menu menu) {
        return menuMapper.updateMenu(menu);
    }

    public List<Menu> getMenuById(Long id) {
        return menuMapper.getMenuById(id);
    }

    public List<Long> getMenusByRid(Long rid) {
        return menuMapper.getMenusByRid(rid);
    }
}
