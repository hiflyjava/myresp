package com.pg.bean;

import java.util.Date;

public class PgSmtlkDevice {
    private Long id;

    private Long userId;

    private String userAcct;

    private String deviceId;

    private String masterCode;

    private String hostCode;

    private String name;

    private String model;

    private String fwVersion;

    private Short currentVerNum;

    private String timeZone;

    private String status;

    private String inactive;

    private Date createdDate;

    private Date updatedDate;

    private Date lastSynDate;

    private Date lastQueryDate;

    private Short queryCnt;

    private String hubId;

    private String macAddr;

    private String sharedAdmin;

    private Short autoLock;

    private String audio;

    private String pinCrazy;

    private String serialNum;

    private String salesChannel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public String getMasterCode() {
        return masterCode;
    }

    public void setMasterCode(String masterCode) {
        this.masterCode = masterCode == null ? null : masterCode.trim();
    }

    public String getHostCode() {
        return hostCode;
    }

    public void setHostCode(String hostCode) {
        this.hostCode = hostCode == null ? null : hostCode.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getFwVersion() {
        return fwVersion;
    }

    public void setFwVersion(String fwVersion) {
        this.fwVersion = fwVersion == null ? null : fwVersion.trim();
    }

    public Short getCurrentVerNum() {
        return currentVerNum;
    }

    public void setCurrentVerNum(Short currentVerNum) {
        this.currentVerNum = currentVerNum;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone == null ? null : timeZone.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getInactive() {
        return inactive;
    }

    public void setInactive(String inactive) {
        this.inactive = inactive == null ? null : inactive.trim();
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

    public Date getLastSynDate() {
        return lastSynDate;
    }

    public void setLastSynDate(Date lastSynDate) {
        this.lastSynDate = lastSynDate;
    }

    public Date getLastQueryDate() {
        return lastQueryDate;
    }

    public void setLastQueryDate(Date lastQueryDate) {
        this.lastQueryDate = lastQueryDate;
    }

    public Short getQueryCnt() {
        return queryCnt;
    }

    public void setQueryCnt(Short queryCnt) {
        this.queryCnt = queryCnt;
    }

    public String getHubId() {
        return hubId;
    }

    public void setHubId(String hubId) {
        this.hubId = hubId == null ? null : hubId.trim();
    }

    public String getMacAddr() {
        return macAddr;
    }

    public void setMacAddr(String macAddr) {
        this.macAddr = macAddr == null ? null : macAddr.trim();
    }

    public String getSharedAdmin() {
        return sharedAdmin;
    }

    public void setSharedAdmin(String sharedAdmin) {
        this.sharedAdmin = sharedAdmin == null ? null : sharedAdmin.trim();
    }

    public Short getAutoLock() {
        return autoLock;
    }

    public void setAutoLock(Short autoLock) {
        this.autoLock = autoLock;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio == null ? null : audio.trim();
    }

    public String getPinCrazy() {
        return pinCrazy;
    }

    public void setPinCrazy(String pinCrazy) {
        this.pinCrazy = pinCrazy == null ? null : pinCrazy.trim();
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum == null ? null : serialNum.trim();
    }

    public String getSalesChannel() {
        return salesChannel;
    }

    public void setSalesChannel(String salesChannel) {
        this.salesChannel = salesChannel == null ? null : salesChannel.trim();
    }
}