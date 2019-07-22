package com.pg.common.dto.in;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: admin
 * @Date: 2019/3/29 19:33
 * @Description:
 */

public class MenuRoleIn implements Serializable {


    private  Long rid;

    private List<Long> mids;

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public List<Long> getMids() {
        return mids;
    }

    public void setMids(List<Long> mids) {
        this.mids = mids;
    }
}
