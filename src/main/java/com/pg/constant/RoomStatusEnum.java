package com.pg.constant;

public enum 	RoomStatusEnum {

	
	//状态
	ROOM_STATUS_CI(1, "CI"),//入住
	ROOM_STATUS_CO(2, "CO"),//退房

	ROOM_STATUS_R(3, "R"),//预订

	ROOM_STATUS_A(4, "A"),//空房

	ROOM_STATUS_F(5, "F"),//智障房
	ROOM_STATUS_IC(11, "IC"),//打扫中

	ROOM_REMARK_CI(6, "CheckedIn"),//入住
	ROOM_REMARK_CO(7, "CheckedOut"),//退房
	ROOM_REMARK_R(8, "Reserved"),//预订
	ROOM_REMARK_A(9, "Avaible"),//空房
	ROOM_REMARK_IC(12, "InCleaning"),//打扫中
	ROOM_REMARK_F(10, "Fault");//智障房

	//标识


	private int id;

	private String name;

	private RoomStatusEnum(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static String getRoomStatusNameByKey(Integer key) {
		for (RoomStatusEnum roomStatusEnum : RoomStatusEnum.values()) {
			if (key == roomStatusEnum.getId() || key.equals(roomStatusEnum.getId())) {
				return roomStatusEnum.getName();
			}
		}
		return "";
	}

}
