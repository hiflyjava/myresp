package com.pg.common.dto.out;

/**
 * @Auther: admin
 * @Date: 2019/7/15 16:17
 * @Description:
 */
public class OriginalAttenceDatas {

    private String  datas;

    private Integer type;
    private Integer status;//1.是迟到 2.是早退 3.是迟到早退 4.正常

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDatas() {
        return datas;
    }

    public void setDatas(String datas) {
        this.datas = datas;
    }
}
