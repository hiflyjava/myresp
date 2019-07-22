package com.pg.common.dto.in;

/**
 * @Auther: admin
 * @Date: 2019/5/13 10:47
 * @Description:
 */
public class RoomListIn {

    private Integer rid;  //房间id
    private Integer uid;//用户id
    private Integer eid; //宾馆id

    //查询条件
    private Integer pageSize=20;
    private Integer currentPage=1;
    private String startTime;
    private String endTime;
    private String status;
    private String remark;
   private Integer type;
   private Integer todayStatus;//1是今天的状态 0是其它日期的状态

    private String roomNbr;

    public String getRoomNbr() {
        return roomNbr;
    }

    public void setRoomNbr(String roomNbr) {
        this.roomNbr = roomNbr;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getTodayStatus() {
        return todayStatus;
    }

    public void setTodayStatus(Integer todayStatus) {
        this.todayStatus = todayStatus;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    private String building;

    private Short floor;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public Short getFloor() {
        return floor;
    }

    public void setFloor(Short floor) {
        this.floor = floor;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }
}
