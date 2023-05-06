package com.example.spring.study.doudizhu;

/**
 * @author TwinkleDing
 */
public class Poker {

    private String name;
    private Boolean up;
    private Boolean canClick = false;
    private Boolean hasClick = false;

    public Poker(String name, Boolean up) {
        this.name = name;
        this.up = up;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getUp() {
        return up;
    }

    public void setUp(Boolean up) {
        this.up = up;
    }

    public Boolean getCanClick() {
        return canClick;
    }

    public void setCanClick(Boolean canClick) {
        this.canClick = canClick;
    }

    public Boolean getHasClick() {
        return hasClick;
    }

    public void setHasClick(Boolean hasClick) {
        this.hasClick = hasClick;
    }
}
