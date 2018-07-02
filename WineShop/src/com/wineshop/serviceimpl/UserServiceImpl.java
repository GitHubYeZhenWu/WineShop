package com.wineshop.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wineshop.mapper.UserMapper;
import com.wineshop.pojo.User;
import com.wineshop.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	
	public User login(User user) {
		
		return userMapper.login(user);
	}

	
	public boolean checkUsernameExist(String username) {
		User user = userMapper.checkUsernameExist(username);
		
		return user!=null?true:false;
	}
	
	public int register(User user) {
		
		return userMapper.insert(user);
	}
	
}
