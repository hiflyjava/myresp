package com.pg.common.dto.out;

import com.pg.bean.PgStaffAttence;

import java.util.List;

/**
 * @Auther: admin
 * @Date: 2019/7/10 11:01
 * @Description:
 */
public class StaffOneDayAttenceOut {

    private Integer lateStaffs;
    private Integer earlyStaffs;
    private Integer addStaffs;
    private List<PgStaffAttence>  staffAttences;
    private Integer allStaffs;
    private Integer   arriveStaffs;
    private Integer  noArriveStaffs ;

    public Integer getLateStaffs() {
        return lateStaffs;
    }

    public void setLateStaffs(Integer lateStaffs) {
        this.lateStaffs = lateStaffs;
    }

    public Integer getEarlyStaffs() {
        return earlyStaffs;
    }

    public void setEarlyStaffs(Integer earlyStaffs) {
        this.earlyStaffs = earlyStaffs;
    }

    public Integer getAddStaffs() {
        return addStaffs;
    }

    public void setAddStaffs(Integer addStaffs) {
        this.addStaffs = addStaffs;
    }

    public List<PgStaffAttence> getStaffAttences() {
        return staffAttences;
    }

    public void setStaffAttences(List<PgStaffAttence> staffAttences) {
        this.staffAttences = staffAttences;
    }

    public Integer getAllStaffs() {
        return allStaffs;
    }

    public void setAllStaffs(Integer allStaffs) {
        this.allStaffs = allStaffs;
    }

    public Integer getArriveStaffs() {
        return arriveStaffs;
    }

    public void setArriveStaffs(Integer arriveStaffs) {
        this.arriveStaffs = arriveStaffs;
    }

    public Integer getNoArriveStaffs() {
        return noArriveStaffs;
    }

    public void setNoArriveStaffs(Integer noArriveStaffs) {
        this.noArriveStaffs = noArriveStaffs;
    }
}
