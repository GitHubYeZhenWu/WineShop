package com.wineshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wineshop.pojo.Product;
import com.wineshop.pojo.Shopcart;
import com.wineshop.pojo.User;
import com.wineshop.service.ShopCartService;
import com.wineshop.utils.CommonsUtils;
/**
 * 
 * @author 叶振武
 * 购物车模块
 */
@Controller
public class ShopCartController {
	@Autowired
	public ShopCartService shopcartservice;
	
	//将商品加入购物车
	@RequestMapping(value="addshopcart.action")
	public String addShopCart(String pid,double shopprice,String buyNum,HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user==null) {
			return "login";
		}
		//判断购物车是否已经包含商品
		Shopcart isExist = shopcartservice.cheackProductExist(pid,user.getUid());
		if(isExist!=null) {
			int newCount = isExist.getCount()+Integer.parseInt(buyNum);
			shopcartservice.updateProductNum(user.getUid(),pid,newCount);
			return "redirect:/showshopcart.action";
			
		}else {
			Shopcart cart = new Shopcart();
			cart.setUid(user.getUid());
			cart.setCartid(CommonsUtils.getUUID());
			cart.setCount(Integer.parseInt(buyNum));
			cart.setPid(pid);
			cart.setSubtotal(shopprice*Integer.parseInt(buyNum));
			cart.setShopprice(shopprice);
			int addShopCart = shopcartservice.addShopCart(cart);
			if(addShopCart>0) {
				return "redirect:/showshopcart.action";
			}
		}
			return "error";
		
	}
	//显示购物车
	@RequestMapping(value="showshopcart.action")
	public String showShopCart(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user==null) {
			return "login";
		}else {
			
			List<Shopcart> shopcartList = shopcartservice.searchShopCart(user.getUid());
			double total = 0;
			for (Shopcart shopcartitem : shopcartList) {
				shopcartitem.setProduct(shopcartservice.searchCartProduct(shopcartitem.getPid()));
				total+=shopcartitem.getSubtotal();
			}
			session.setAttribute("shopcartList", shopcartList);
			session.setAttribute("total", total);
			return "cart";
		}
	}
	//删除商品
	@RequestMapping(value="deleteProduct.action")
	public String deleteProduct(String uid,String pid) {
		//System.out.println(uid+"...."+pid);
		shopcartservice.deleteProduct(uid,pid);
		return "redirect:/showshopcart.action";
	}
	//清空购物车
	@RequestMapping(value="clearShopCart.action")
	public String clearShopCart(HttpSession session) {
		User user = (User)session.getAttribute("user");
		shopcartservice.clearShopCart(user.getUid());
		return "redirect:/showshopcart.action";
	}
	//成功添加订单后清除购物车后跳转订单页
	@RequestMapping(value="removeProductFromCart.action")
	public String removeProductFromCart(HttpSession session) {
		User user = (User)session.getAttribute("user");
		shopcartservice.clearShopCart(user.getUid());
		return "redirect:/showorders.action";
	}
}
