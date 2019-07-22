package com.pg.bean;

import java.util.Date;

public class PgSmtlkDeviceEventLog {
    private Long id;

    private String deviceId;

    private Long userId;

    private String userAcct;

    private Date time;

    private String eventCode;

    private Integer pwdId;

    private Integer eventId;

    private String name;

    private String status;

    private Date createdDate;

    private Date updatedDate;

    private Date  mintime;//第一次打卡时间

    private Long  lateMinute;//迟到多久

    private  Date maxtime;//最后一次打卡时间
    private Long  earlyMinute;//早退多少分钟

    private Long  addMinute;//加班多少分钟

    private String  addTime;
    private String  endTime;
    private String  startTime;

    private Long sxMinute;
    private Long mmMinute;

    private String mintimes;
    private String maxtimes;

    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getMintimes() {
        return mintimes;
    }

    public void setMintimes(String mintimes) {
        this.mintimes = mintimes;
    }

    public String getMaxtimes() {
        return maxtimes;
    }

    public void setMaxtimes(String maxtimes) {
        this.maxtimes = maxtimes;
    }

    public Long getSxMinute() {
        return sxMinute;
    }

    public void setSxMinute(Long sxMinute) {
        this.sxMinute = sxMinute;
    }

    public Long getMmMinute() {
        return mmMinute;
    }

    public void setMmMinute(Long mmMinute) {
        this.mmMinute = mmMinute;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Date getMaxtime() {
        return maxtime;
    }

    public void setMaxtime(Date maxtime) {
        this.maxtime = maxtime;
    }

    public Long getEarlyMinute() {
        return earlyMinute;
    }

    public void setEarlyMinute(Long earlyMinute) {
        this.earlyMinute = earlyMinute;
    }

    public Long getAddMinute() {
        return addMinute;
    }

    public void setAddMinute(Long addMinute) {
        this.addMinute = addMinute;
    }

    public Date getMintime() {
        return mintime;
    }

    public void setMintime(Date mintime) {
        this.mintime = mintime;
    }

    public Long getLateMinute() {
        return lateMinute;
    }

    public void setLateMinute(Long lateMinute) {
        this.lateMinute = lateMinute;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserAcct() {
        return userAcct;
    }

    public void setUserAcct(String userAcct) {
        this.userAcct = userAcct == null ? null : userAcct.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode == null ? null : eventCode.trim();
    }

    public Integer getPwdId() {
        return pwdId;
    }

    public void setPwdId(Integer pwdId) {
        this.pwdId = pwdId;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}