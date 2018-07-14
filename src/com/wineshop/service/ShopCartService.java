package com.wineshop.service;

import java.util.List;

import com.wineshop.pojo.Product;
import com.wineshop.pojo.Shopcart;

public interface ShopCartService {
	public int addShopCart(Shopcart cart);

	public List<Shopcart> searchShopCart(String uid);

	public Product searchCartProduct(String pid);

	public void deleteProduct(String uid,String pid);

	public void clearShopCart(String uid);

	public Shopcart cheackProductExist(String pid, String uid);

	public void updateProductNum(String uid, String pid, int newCount);
}
