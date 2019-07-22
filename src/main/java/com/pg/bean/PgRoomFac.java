package com.pg.bean;

public class PgRoomFac {
    private Integer id;

    private String roomFac;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomFac() {
        return roomFac;
    }

    public void setRoomFac(String roomFac) {
        this.roomFac = roomFac == null ? null : roomFac.trim();
    }
}