package com.pg.common.dto.in;

/**
 * @Auther: admin
 * @Date: 2019/4/15 11:15
 * @Description:
 */
public class PgshOrderIn {



    private Integer roomId;
    private Integer id;//订单id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String startTime;
    private String endTime;
    private Integer roomType;

    public Integer getRoomType() {
        return roomType;
    }

    public void setRoomType(Integer roomType) {
        this.roomType = roomType;
    }

    /**
     * 提交订单信息的标识
     * 1.代表入住
     * 2.预订
     *
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
