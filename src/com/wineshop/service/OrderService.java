package com.wineshop.service;

import java.util.List;

import com.wineshop.pojo.Orderitem;
import com.wineshop.pojo.Product;
import com.wineshop.pojo.Shoporders;

public interface OrderService {

	void addOrder(Shoporders order);

	void addOrderItems(Orderitem orderitem);

	List<Shoporders> searchOrders(String uid);

	List<Orderitem> findOrderItems(String oid);

	Product searchProductFromItem(String pid);

}
