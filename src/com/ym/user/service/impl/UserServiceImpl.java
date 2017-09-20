package com.ym.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ym.user.dao.UserDao;
import com.ym.user.model.User;
import com.ym.user.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public String testUser(User user) {
		return userDao.testUser(user);
	}

	@Override
	public void testUserRet(User user) {
		userDao.testUserRet(user);
	}

	@Override
	public void testUserExc(User user) throws Exception {
		userDao.testUserExc(user);
	}

}
