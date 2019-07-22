package com.pg.controller.system;

import com.pg.base.ResultVo;
import com.pg.bean.Menu;
import com.pg.constant.BaseConstant;
import com.pg.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: admin
 * @Date: 2019/3/25 17:15
 * @Description:
 */

@RestController
    @RequestMapping(value = "/system/menu")
public class SystemMenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 新增菜单
     */
    @RequestMapping(value = "/addMenu")
    public ResultVo addMenu(@RequestBody Menu menu) {
        ResultVo resultVo = new ResultVo();
//        Map<String, Object> map = Maps.newHashMap();
//        map.put("name", menu.getName());
        //int flag = menuService.insertMenu(map);
        int flag=menuService.addMenu(menu);
        if (flag == 1) {
            resultVo.setCode(BaseConstant.E_000);//成功
        } else {
            resultVo.setCode(BaseConstant.E_001);//失败
        }
        return resultVo;
    }


    /**
     * 修改菜单
     */
    @RequestMapping(value = "/updateMenu")

    public ResultVo updateMenu(@RequestBody Menu menu) {
        ResultVo resultVo = new ResultVo();
        int flag = menuService.updateMenu(menu);
        if (flag == 1) {
            resultVo.setCode(BaseConstant.E_000);//成功
        } else {
            resultVo.setCode(BaseConstant.E_001);//失败
        }
        return resultVo;
    }


    /**
     * 删除菜单
     */

    @RequestMapping(value = "/delete")
    public ResultVo delete(@RequestBody Long id) {
        //menuService.delete

        return new ResultVo();
    }


    /**
     * 根据id查询菜单
     */
    @RequestMapping(value = "/getMenuById")
    public ResultVo getMenuById(@RequestBody Long id  ) {

        if (id == null || "".equals(id)) {
            //查询所有菜单
            id = 1L;
        } else {

        }
        List<Menu> menuList = menuService.getMenuById(id);
        ResultVo resultVo = new ResultVo();
        resultVo.setData(menuList);
        return resultVo;
    }

}
