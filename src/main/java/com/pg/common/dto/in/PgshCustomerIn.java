package com.pg.common.dto.in;

import com.pg.bean.PgshRoomCustomer;

import java.util.List;

/**
 * @Auther: admin
 * @Date: 2019/4/15 11:15
 * @Description:
 */
public class PgshCustomerIn  {

   private List<PgshRoomCustomer> pgshRoomCustomers;

    public List<PgshRoomCustomer> getPgshRoomCustomers() {
        return pgshRoomCustomers;
    }

    public void setPgshRoomCustomers(List<PgshRoomCustomer> pgshRoomCustomers) {
        this.pgshRoomCustomers = pgshRoomCustomers;
    }



    private Integer roomId;
    private Integer id;//订单id
    private Integer eid;//宾馆id;



    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String startTime;
    private String endTime;
    private String roomType;
    //密码类型 1.在线密码  2.离线密码
    private Integer pdType;

    public Integer getPdType() {
        return pdType;
    }

    public void setPdType(Integer pdType) {
        this.pdType = pdType;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    /**
     * 提交订单信息的标识
     * 3.代表入住
     * 1.预订
     * 2.预订-入住
     */
    private String flag;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
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

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }
}
