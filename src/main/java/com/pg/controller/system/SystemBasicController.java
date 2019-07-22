package com.pg.controller.system;

import com.github.pagehelper.PageInfo;
import com.pg.base.ResultVo;
import com.pg.bean.*;
import com.pg.common.dto.in.MenuRoleIn;
import com.pg.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pg on 2017/12/29.
 */
@RestController
@RequestMapping("/system/basic")
public class SystemBasicController {
    @Autowired
    RoleService roleService;
    @Autowired
    MenuService menuService;
    @Autowired
    MenuRoleService menuRoleService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    PositionService positionService;
    @Autowired
    JobLevelService jobLevelService;

    /**
     * 删除role
     */

    @RequestMapping(value = "/deleteRoleById")
    public RespBean deleteRole(@RequestBody Role role) {
        if (roleService.deleteRoleById(role.getId()) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    /**
     * 添加角色
     */

    @RequestMapping(value = "/addRole", method = RequestMethod.POST)
    public RespBean addNewRole(@RequestBody Role role) {
        if (roleService.addNewRole(role) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    /**
     * 展示rolelist
     */

    @RequestMapping(value = "/getRoleList", method = RequestMethod.POST)
    public ResultVo getRoleList(@RequestBody Page page) {
        PageInfo<Role> pageInfo = roleService.getRoleList(page);
        /*Map<String, Object> map = new HashMap<>();
        map.put("pageInfo", roleList);
        map.put("url", "/system/basic/getRoleList");*/
        ResultVo resultVo =new ResultVo();
        resultVo.setData(pageInfo);
        return resultVo;
    }

    /**
     * 修改角色
     */

    @RequestMapping(value = "/updateRoleById", method = RequestMethod.POST)
    public RespBean updateRoleById(@RequestBody Role role) {
        if (roleService.updateRoleById(role) == 1) {
            return RespBean.ok("修改成功!");
        }
        return RespBean.error("修改失败!");
    }

    /**
     * 根据id 查询roel
     */
    @RequestMapping(value = "/getRoleById", method = RequestMethod.POST)
    public ResultVo getRoleById(@RequestBody Role role) {
        ResultVo resultVo = new ResultVo();
        Role role1 = roleService.getRoleById(role.getId());
        resultVo.setData(role1);
        return resultVo;

    }

    /**
     * 查询一级 二级菜单
     * 查询某个角色的 菜单ids
     * @param
     * @return
     */
    @RequestMapping(value = "/menuTree")
    public Map<String, Object> menuTree(@RequestBody Role role) {
        Map<String, Object> map = new HashMap<>();
        List<Menu> menus = menuService.menuTree();
        map.put("menus", menus);
        List<Long> selMids = menuService.getMenusByRid(role.getId());
        map.put("mids", selMids);
        return map;
    }

    /**
     * 修改角色菜单
     * @param rid
     * @param mids
     * @return
     */
    @RequestMapping(value = "/updateMenuRole", method = RequestMethod.PUT)
    public RespBean updateMenuRole(Long rid, Long[] mids) {
        if (menuRoleService.updateMenuRole(rid, mids) == mids.length) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    /**
     * 修改角色菜单
     * @param
     * @param
     * @return
     */
    @RequestMapping(value = "/updateMenuRole1")
    public RespBean updateMenuRole1(@RequestBody MenuRoleIn menuRoleIn) {

        List<Long> mids = menuRoleIn.getMids();
        Long[] midss = mids.toArray(new Long[mids.size()]);
        if (menuRoleService.updateMenuRole(menuRoleIn.getRid(), midss) == midss.length) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @RequestMapping("/roles")
    public List<Role> allRoles() {
        return roleService.roles();
    }

    @RequestMapping(value = "/dep", method = RequestMethod.POST)
    public Map<String, Object> addDep(Department department) {
        Map<String, Object> map = new HashMap<>();
        if (departmentService.addDep(department) == 1) {
            map.put("status", "success");
            map.put("msg", department);
            return map;
        }
        map.put("status", "error");
        map.put("msg", "添加失败!");
        return map;
    }

    @RequestMapping(value = "/dep/{did}", method = RequestMethod.DELETE)
    public RespBean deleteDep(@PathVariable Long did) {
        if (departmentService.deleteDep(did) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    /**
     * 得到 当前公司的部门树
     * @param department
     * @return
     */

    @RequestMapping(value = "/depTrees")
    public RespBean getDepByPid(@RequestBody Department department) {
        if(department.getEntityId() ==null || "".equals(department.getEntityId())){
            return  RespBean.error("please take officeId");

        }else {
            List<Tree<TDepartment>> depByUid = departmentService.getDepByUid(department);
            return  RespBean.ok("detTrees", depByUid);
        }

    }



    @RequestMapping(value = "/joblevel", method = RequestMethod.POST)
    public RespBean addJobLevel(JobLevel jobLevel) {
        int result = jobLevelService.addJobLevel(jobLevel);
        if (result == 1) {
            return RespBean.ok("添加成功!");
        } else if (result == -1) {
            return RespBean.error("职称名重复，添加失败!");
        }
        return RespBean.error("添加失败!");
    }

    @RequestMapping(value = "/joblevels", method = RequestMethod.GET)
    public List<JobLevel> getAllJobLevels() {
        return jobLevelService.getAllJobLevels();
    }

    @RequestMapping(value = "/joblevel/{ids}", method = RequestMethod.DELETE)
    public RespBean deleteJobLevelById(@PathVariable String ids) {
        if (jobLevelService.deleteJobLevelById(ids)) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @RequestMapping(value = "/joblevel", method = RequestMethod.PUT)
    public RespBean updateJobLevel(JobLevel jobLevel) {
        if (jobLevelService.updateJobLevel(jobLevel) == 1) {
            return RespBean.ok("修改成功!");
        }
        return RespBean.error("修改失败!");
    }

    @RequestMapping(value = "/menuTree2/{rid}", method = RequestMethod.DELETE)
    public Gson menuTree2(@PathVariable Long rid) {
        Map<String, Object> map = new HashMap<>();
        List<Menu> menus = menuService.menuTree();
        map.put("menus", menus);
        List<Long> selMids = menuService.getMenusByRid(rid);
        map.put("mids", selMids);
        Gson json = new Gson();
        json.toJson(map);
        return json;
    }

    @RequestMapping("/getPositionListByEid")
    public RespBean getPositionListByEid(@RequestBody Position position){
         if(position.getEntityId() ==null || "".equals(position.getEntityId())){
             return  RespBean.error("please take enetityId");
         }else {
             List<Position> listByEid = positionService.getPositionListByEid(position);
             return  RespBean.ok("positionList", listByEid);

         }
    }

    /**
     * 添加部门
     * @param department
     * @return
     */
    @RequestMapping("/addDepartment")
    public RespBean addDepartment(@RequestBody TDepartment department){
        if(department.getEntityId() ==null || "".equals(department.getEntityId())){
            return  RespBean.error("please take enetityId");
        }else {
            int i = departmentService.addDeps(department);
            if(i==1){
                return  RespBean.ok("add success",i );
            }else {
                return  RespBean.error("add failed");
            }

        }
    }


    @RequestMapping("/updateDepartment")
    public RespBean updateByPrimaryKeySelective(@RequestBody TDepartment department){
        if(department.getEntityId() ==null || "".equals(department.getEntityId())){
            return  RespBean.error("please take enetityId");
        }else {
            int i = departmentService.updateByPrimaryKeySelective(department);

            if(i==1){
                return  RespBean.ok("update success",i );
            }else {
                return  RespBean.error("update failed");
            }


        }
    }

    @RequestMapping("/addPosition")
    public RespBean addPosition(@RequestBody Position position){
        if(position.getEntityId() ==null || "".equals(position.getEntityId())){
            return  RespBean.error("please take enetityId");
        }else {
            int i = positionService.addPosition(position);
            if(i==1){
                return  RespBean.ok("add success",i );
            }else {
                return  RespBean.error("add failed");
            }

        }
    }

    @RequestMapping("/updatePosition")
    public RespBean updatePosition(@RequestBody Position position){
        if(position.getId() ==null || "".equals(position.getId())){
            return  RespBean.error("please take id");
        }else {
            int i = positionService.updatePosition(position);
            if(i==1){
                return  RespBean.ok("update success",i );
            }else {
                return  RespBean.error("update failed");
            }


        }
    }

    @RequestMapping("/getChildrenDep")
    public RespBean updatePosition(@RequestBody TDepartment tDepartment){
        if(tDepartment.getEntityId() ==null || "".equals(tDepartment.getEntityId())){
            return  RespBean.error("please take entityId");
        }else {
            List<TDepartment> childrenDep = departmentService.getChildrenDep(tDepartment);

             return  RespBean.ok("childrenDep", childrenDep);
        }
    }


    @RequestMapping("/getChildrenDepsPosition")
    public RespBean getChildrenDepsPosition(@RequestBody TDepartment tDepartment){
        if(tDepartment.getEntityId() ==null || "".equals(tDepartment.getEntityId())){
            return  RespBean.error("please take entityId");
        }else {
            List<Position> childrenDepsPosition = positionService.getChildrenDepsPosition(tDepartment);

            return  RespBean.ok("childrenDepsPosition", childrenDepsPosition);
        }
    }

}
