package com.wineshop.service;

import java.util.List;

import com.wineshop.pojo.Category;
import com.wineshop.pojo.Product;

public interface ProductService {

	List<Category> categoryList();

	List<Product> findHotProduct();

	List<Product> findNewProduct();

	List<Product> findProductList(String cid);

	List<Product> searchProduct(String keyword);

	Product searchProductInfo(String pid);

}
