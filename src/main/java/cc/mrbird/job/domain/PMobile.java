package cc.mrbird.job.domain;

import java.util.Date;

public class PMobile {
    private Long id;

    private String mobile;

    private String type;

    private Date createDate;

    private String createBy;

    private Integer status;

    private String extend1;

    private Integer userId;

    private String extend3;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getextend1() {
        return extend1;
    }

    public void setextend1(String extend1) {
        this.extend1 = extend1 == null ? null : extend1.trim();
    }

    public void setExtend1(String extend1) {
        this.extend1 = extend1;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getExtend3() {
        return extend3;
    }

    public void setExtend3(String extend3) {
        this.extend3 = extend3 == null ? null : extend3.trim();
    }
}