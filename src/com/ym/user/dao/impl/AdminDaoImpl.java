package com.ym.user.dao.impl;

import com.ym.user.dao.AdminDao;
import com.ym.user.model.Admin;

public class AdminDaoImpl implements AdminDao {

	@Override
	public String testAdminDao(Admin admin) {
		String str = "AdminMsg£ºid = "+admin.getAdminId()+"name =" +admin.getAdminName();
		return str;
	}

}
