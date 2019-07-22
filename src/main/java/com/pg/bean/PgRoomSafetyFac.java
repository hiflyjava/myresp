package com.pg.bean;

public class PgRoomSafetyFac {
    private Integer id;

    private String roomSafetyFac;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomSafetyFac() {
        return roomSafetyFac;
    }

    public void setRoomSafetyFac(String roomSafetyFac) {
        this.roomSafetyFac = roomSafetyFac == null ? null : roomSafetyFac.trim();
    }
}