package com.pg.common.dto.out;

import java.util.List;

/**
 * @Auther: admin
 * @Date: 2019/7/15 11:09
 * @Description:
 */
public class OriginalAttenceLogOut {


    private String staffName;

    private Long  staffId;

    private String dname;

    private String staffNo;

    private String pname;

    private String deviceNo;

    private  String staffSurname;

    private String endTime;

    private String  startTime;

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

    // private String dates;

//    public String getDates() {
//        return dates;
//    }
//
//    public void setDates(String dates) {
//        this.dates = dates;
//    }

    private List<OriginalAttenceDates> originalAttenceDates;

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public String getStaffSurname() {
        return staffSurname;
    }

    public void setStaffSurname(String staffSurname) {
        this.staffSurname = staffSurname;
    }

    public List<OriginalAttenceDates> getOriginalAttenceDates() {
        return originalAttenceDates;
    }

    public void setOriginalAttenceDates(List<OriginalAttenceDates> originalAttenceDates) {
        this.originalAttenceDates = originalAttenceDates;
    }
}
