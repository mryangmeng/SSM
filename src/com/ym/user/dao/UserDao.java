package com.ym.user.dao;

import com.ym.user.model.User;

public interface UserDao {
	/**
	 * 
	 * @param user
	 * @return
	 */
	String testUser(User user);
	
	void testUserRet(User user);

	void testUserExc (User user)throws Exception;
}
