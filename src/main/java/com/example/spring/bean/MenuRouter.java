package com.example.spring.bean;

import java.util.List;

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

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = name;
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

    public void setMenuId(String menu_id) {
        this.menu_id = menu_id;
    }

    public String getParentId() {
        return this.parent_id;
    }

    public void setParentId(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getPermission() {
        return this.permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public int getTier() {
        return this.tier;
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
}
