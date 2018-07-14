package com.wineshop.pojo;

import java.util.Date;

public class Product {
    private String pid;

    private String pname;

    private Double marketPrice;

    private Double shopPrice;

    private String pimage;

    private Date pdate;

    private Integer isHot;

    private String pcontent;

    private String porigin;

    private String pvendor;

    private String palcohol;

    private String cid;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Double getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(Double shopPrice) {
        this.shopPrice = shopPrice;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage == null ? null : pimage.trim();
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public Integer getIsHot() {
        return isHot;
    }

    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    public String getPcontent() {
        return pcontent;
    }

    public void setPcontent(String pcontent) {
        this.pcontent = pcontent == null ? null : pcontent.trim();
    }

    public String getPorigin() {
        return porigin;
    }

    public void setPorigin(String porigin) {
        this.porigin = porigin == null ? null : porigin.trim();
    }

    public String getPvendor() {
        return pvendor;
    }

    public void setPvendor(String pvendor) {
        this.pvendor = pvendor == null ? null : pvendor.trim();
    }

    public String getPalcohol() {
        return palcohol;
    }

    public void setPalcohol(String palcohol) {
        this.palcohol = palcohol == null ? null : palcohol.trim();
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }
}