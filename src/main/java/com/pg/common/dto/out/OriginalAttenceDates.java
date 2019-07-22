package com.pg.common.dto.out;

import java.util.List;

/**
 * @Auther: admin
 * @Date: 2019/7/15 11:12
 * @Description:
 */
public class OriginalAttenceDates {


    private String dates;

    private String datas;

    private List<OriginalAttenceDatas> originalAttenceDatas;


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

    public List<OriginalAttenceDatas> getOriginalAttenceDatas() {
        return originalAttenceDatas;
    }

    public void setOriginalAttenceDatas(List<OriginalAttenceDatas> originalAttenceDatas) {
        this.originalAttenceDatas = originalAttenceDatas;
    }


}
