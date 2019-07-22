package com.pg.common.dto.in;

import java.io.Serializable;

/**
 * @Auther: admin
 * @Date: 2019/4/8 10:21
 * @Description:
 */
public class HridsIn implements Serializable {



    private Long [] hrids;

    public Long[] getHrids() {
        return hrids;
    }

    public void setHrids(Long[] hrids) {
        this.hrids = hrids;
    }
}
