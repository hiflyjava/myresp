package com.pg.constant;

public enum OrderStatusEnum {

	
	//状态
	Order_STATUS_R(1, "1"),//预订
	Order_STATUS_CI(2, "2"),// 入住

	Order_STATUS_CO(3, "3"),//退房

	Order_STATUS_A(4, "4"),//空房

	Order_STATUS_F(5, "5"),//智障房
	Order_STATUS_IC(0, "0");//打扫中

	/*Order_REMARK_CI(6, "CheckedIn"),//入住
	Order_REMARK_CO(7, "CheckedOut"),//退房
	Order_REMARK_R(8, "Reserved"),//预订
	Order_REMARK_A(9, "Avaible"),//空房
	Order_REMARK_IC(9, "InCleaning"),//打扫中
	Order_REMARK_F(10, "Fault");//智障房*/

	//标识


	private int id;

	private String name;

	private OrderStatusEnum(int id, String name) {
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

	public static String getOrderStatusNameByKey(Integer key) {
		for (OrderStatusEnum OrderStatusEnum : OrderStatusEnum.values()) {
			if (key == OrderStatusEnum.getId() || key.equals(OrderStatusEnum.getId())) {
				return OrderStatusEnum.getName();
			}
		}
		return "";
	}

}
