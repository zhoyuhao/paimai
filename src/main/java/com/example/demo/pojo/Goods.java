package com.example.demo.pojo;

import java.util.Date;

public class Goods {
    private Integer goodsid;

    private String goodsname;

    private Float goodsprice;

    private Date startdate;

    private Date enddate;

    private Integer statrc;

    private String depict;

    private byte[] goodsimg;

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname == null ? null : goodsname.trim();
    }

    public Float getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(Float goodsprice) {
        this.goodsprice = goodsprice;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Integer getStatrc() {
        return statrc;
    }

    public void setStatrc(Integer statrc) {
        this.statrc = statrc;
    }

    public String getDepict() {
        return depict;
    }

    public void setDepict(String depict) {
        this.depict = depict == null ? null : depict.trim();
    }

    public byte[] getGoodsimg() {
        return goodsimg;
    }

    public void setGoodsimg(byte[] goodsimg) {
        this.goodsimg = goodsimg;
    }
}