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
	//��ӹ��ﳵ
	public int addShopCart(Shopcart cart) {
		
		return  shopcartMapper.insert(cart);
	}
	//��ѯ�û���ӵ�еĹ��ﳵ����Ϣ
	public List<Shopcart> searchShopCart(String uid) {
		
		return shopcartMapper.searchShopCart(uid);
	}

	//��ѯÿ�����ﳵ�����Ʒ��Ϣ
	public Product searchCartProduct(String pid) {
		
		return productMapper.selectByPrimaryKey(pid);
	}
	//ɾ�����ﳵ��Ʒ
	public void deleteProduct(String uid,String pid) {
		
		shopcartMapper.deleteProductFromCart(uid,pid);
	}
	//��չ��ﳵ
	public void clearShopCart(String uid) {
		shopcartMapper.clearShopCart(uid);
	}
	//�����Ʒ�Ƿ����
	public Shopcart cheackProductExist(String pid, String uid) {
		return shopcartMapper.cheackProductExist(pid,uid);
	}
	
	//������Ʒ����
	public void updateProductNum(String uid, String pid, int newCount) {
		shopcartMapper.updateProductNum(uid,pid,newCount);
	}
}
