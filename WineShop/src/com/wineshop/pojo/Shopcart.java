package com.wineshop.pojo;

import java.util.ArrayList;
import java.util.List;

public class Shopcart {
    private String cartid;

    private String uid;

    private String pid;

    private Double shopprice;

    private Integer count;

    private Double subtotal;
    
    private Product product;

    

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getCartid() {
        return cartid;
    }

    public void setCartid(String cartid) {
        this.cartid = cartid == null ? null : cartid.trim();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public Double getShopprice() {
        return shopprice;
    }

    public void setShopprice(Double shopprice) {
        this.shopprice = shopprice;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
}