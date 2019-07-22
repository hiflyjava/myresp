package com.pg.controller;


import com.pg.bean.TMenu;
import com.pg.bean.Tree;

import com.pg.service.MenuService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: admin
 * @Date: 2019/4/28 14:05
 * @Description:
 */

@RestController
public class TestController {

    private static  final Logger logger = LoggerFactory.getLogger(ConfigController.class);

    @Autowired
    MenuService menuService;

    @RequestMapping("/sysmenus")
    public List<Tree<TMenu>>  sysmenu() {

       return menuService.getTmenuByUid();


    }



}
