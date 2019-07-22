package com.pg.common.dto.in;

import java.io.Serializable;

/**
 * @Auther: admin
 * @Date: 2019/6/11 18:56
 * @Description:
 */
public class RoomDeviceAndHudIn implements Serializable {


    private Integer  roomId;

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "RoomDeviceAndHudIn{" +
                "roomId=" + roomId +
                '}';
    }
}
