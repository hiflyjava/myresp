package com.pg.common.dto.in;

/**
 * @Auther: admin
 * @Date: 2019/5/15 17:13
 * @Description:
 */
public class HotelIn {


    private String name;
    private Integer uid;
    private Long userId;
    private Integer eid;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
