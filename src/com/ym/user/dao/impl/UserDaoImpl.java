package com.ym.user.dao.impl;

import org.springframework.stereotype.Repository;

import com.ym.user.dao.UserDao;
import com.ym.user.model.User;
@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Override
	public String testUser(User user) {
		String str = "�û���Ϣ: �û�����"+user.getUserName() + " ���룺"+user.getPassWord();
		return str;
	}

	@Override
	public void testUserRet(User user) {
		System.out.println("�޷���ֵ");
		System.out.println("�û���Ϣ: �û�����"+user.getUserName() + " ���룺"+user.getPassWord());
	}

	@Override
	public void testUserExc(User user) throws Exception {
		System.out.println("�쳣");
				throw new Exception("���Ǹ��쳣");
		
	}
	
	
}
