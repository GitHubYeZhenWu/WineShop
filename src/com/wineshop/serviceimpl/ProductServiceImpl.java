package com.wineshop.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wineshop.mapper.ProductMapper;
import com.wineshop.pojo.Category;
import com.wineshop.pojo.Product;
import com.wineshop.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductMapper productMapper;
	
	public List<Category> categoryList() {
		return productMapper.categoryList();
	}

	
	public List<Product> findHotProduct() {
		
		return productMapper.findHotProduct();
	}


	public List<Product> findNewProduct() {
		
		return productMapper.findNewProduct();
	}


	public List<Product> findProductList(String cid) {
		
		return productMapper.findProductList(cid);
	}


	public List<Product> searchProduct(String keyword) {
		
		return productMapper.searchProduct(keyword);
	}


	public Product searchProductInfo(String pid) {
		
		return productMapper.selectByPrimaryKey(pid);
	}
 
}
