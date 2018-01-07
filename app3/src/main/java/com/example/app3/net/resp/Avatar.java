package com.example.app3.net.resp;

/**
 * 项目 ： ArchitectureComponentDemo
 * 作者 ： Chuckifan
 * 时间 ： 2017/11/24 11:16
 * 内容 ：
 */

public class Avatar implements IResp{

    private String small;
    private String large;
    private String medium;
    public void setSmall(String small) {
        this.small = small;
    }
    public String getSmall() {
        return small;
    }

    public void setLarge(String large) {
        this.large = large;
    }
    public String getLarge() {
        return large;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }
    public String getMedium() {
        return medium;
    }

}