package com.pg.bean;

import java.util.Date;

public class TMenu {
    private Long id;

    private Long parentid;

    private String name;

   //private String type;

  //  private Long orderNumber;

    //private Date createDate;

   // private Date updateDate;

    private String path;

    private String component;

  //  private String perms;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }
}