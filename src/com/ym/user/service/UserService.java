package com.ym.user.service;

import com.ym.user.model.User;

public interface UserService {
	/**
	 * 
	 * @param user
	 * @return
	 */
	String testUser(User user);
	
	void testUserRet(User user);

	void testUserExc(User user)throws Exception;
}
