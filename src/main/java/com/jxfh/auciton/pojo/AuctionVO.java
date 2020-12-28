package com.jxfh.auciton.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by pc on 2020/12/28.
 */
public class AuctionVO {
    private String uId;
    private String username;
    private String tel;
    private Integer auctionPrice;
    @JsonFormat(shape = com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone =
            "GMT+8")
    private Date auctionDate;

    public AuctionVO() {
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getAuctionPrice() {
        return auctionPrice;
    }

    public void setAuctionPrice(Integer auctionPrice) {
        this.auctionPrice = auctionPrice;
    }

    public Date getAuctionDate() {
        return auctionDate;
    }

    public void setAuctionDate(Date auctionDate) {
        this.auctionDate = auctionDate;
    }
}
