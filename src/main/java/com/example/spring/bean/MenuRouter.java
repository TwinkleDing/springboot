package com.example.spring.bean;

import com.example.spring.utils.MetaConfig;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author TwinkleDing
 */
@Slf4j
public class MenuRouter {

    private String path;

    private String name;

    private String redirect;

    private String component;

    private String menu_id;

    private String parent_id;

    private String label;

    private String icon;

    private int permission;

    private int tier;

    private List<MenuRouter> children;

    private MetaConfig meta;

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRedirect() {
        return this.redirect;
    }

    public void getRedirect(String redirect) {
        this.redirect = redirect;
    }

    public String getComponent() {
        return this.component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getMenuId() {
        return this.menu_id;
    }

    public void setMenuId(String menuId) {
        this.menu_id = menuId;
    }

    public String getParentId() {
        return this.parent_id;
    }

    public void setParentId(String parentId) {
        this.parent_id = parentId;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public void setTire(int tier) {
        this.tier = tier;
    }

    public List<MenuRouter> getChildren() {
        return this.children;
    }

    public void setChildren(List<MenuRouter> children) {
        this.children = children;
    }

    public MetaConfig getMeta() {
        this.setMeta();
        return this.meta;
    }

    public void setMeta() {
        MetaConfig meta = new MetaConfig();
        meta.setIcon(this.icon);
        meta.setLabel(this.label);
        meta.setPermission(this.permission);
        meta.setTire(this.tier);
        this.meta = meta;
    }
}
