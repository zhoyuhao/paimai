package com.example.demo.pojo;

import java.util.Date;

public class Goodsdetailed {
    private Integer did;

    private Integer userid;

    private Integer goodsid;

    private Float dprice;

    private Date ddate;

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public Float getDprice() {
        return dprice;
    }

    public void setDprice(Float dprice) {
        this.dprice = dprice;
    }

    public Date getDdate() {
        return ddate;
    }

    public void setDdate(Date ddate) {
        this.ddate = ddate;
    }
}