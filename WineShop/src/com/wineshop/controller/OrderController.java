package com.wineshop.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wineshop.pojo.Orderitem;
import com.wineshop.pojo.Product;
import com.wineshop.pojo.Shopcart;
import com.wineshop.pojo.Shoporders;
import com.wineshop.pojo.User;
import com.wineshop.service.OrderService;
import com.wineshop.service.ShopCartService;
import com.wineshop.utils.CommonsUtils;
/**
 * 
 * @author Ҷ����
 * ����ģ�� 	
 */
@Controller
public class OrderController {
	@Autowired
	public OrderService orderservice;
	@Autowired
	public ShopCartService shopcartservice;
	
	
	//�鿴����
	@RequestMapping(value="showorders.action")
	public String showorders(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user==null) {
			return "login";
		}else {
		//�����û�id�ҵ�������
		List<Shoporders> orders = orderservice.searchOrders(user.getUid());
		for (Shoporders order : orders) {
			//���ݶ���id�Ӷ���������Ҷ�����
			List<Orderitem> orderitems = orderservice.findOrderItems(order.getOid());
			//���ݶ������ҵ���Ʒ
			for (Orderitem orderitem : orderitems) {
				Product product  = orderservice.searchProductFromItem(orderitem.getPid());
				orderitem.setProduct(product);
			}
			order.setOrderitems(orderitems);
			
		}
		session.setAttribute("orders", orders);
		return "order_list";
		}
	}
	//��ʾ���ﳵ����
	@RequestMapping(value="showorder.action")
	public String showorder(HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<Shopcart> shopcartList = shopcartservice.searchShopCart(user.getUid());
		double total = 0;
		for (Shopcart shopcartitem : shopcartList) {
			shopcartitem.setProduct(shopcartservice.searchCartProduct(shopcartitem.getPid()));
			total+=shopcartitem.getSubtotal();
		}
		session.setAttribute("shopcartList", shopcartList);
		session.setAttribute("oid", CommonsUtils.getUUID());
		session.setAttribute("total", total);
		return "order_info"; 
	}

	//��Ӷ���
	@RequestMapping(value="addorder.action")
	public String addOrder(Shoporders order,HttpSession session) {
		User user =(User) session.getAttribute("user");
		order.setUid(user.getUid());
		order.setOid((String) session.getAttribute("oid"));
		order.setOrdertime(new Date());
		order.setState(0);
		order.setTotal((Double)session.getAttribute("total"));
		orderservice.addOrder(order);
		return "redirect:/removeCart.action";
	}
	
	//������ύ�����Ĺ��ﳵ,����ӹ��ﳵ��
	@RequestMapping(value="removeCart.action")
	public String removeCart(HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<Shopcart> shopcartList = shopcartservice.searchShopCart(user.getUid());
		Orderitem orderitem = new Orderitem();
		
		for (Shopcart shopcartitem : shopcartList) {
			
				orderitem.setItemid(shopcartitem.getCartid());
				orderitem.setOid((String) session.getAttribute("oid"));
				orderitem.setPid(shopcartitem.getPid());
				orderitem.setSubtotal(shopcartitem.getSubtotal());
				orderitem.setCount(shopcartitem.getCount());
				orderservice.addOrderItems(orderitem);
			
		}
		
		return"redirect:/removeProductFromCart.action";
	}

}
