package com.jxfh.auciton.pojo;

public class AuctionUC {

    private int aId;
    private int uId;
    private int cId;
    private int auctionPri;//竞拍价格

    public AuctionUC() {
    }

    @Override
    public String toString() {
        return "AuctionUC{" +
                "aId=" + aId +
                ", uId=" + uId +
                ", cId=" + cId +
                ", auctionPri=" + auctionPri +
                '}';
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public int getAuctionPri() {
        return auctionPri;
    }

    public void setAuctionPri(int auctionPri) {
        this.auctionPri = auctionPri;
    }
}
