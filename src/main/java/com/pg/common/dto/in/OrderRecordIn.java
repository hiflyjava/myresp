package com.pg.common.dto.in;

import java.util.Date;

/**
 * @Auther: admin
 * @Date: 2019/4/29 11:18
 * @Description:
 */
public class OrderRecordIn  {


    private String startTime;

    private String endTime;

    private Integer orderType;

    private Integer uid;
    private Integer eid;//宾馆id

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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }
}
