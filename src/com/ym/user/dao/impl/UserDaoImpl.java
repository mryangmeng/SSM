package com.ym.user.dao.impl;

import org.springframework.stereotype.Repository;

import com.ym.user.dao.UserDao;
import com.ym.user.model.User;
@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Override
	public String testUser(User user) {
		String str = "用户信息: 用户名："+user.getUserName() + " 密码："+user.getPassWord();
		return str;
	}

	@Override
	public void testUserRet(User user) {
		System.out.println("无返回值");
		System.out.println("用户信息: 用户名："+user.getUserName() + " 密码："+user.getPassWord());
	}

	@Override
	public void testUserExc(User user) throws Exception {
		System.out.println("异常");
				throw new Exception("这是个异常");
		
	}
	
	
}
