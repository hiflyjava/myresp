package com.pg.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pg.bean.*;
import com.pg.common.dto.HrDto;
import com.pg.common.dto.in.HotelIn;
import com.pg.common.dto.in.HrIn;
import com.pg.common.dto.in.HrPageIn;
import com.pg.common.utils.HrUtils;
import com.pg.mapper.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pg on 2017/12/28.
 */
@Service
@Transactional
public class HrService implements UserDetailsService {

    @Autowired
    HrMapper hrMapper;
    @Autowired
    HrRoleMapper hrRoleMapper;

    @Autowired
    PgHrEntityMapper hrEntityMapper;
    @Autowired
    PgshHotelEntityMapper hotelEntityMapper;

    @Autowired
    PgStaffMapper staffMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByUsername(s);
        List<PgshHotelEntity> pgshHotelEntities = hotelEntityMapper.selectHotelByUid(hr.getId());
        hr.setPgshHotelEntityList(pgshHotelEntities);
        if (hr == null) {
             throw new UsernameNotFoundException("用户名不对");
        }
        return hr;
    }

    public int hrReg(String username, String password) {
        //如果用户名存在，返回错误
        Hr hr = hrMapper.loadUserByUsername(username);
        //String password1 = hr.getPassword();
       // boolean equalsToMd5 = MD5utils.isEqualsToMd5(password1, password);
        if (hrMapper.loadUserByUsername(username) != null) {
            return -1;
        }
       /* BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode(password);*/
        return 1;
    }

      /* public List<Hr> getHrsByKeywords(String keywords) {
        // PageHelper.startPage(currentPage, pageSize);
        List<Hr> hrs = hrMapper.getHrsByKeywords(keywords);
        return hrs;
    }*/
    public PageInfo<PgStaff> getStaffsByKeywords(PgStaff pgStaff) {
         PageHelper.startPage(pgStaff.getCurrentPage(), pgStaff.getPageSize());

        List<PgStaff> staffs = staffMapper.getStaffsByKeywords(pgStaff);

        return new PageInfo<>(staffs);
    }



    public PageInfo<Hr> getHrsByKeywords(HrPageIn pageIn) {
        PageHelper.startPage(pageIn.getCurrentPage(), pageIn.getPageSize());

        List<Hr> hrs = hrMapper.getHrsByKeywords(pageIn);
        for (Hr hrss:hrs) {
            Long id = hrss.getId();
            Hr hrById = hrMapper.getHrById(id);
            hrss.setRoles(hrById.getRoles());
            List<PgshHotelEntity> entities =hotelEntityMapper.selectHotelByUid(id);
            if(entities !=null && entities.size()>=1){
                hrss.setPgshHotelEntityList(entities);
            }

        }
        return new PageInfo<>(hrs);
    }


    public int updateHr(HrDto hr) {

        if(hr.getPassword()!=null && !"".equals(hr.getPassword())){
           hr = encryptPassword(hr);
        }

        hrMapper.updateHr(hr);
        Long l = Long.parseLong((hr.getId() + ""));
        List<Long> rids = new ArrayList<>();
        List<Role> roles = hr.getRoles();
        List<PgshHotelEntity> eids = hr.getEids();
        List<Integer> eidss =new ArrayList<>();
        if(eids !=null && eids.size() !=0){
             for(PgshHotelEntity pgshHotelEntity :eids){
                 eidss.add(Integer.parseInt(pgshHotelEntity.getId()+""));
             }
            Integer[] eidsss = eidss.toArray(new Integer[rids.size()]);
             hrEntityMapper.deleteByPrimaryKey(hr.getId());
             hrEntityMapper.addEntitysForHr(hr.getId(),eidsss);
        }

        int j=0;
        if( roles !=null && roles.size()!=0){
             for (Role role2 : roles) {
                rids.add(role2.getId());
            }
            Long[] ridss = rids.toArray(new Long[rids.size()]);
            int i = hrMapper.deleteRoleByHrId(l);
            j = hrMapper.addRolesForHr(l, ridss);
        }else {
            return 0;
        }

        return j;
    }

    public  int updateHrStatues(HrDto hrDto){

        return   hrMapper.updateHr(hrDto);
    }

    private static HrDto encryptPassword(HrDto userInfo){
        String password = userInfo.getPassword();
        password = new BCryptPasswordEncoder().encode(password);
        userInfo.setPassword(password);
        return userInfo;
    }
    public int addHr(HrDto hr) {
        //
        HrDto hrDto = encryptPassword(hr);
        BeanUtils.copyProperties(hrDto, hr);
        int hr1 = hrMapper.addHr(hr);

        //新增用户的时候 同时新增宾馆跟用户关系维护
        List<PgshHotelEntity> eids = hr.getEids();

        if(eids.size()>=1){
            for(PgshHotelEntity pgshHotelEntity:eids){
                PgHrEntity pgHrEntity =new PgHrEntity();
                pgHrEntity.setHrId(hr.getId());
                pgHrEntity.setHotelEntityId(Integer.parseInt(pgshHotelEntity.getId()+""));
                hrEntityMapper.insertSelective(pgHrEntity);
            }
        }

        Long l = Long.parseLong((hr.getId() + ""));
        List<Long> rids = new ArrayList<>();
        List<Role> roles = hr.getRoles();
        int j;
        if(roles.size()!=0){
            for (Role role2 : roles) {
                rids.add(role2.getId());
            }
            Long[] ridss = rids.toArray(new Long[rids.size()]);
           // int i = hrMapper.deleteRoleByHrId(l);
           j = hrMapper.addRolesForHr(l, ridss);

        }else {
            return  0;
        }
        return j;
    }

    public int updateHrRoles(Long hrId, Long[] rids) {//这个方法是可以的

        /**
         * 修改用户的角色
         *  1.删除用户所有的角色
         *  2.循环新增角色
         */
        int i = hrMapper.deleteRoleByHrId(hrId);
        return hrMapper.addRolesForHr(hrId, rids);
    }


    public Hr getHrById(Long hrId) {
        Hr hr = hrMapper.getHrById(hrId);
        List<Role> rolesList= hrMapper.getRolesByHrId(hrId);

        hr.setRoles(rolesList);
        return hr;
    }

    public int deleteHr(Long hrId) {
        return hrMapper.deleteHr(hrId);
    }

    public List<Hr> getAllHrExceptAdmin() {
        return hrMapper.getAllHr(HrUtils.getCurrentHr().getId());
    }

    public List<Hr> getAllHr() {
        return hrMapper.getAllHr(null);
    }

    public PageInfo<Hr> getHrList(Page page) {

        PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
        List<Hr> hrList = hrMapper.getHrList();
//
        return new PageInfo<>(hrList);

    }

    public  int batchDeleteHr(Long [] hrids){

      return   hrMapper.batchDeleteHr(hrids);
    }
}
