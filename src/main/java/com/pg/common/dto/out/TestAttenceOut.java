package com.pg.common.dto.out;

/**
 * @Auther: admin
 * @Date: 2019/7/12 09:46
 * @Description:
 */
public class TestAttenceOut {


    private String  dates;


    private String datas;

    private  String  firstLog;

    private String  lastLog;


    public String getDatas() {
        return datas;
    }

    public void setDatas(String datas) {
        this.datas = datas;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }


    public String getFirstLog() {
        return firstLog;
    }

    public void setFirstLog(String firstLog) {
        this.firstLog = firstLog;
    }

    public String getLastLog() {
        return lastLog;
    }

    public void setLastLog(String lastLog) {
        this.lastLog = lastLog;
    }
}
