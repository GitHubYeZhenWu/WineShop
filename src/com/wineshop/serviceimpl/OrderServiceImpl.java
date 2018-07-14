package com.wineshop.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wineshop.mapper.OrderitemMapper;
import com.wineshop.mapper.ProductMapper;
import com.wineshop.mapper.ShopordersMapper;
import com.wineshop.pojo.Orderitem;
import com.wineshop.pojo.Product;
import com.wineshop.pojo.Shoporders;
import com.wineshop.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private ShopordersMapper orderMapper;
	@Autowired 
	private OrderitemMapper orderitemMapper;
	@Autowired
	private ProductMapper productMapper;
	public void addOrder(Shoporders order) {
		orderMapper.insert(order);
		
	}
	
	public void addOrderItems(Orderitem orderitem) {
		orderitemMapper.insert(orderitem);
		
	}

	public List<Shoporders> searchOrders(String uid) {
		
		return orderMapper.searchOrders(uid);
	}

	public List<Orderitem> findOrderItems(String oid) {
		
		return orderitemMapper.findOrderItems(oid);
	}

	public Product searchProductFromItem(String pid) {
		
		return productMapper.selectByPrimaryKey(pid);
	}

}
