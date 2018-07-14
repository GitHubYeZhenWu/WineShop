package com.wineshop.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wineshop.mapper.ProductMapper;
import com.wineshop.mapper.ShopcartMapper;
import com.wineshop.pojo.Product;
import com.wineshop.pojo.Shopcart;
import com.wineshop.service.ShopCartService;

@Service
public class ShopCartServiceImpl implements ShopCartService {
	@Autowired
	private ShopcartMapper shopcartMapper;
	@Autowired
	private ProductMapper productMapper;
	//添加购物车
	public int addShopCart(Shopcart cart) {
		
		return  shopcartMapper.insert(cart);
	}
	//查询用户所拥有的购物车项信息
	public List<Shopcart> searchShopCart(String uid) {
		
		return shopcartMapper.searchShopCart(uid);
	}

	//查询每个购物车项的商品信息
	public Product searchCartProduct(String pid) {
		
		return productMapper.selectByPrimaryKey(pid);
	}
	//删除购物车商品
	public void deleteProduct(String uid,String pid) {
		
		shopcartMapper.deleteProductFromCart(uid,pid);
	}
	//清空购物车
	public void clearShopCart(String uid) {
		shopcartMapper.clearShopCart(uid);
	}
	//检查商品是否存在
	public Shopcart cheackProductExist(String pid, String uid) {
		return shopcartMapper.cheackProductExist(pid,uid);
	}
	
	//更新商品数量
	public void updateProductNum(String uid, String pid, int newCount) {
		shopcartMapper.updateProductNum(uid,pid,newCount);
	}
}
