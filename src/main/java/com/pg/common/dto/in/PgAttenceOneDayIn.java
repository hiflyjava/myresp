package com.pg.common.dto.in;

import java.io.Serializable;

/**
 * @Auther: admin
 * @Date: 2019/7/9 11:29
 * @Description:
 */
public class PgAttenceOneDayIn  implements Serializable {


    private Integer entityId;

    private String startTime;

    private String  endTime;

    private  String addTime;

    private String  startToday;

    private String  endToday;

    private String todayDate;

    private Integer departmentId;

    private Integer currentPage=1;
    private Integer pageSize=20;

    private Long staffId;

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getTodayDate() {
        return todayDate;
    }

    public void setTodayDate(String todayDate) {
        this.todayDate = todayDate;
    }

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
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

    public String getStartToday() {
        return startToday;
    }

    public void setStartToday(String startToday) {
        this.startToday = startToday;
    }

    public String getEndToday() {
        return endToday;
    }

    public void setEndToday(String endToday) {
        this.endToday = endToday;
    }
}
