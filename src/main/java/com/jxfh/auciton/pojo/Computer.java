package com.jxfh.auciton.pojo;

import java.util.Date;

public class Computer {

    private int cId;
    private String cName;
    private Date date;
    private double startPrice;
    private String remark;
    private int isAuction;//是否可竞拍

    public Computer() {
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", date=" + date +
                ", startPrice=" + startPrice +
                ", remark='" + remark + '\'' +
                ", isAuction=" + isAuction +
                '}';
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(double startPrice) {
        this.startPrice = startPrice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getIsAuction() {
        return isAuction;
    }

    public void setIsAuction(int isAuction) {
        this.isAuction = isAuction;
    }
}
