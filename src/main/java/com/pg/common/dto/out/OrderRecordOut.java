package com.pg.common.dto.out;

/**
 * @Auther: admin
 * @Date: 2019/4/29 12:33
 * @Description:
 */
public class OrderRecordOut {

    private Integer orderCICount;//入住订单总数

    private Integer orderAllCount;//所有订单总数

    private Integer   roomAvaibleCount; //空房总数

    public Integer getOrderCICount() {
        return orderCICount;
    }

    public void setOrderCICount(Integer orderCICount) {
        this.orderCICount = orderCICount;
    }

    public Integer getOrderAllCount() {
        return orderAllCount;
    }

    public void setOrderAllCount(Integer orderAllCount) {
        this.orderAllCount = orderAllCount;
    }

    public Integer getRoomAvaibleCount() {
        return roomAvaibleCount;
    }

    public void setRoomAvaibleCount(Integer roomAvaibleCount) {
        this.roomAvaibleCount = roomAvaibleCount;
    }
}
