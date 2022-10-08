package com.example.spring.utils;

public class MetaConfig {
    private String label;

    private String icon;

    private int permission;

    private int tier;

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

}
