package com.wineshop.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wineshop.pojo.User;
import com.wineshop.service.UserService;
import com.wineshop.utils.CommonsUtils;
/**
 * 
 * @author 叶振武
 * 用户模块
 */
@Controller
/*@RequestMapping(value="/user")*/
public class UserController {
	@Autowired
	public UserService userservice;
	//校验登录
	@RequestMapping(value="/login.action")
	public String login(User user,HttpSession session,HttpServletRequest request) {
		
		User loginUser = userservice.login(user);
		if(loginUser==null) {
		request.setAttribute("loginInfo", "用户名或密码错误");
		return "login";
		}else {
		session.setAttribute("user", loginUser);
		return "index";
		}
	}
	//用户退出
	@RequestMapping(value="/logout.action")
	public String logout(HttpSession session) {
		
		session.removeAttribute("user");
		return "login";
	}
	//校验用户名是否存在
	@RequestMapping(value="/checkname.action")
	public void checkname(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		boolean isExist = userservice.checkUsernameExist(username);
		String json ="{\"isExist\":"+isExist+"}";
		response.getWriter().write(json);
	}
	//用户注册
	@RequestMapping(value="/register.action")
	public String register(User user){
		user.setUid(CommonsUtils.getUUID());
		int suc = userservice.register(user);
		return suc>0?"login":"register";
	}
	
}
