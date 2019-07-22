package com.pg.common.dto.in;

import java.io.Serializable;

/**
 * @Auther: admin
 * @Date: 2019/6/3 15:41
 * @Description:
 */
public class OrderCreateTodayIn implements Serializable {


    private  String  startTime;

    private String  endTime;

    private Long hrid;

    private String  items; //查询条件，1:今天创建 2：今天取消

    private Integer eid;

    private  Integer currentPage=1;

    private Integer pageSize=10;

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

    public Long getHrid() {
        return hrid;
    }

    public void setHrid(Long hrid) {
        this.hrid = hrid;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
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
}
