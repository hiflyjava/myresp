package com.pg.common.dto.out;

import java.io.Serializable;

/**
 * @Auther: admin
 * @Date: 2019/6/26 09:50
 * @Description:
 */
public class PWout implements Serializable {

    private String password;

    private Integer orderId;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
