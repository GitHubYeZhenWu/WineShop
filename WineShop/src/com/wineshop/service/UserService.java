package com.wineshop.service;

import com.wineshop.pojo.User;

public interface UserService {
	public User login(User user);
	public boolean checkUsernameExist(String username);
	public int register(User user);
}
