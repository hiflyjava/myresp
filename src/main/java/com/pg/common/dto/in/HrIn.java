package com.pg.common.dto.in;

import com.pg.bean.PgshHotelEntity;
import lombok.Data;
import com.pg.bean.Role;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Auther: admin
 * @Date: 2019/3/29 13:08
 * @Description:  编辑用户入参Dto
 */
@Data
public class HrIn implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * hrID
     */
    private Integer id;
    /**
     * 名字
     */
    private String name;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 姓
     */
    private String surname;
    /**
     * 联系地址
     */
    private String address;
    /**
     * 宾馆id
     *
     */

    private Long hrId;
    private Integer lgType;

    public Long getHrId() {
        return hrId;
    }

    public void setHrId(Long hrId) {
        this.hrId = hrId;
    }

    public Integer getLgType() {
        return lgType;
    }

    public void setLgType(Integer lgType) {
        this.lgType = lgType;
    }

    private Integer eid;//宾馆id
      private List<PgshHotelEntity> eids;

    public List<PgshHotelEntity> getEids() {
        return eids;
    }

    public void setEids(List<PgshHotelEntity> eids) {
        this.eids = eids;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    private String username;
    private String password;


    private Integer departmentId;

    private Integer positionId;

    private Integer sex;

    private String country;

    private Integer entityId;

    private Integer timeId;

    private String unlockPassword;

    private Date joinTime;//入职时间

    private Integer extend2;

    private String userNo;

    private String extend3;

    private Integer extend4;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public Integer getTimeId() {
        return timeId;
    }

    public void setTimeId(Integer timeId) {
        this.timeId = timeId;
    }

    public String getUnlockPassword() {
        return unlockPassword;
    }

    public void setUnlockPassword(String unlockPassword) {
        this.unlockPassword = unlockPassword;
    }


    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public Integer getExtend2() {
        return extend2;
    }

    public void setExtend2(Integer extend2) {
        this.extend2 = extend2;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getExtend3() {
        return extend3;
    }

    public void setExtend3(String extend3) {
        this.extend3 = extend3;
    }

    public Integer getExtend4() {
        return extend4;
    }

    public void setExtend4(Integer extend4) {
        this.extend4 = extend4;
    }
    /* private  Long[] hrids;

    *//**
     * 批量删除的用户id
     * @return
     *//*
   public Long[] getHrids() {
        return hrids;
    }

    public void setHrids(Long[] hrids) {
        this.hrids = hrids;
    }*/


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRemark() {
        return remark;
    }

    public void setRemark(Integer remark) {
        this.remark = remark;
    }

    /**
     * 用户类型
     */
     private Integer remark;
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * 角色集合
     */

    private boolean enabled;
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
    
}
