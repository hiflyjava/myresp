package com.pg.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by pg on 2017/12/28.
 */
public class Menu implements Serializable {
    /*private Integer id;
    private String url;
    private String path;
    private String component;
    private String name;
    private String iconCls;
    private Integer parentId;
    private List<Role> roles;
    private List<Menu> children;
    private MenuMeta meta;
   private  Integer enabled;
   //setget 快捷键？

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public MenuMeta getMeta() {
        return meta;
    }

    public void setMeta(MenuMeta meta) {
        this.meta = meta;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }








   *//* public MenuMeta getMeta() {
        return meta;
    }

    public void setMeta(MenuMeta meta) {
        this.meta = meta;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonIgnore
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    public Object getComponent() {
        return component;
    }

    public void setComponent(Object component) {
        this.component = component;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    @JsonIgnore
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @JsonIgnore
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }*/
    private static final long serialVersionUID = 1L;

    /**
     * .
     */
    private Integer id;

    /**
     * .
     */
    private String url;

    /**
     * .
     */
    private String path;

    /**
     * .
     */
    private List<Role> roles;
    private List<Menu> children;
    private MenuMeta meta;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public MenuMeta getMeta() {
        return meta;
    }

    public void setMeta(MenuMeta meta) {
        this.meta = meta;
    }

    private String component;

    /**
     * .
     */
    private String name;

    /**
     * .
     */
    private String iconcls;

    /**
     * .
     */
    private Boolean keepalive;

    /**
     * .
     */
    private Boolean requireauth;

    /**
     * .
     */
    private Integer parentid;

    /**
     * .
     */
    private Boolean enabled;

    private Integer tabId;//表id

    public Integer getTabId() {
        return tabId;
    }

    public void setTabId(Integer tabId) {
        this.tabId = tabId;
    }

    /**
     *
     * {@linkplain #id}
     *
     * @return the value of menu.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * {@linkplain #id}
     * @param id the value for menu.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * {@linkplain #url}
     *
     * @return the value of menu.url
     */
    public String getUrl() {
        return url;
    }

    /**
     * {@linkplain #url}
     * @param url the value for menu.url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     *
     * {@linkplain #path}
     *
     * @return the value of menu.path
     */
    public String getPath() {
        return path;
    }

    /**
     * {@linkplain #path}
     * @param path the value for menu.path
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    /**
     *
     * {@linkplain #component}
     *
     * @return the value of menu.component
     */
    public String getComponent() {
        return component;
    }

    /**
     * {@linkplain #component}
     * @param component the value for menu.component
     */
    public void setComponent(String component) {
        this.component = component == null ? null : component.trim();
    }

    /**
     *
     * {@linkplain #name}
     *
     * @return the value of menu.name
     */
    public String getName() {
        return name;
    }

    /**
     * {@linkplain #name}
     * @param name the value for menu.name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     *
     * {@linkplain #iconcls}
     *
     * @return the value of menu.iconCls
     */
    public String getIconcls() {
        return iconcls;
    }

    /**
     * {@linkplain #iconcls}
     * @param iconcls the value for menu.iconCls
     */
    public void setIconcls(String iconcls) {
        this.iconcls = iconcls == null ? null : iconcls.trim();
    }

    /**
     *
     * {@linkplain #keepalive}
     *
     * @return the value of menu.keepAlive
     */
    public Boolean getKeepalive() {
        return keepalive;
    }

    /**
     * {@linkplain #keepalive}
     * @param keepalive the value for menu.keepAlive
     */
    public void setKeepalive(Boolean keepalive) {
        this.keepalive = keepalive;
    }

    /**
     *
     * {@linkplain #requireauth}
     *
     * @return the value of menu.requireAuth
     */
    public Boolean getRequireauth() {
        return requireauth;
    }

    /**
     * {@linkplain #requireauth}
     * @param requireauth the value for menu.requireAuth
     */
    public void setRequireauth(Boolean requireauth) {
        this.requireauth = requireauth;
    }

    /**
     *
     * {@linkplain #parentid}
     *
     * @return the value of menu.parentId
     */
    public Integer getParentid() {
        return parentid;
    }

    /**
     * {@linkplain #parentid}
     * @param parentid the value for menu.parentId
     */
    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    /**
     *
     * {@linkplain #enabled}
     *
     * @return the value of menu.enabled
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * {@linkplain #enabled}
     * @param enabled the value for menu.enabled
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }


}
