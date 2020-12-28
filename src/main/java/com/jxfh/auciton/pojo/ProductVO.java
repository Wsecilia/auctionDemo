package com.jxfh.auciton.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * Created by pc on 2020/12/28.
 * 商品详情
 */
public class ProductVO {
    private String cId;
    private String cName;
    @JsonFormat(shape = com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone =
            "GMT+8")
    private Date startDate;
    @JsonFormat(shape = com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone =
            "GMT+8")
    private Date cutOffDate;
    private Integer startPrice;
    private String remark;
    private String imgUrl;
    private List<AuctionVO> list;

    public ProductVO() {
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getCutOffDate() {
        return cutOffDate;
    }

    public void setCutOffDate(Date cutOffDate) {
        this.cutOffDate = cutOffDate;
    }

    public Integer getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Integer startPrice) {
        this.startPrice = startPrice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<AuctionVO> getList() {
        return list;
    }

    public void setList(List<AuctionVO> list) {
        this.list = list;
    }
}
