package com.pg.common.dto.in;

import java.util.Date;

/**
 * @Auther: admin
 * @Date: 2019/4/28 15:59
 * @Description:
 */
public class LockPasswordIn {

    private Integer lockpd; //1-在线密码 2-离线密码

    private Integer pdType; //1.一次性密码 2.重复使用密码

    private String startTime; // 生效时间

    private String endTime; //失效时间

    private String deviceId;//锁id

    private Integer roomId;

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
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

    public Integer getLockpd() {
        return lockpd;
    }

    public void setLockpd(Integer lockpd) {
        this.lockpd = lockpd;
    }

    public Integer getPdType() {
        return pdType;
    }

    public void setPdType(Integer pdType) {
        this.pdType = pdType;
    }


}
