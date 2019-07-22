package com.pg.common.dto.out;

/**
 * @Auther: admin
 * @Date: 2019/7/10 11:01
 * @Description:
 */
public class StaffDaysAttenceOut {

    private Integer allStaffs;
    private   Integer arriveStaffsCount;//这段时间总共打卡的人数
    private   Integer noArriveStaffsCount;//这段时间没有打卡的人数
    private  Integer lateStaffsCount;//这段时间迟到的人数
    private  Integer earlyStaffsCount;//这段时间早退的人数
    private  Integer addStaffsCount;//这段时间加班的人数

    public Integer getAllStaffs() {
        return allStaffs;
    }

    public void setAllStaffs(Integer allStaffs) {
        this.allStaffs = allStaffs;
    }

    public Integer getArriveStaffsCount() {
        return arriveStaffsCount;
    }

    public void setArriveStaffsCount(Integer arriveStaffsCount) {
        this.arriveStaffsCount = arriveStaffsCount;
    }

    public Integer getNoArriveStaffsCount() {
        return noArriveStaffsCount;
    }

    public void setNoArriveStaffsCount(Integer noArriveStaffsCount) {
        this.noArriveStaffsCount = noArriveStaffsCount;
    }

    public Integer getLateStaffsCount() {
        return lateStaffsCount;
    }

    public void setLateStaffsCount(Integer lateStaffsCount) {
        this.lateStaffsCount = lateStaffsCount;
    }

    public Integer getEarlyStaffsCount() {
        return earlyStaffsCount;
    }

    public void setEarlyStaffsCount(Integer earlyStaffsCount) {
        this.earlyStaffsCount = earlyStaffsCount;
    }

    public Integer getAddStaffsCount() {
        return addStaffsCount;
    }

    public void setAddStaffsCount(Integer addStaffsCount) {
        this.addStaffsCount = addStaffsCount;
    }
}
