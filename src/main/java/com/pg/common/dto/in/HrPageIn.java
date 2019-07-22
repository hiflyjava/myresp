package com.pg.common.dto.in;

import java.io.Serializable;

/**
 * @Auther: admin
 * @Date: 2019/4/1 11:55
 * @Description:
 */
public class HrPageIn implements Serializable {


    private Integer currentPage = 1;

    private Integer pageSize = 30;

    private String keywords;

    private Integer entityId;

    private String username;

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}
