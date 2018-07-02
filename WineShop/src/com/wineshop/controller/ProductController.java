package com.wineshop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.wineshop.pojo.Category;
import com.wineshop.pojo.Product;
import com.wineshop.service.ProductService;
/**
 * 
 * @author Ҷ����
 * ��Ʒģ��
 */

@Controller
public class ProductController {
	@Autowired
	public ProductService productservice;
	//��̬��ѯ��Ʒ�б�
	@RequestMapping(value="/category.action")
	public void categoryList(HttpServletResponse response) throws Exception {
		List<Category> category = productservice.categoryList();
		Gson gson = new Gson();
		String categoryList = gson.toJson(category);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(categoryList);
	}
	//��̬��ѯ������Ʒ
	@RequestMapping(value="/hotproduct.action")
	public void hotproductList(HttpServletResponse response) throws Exception {
		List<Product> hotproduct = productservice.findHotProduct();
		Gson gson = new Gson();
		String hotproductList = gson.toJson(hotproduct);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(hotproductList);
	}
	
	//��̬��ѯ������Ʒ
		@RequestMapping(value="/newproduct.action")
		public void newproductList(HttpServletResponse response) throws Exception {
			List<Product> newproduct = productservice.findNewProduct();
			Gson gson = new Gson();
			String newproductList = gson.toJson(newproduct);
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write(newproductList);
		}
	//������Ʒ����
		@RequestMapping(value="/productlist.action")
		public String showProductList(HttpServletRequest request,String cid) {
			List<Product> productList = productservice.findProductList(cid);
			request.setAttribute("productList", productList);
			return "product_list";
		}
	//������Ʒ
		@RequestMapping(value="/searchProduct.action")
		public String searchProduct(HttpServletRequest request,@Param("keyword")String keyword) {
			List<Product> searchList = productservice.searchProduct(keyword);
			request.setAttribute("productList", searchList);
			return "product_list";	
		}
	//��Ʒ����
		@RequestMapping(value="/productinfo.action")
		public String showProductInfo(HttpServletRequest request,String pid) {
			Product productinfo = productservice.searchProductInfo(pid);
			System.out.println(productinfo);
			request.setAttribute("productinfo", productinfo);
			return "product_info";
			
		}
}
