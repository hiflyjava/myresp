package com.pg.common.dto.out;

/**
 * @Auther: admin
 * @Date: 2019/7/15 18:06
 * @Description:
 */
public class DepAttenceOut {



    private Integer  staffCount;//员工总数

    private Integer  staffCheckCount;//员工打卡总人数

    private String   name;

    private Long  id;

    private Integer entityId;

    public Integer getStaffCount() {
        return staffCount;
    }

    public void setStaffCount(Integer staffCount) {
        this.staffCount = staffCount;
    }

    public Integer getStaffCheckCount() {
        return staffCheckCount;
    }

    public void setStaffCheckCount(Integer staffCheckCount) {
        this.staffCheckCount = staffCheckCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }
}
