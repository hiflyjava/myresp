package com.pg.common.dto.out;

import java.util.List;
import java.util.Map;

/**
 * @Auther: admin
 * @Date: 2019/7/11 15:22
 * @Description:
 */
public class StaffsManyDayAttenceOut {

    private Long id;
    private String name;



    private String surname;

    private String startTime;

    private String endTime;

    private String addTime;
    private String  inDateTime;
    private String  inDateAttence;


    private List<TestAttenceOut> attenceOutList;

    private String dname;
    private String pname;
   private  String deviceNo;
   private  String  userNo;

   private Long  mmMinute;
    private Long  sxMinute;
    private String  mintimes ;
    private String  maxtimes;

    public String getInDateTime() {
        return inDateTime;
    }

    public void setInDateTime(String inDateTime) {
        this.inDateTime = inDateTime;
    }

    public String getInDateAttence() {
        return inDateAttence;
    }

    public void setInDateAttence(String inDateAttence) {
        this.inDateAttence = inDateAttence;
    }

    public List<TestAttenceOut> getAttenceOutList() {
        return attenceOutList;
    }

    public void setAttenceOutList(List<TestAttenceOut> attenceOutList) {
        this.attenceOutList = attenceOutList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMmMinute() {
        return mmMinute;
    }

    public void setMmMinute(Long mmMinute) {
        this.mmMinute = mmMinute;
    }

    public Long getSxMinute() {
        return sxMinute;
    }

    public void setSxMinute(Long sxMinute) {
        this.sxMinute = sxMinute;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
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

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }
}
