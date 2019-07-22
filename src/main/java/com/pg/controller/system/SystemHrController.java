package com.pg.controller.system;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.pg.base.ResultVo;
import com.pg.bean.Hr;
import com.pg.bean.Page;
import com.pg.bean.PgStaff;
import com.pg.bean.RespBean;
import com.pg.common.dto.HrDto;
import com.pg.common.dto.in.HrIn;
import com.pg.common.dto.in.HrPageIn;
import com.pg.common.dto.in.HridsIn;
import com.pg.service.HrService;
import com.pg.service.PgHrRoleService;
import com.pg.service.PgStaffService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by pg on 2018/1/2.
 */
@RestController
@RequestMapping("/system/hr")
@Slf4j
public class SystemHrController {
    private final Logger logger = LoggerFactory.getLogger(SystemHrController.class);

    @Autowired
    HrService hrService;
    @Autowired
    PgHrRoleService hrRoleService;


    //根据id查询用户ok
    @RequestMapping(value = "/id")
    public ResultVo getHrById(@RequestBody HrIn hrId) {
        ResultVo resultVo = new ResultVo();
        Integer id = hrId.getId();
        long l = Long.parseLong(id + "");
        resultVo.setData(hrService.getHrById(l));
        return resultVo;
    }

    //根据id 删除用户ok
    @RequestMapping(value = "/deleteByHrId")
    public RespBean deleteHr(@RequestBody HrIn hrId) {
        long l = Long.parseLong(hrId.getId() + "");
        if (hrService.deleteHr(l) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    //根据id 删除用户ok
    @RequestMapping(value = "/batchDeleteHr")
    public RespBean batchDeleteHr(@RequestBody HridsIn hrids) {
        if (  hrRoleService.deleteRole(hrids.getHrids())>=1&& hrService.batchDeleteHr(hrids.getHrids()) >= 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    //修改
    @RequestMapping(value = "/updateHr", method = RequestMethod.POST)
    public RespBean updateHr(@RequestBody HrIn hr) {
        logger.debug("编辑hr入参：" + hr);

        HrDto dto = new HrDto();
        BeanUtils.copyProperties(hr, dto);

        //修改 ok
        if (hrService.updateHr(dto) >= 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    //修改用户状态
    @RequestMapping(value = "/updateHrStatus", method = RequestMethod.POST)
    public RespBean updateHrStatus(@RequestBody HrIn hr) {
        HrDto dto = new HrDto();

        //BeanUtils.copyProperties(hr, dto);
        dto.setId(hr.getId());
        if (hr.isEnabled() == true) {
            dto.setEnabled(1);
        } else {
            dto.setEnabled(0);
        }
        //修改 ok
        if (hrService.updateHrStatues(dto) >= 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }


    //增加
    @RequestMapping(value = "/addHr")
    public RespBean addHr(@RequestBody HrIn hr) {

        String username = hr.getUsername();
        int i = hrService.hrReg(username, hr.getPassword());
        if(i==-1){
            return  RespBean.error("用户名重复");
        }
        HrDto dto = new HrDto();
        BeanUtils.copyProperties(hr, dto);
        if (hrService.addHr(dto) >= 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    /**
     * 修改用户角色
     *
     * @param hrId
     * @param rids
     * @return
     */
    @RequestMapping(value = "/roles", method = RequestMethod.PUT)
    public RespBean updateHrRoles(Long hrId, Long[] rids) {
        if (hrService.updateHrRoles(hrId, rids) == rids.length) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

   /* @RequestMapping("/{keywords}")
    public List<Hr> getHrsByKeywords(@PathVariable(required = false) String keywords) {
        List<Hr> hrs = hrService.getHrsByKeywords(keywords);
        for (Hr h:hrs) {
            System.out.println("用戶："+h.getName()+":"+h.getRoles().size());
        }
        System.out.println(new Gson().toJson(hrs));
        return hrs;
    }*/

    /**
     * 查询当前宾馆下的员工
     * @param pgStaff
     * @return
     */
    @RequestMapping(value = "/hrList", method = RequestMethod.POST)
    public ResultVo getHrsByKeywords(@RequestBody PgStaff pgStaff) {
        ResultVo resultVo = new ResultVo();
        //System.out.println("接口入参" + JSON.toJSON(page));
        PageInfo<PgStaff> staffs = hrService.getStaffsByKeywords(pgStaff);
        resultVo.setData(staffs);
        return resultVo;
    }

    @RequestMapping(value = "/userList", method = RequestMethod.POST)
    public ResultVo getHrsByKeywords(@RequestBody HrPageIn page) {
        ResultVo resultVo = new ResultVo();
        //System.out.println("接口入参" + JSON.toJSON(page));
        logger.debug("hrlist接口入参", JSON.toJSON(page));
        PageInfo<Hr> hrs = hrService.getHrsByKeywords(page);
        resultVo.setData(hrs);
        for (Hr h : hrs.getList()) {
            System.out.println("用戶：" + h.getName() + ":" + h.getRoles().size());
        }

        System.out.println(new Gson().toJson(hrs));
        return resultVo;
    }



     //hr分页====================
    @RequestMapping("/list")
    public ResultVo getHrList(@RequestBody Page page) {


        //List<Hr> list = pageInfo.getList();
        // System.out.println("结果集长度："+list.size());
        //page.setUrl("/system/hr/list");
        //map.put("url", "/system/hr/list");
       /* Map<String,Object> map =new HashMap<>();
        map.put("url", "/system/hr/list");
        map.put("pageInfo", pageInfo);*/
        PageInfo<Hr> pageInfo = hrService.getHrList(page);
        ResultVo resultVo = new ResultVo();
        resultVo.setData(pageInfo);
        return resultVo;
    }

    @RequestMapping(value = "/hr/reg", method = RequestMethod.POST)
    public RespBean hrReg(String username, String password) {
        int i = hrService.hrReg(username, password);

        if (i == 1) {
            return RespBean.ok("注册成功!");
        } else if (i == -1) {
            return RespBean.error("用户名重复，注册失败!");
        }

        return RespBean.error("注册失败!");
    }

}
