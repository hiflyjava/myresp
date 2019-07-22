package com.pg.controller;

import com.pg.bean.Hr;
import com.pg.bean.Menu;
import com.pg.common.dto.in.HrIn;
import com.pg.common.utils.HrUtils;
import com.pg.service.MenuService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 这是一个只要登录就能访问的Controller
 * 主要用来获取一些配置信息
 */
@RestController
@RequestMapping("/config")
public class ConfigController {
    //private static  final Logger logger = LoggerFactory.getLogger(ConfigController.class);

    @Autowired
    MenuService menuService;
    @Autowired
    HttpServletRequest request;

    @RequestMapping("/sysmenu")
    public List<Menu> sysmenu(@RequestBody HrIn hrIn) {
       // logger.info("sessionOutTime sessionOutTime-> ={}", request.getSession().getMaxInactiveInterval());
        if(hrIn.getLgType() ==null || "".equals(hrIn.getLgType())){
            hrIn.setLgType(2);
        }
        List<Menu> menus = menuService.getDifferLagMenusByHrId(hrIn);
        System.out.println("zzzzz==>"+menus);
        return menus;
    }

    @RequestMapping("/hr")
    public Hr currentUser() {
        return HrUtils.getCurrentHr();
    }
}
