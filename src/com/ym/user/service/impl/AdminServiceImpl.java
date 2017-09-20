package com.ym.user.service.impl;


import org.springframework.stereotype.Service;

import com.ym.user.dao.AdminDao;
import com.ym.user.model.Admin;
import com.ym.user.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	
	private AdminDao adminDao;
	
	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	@Override
	public String testAdmin(Admin admin) {
		return adminDao.testAdminDao(admin);
	}
	@Override
	public String testAdminAop(Admin admin) {
		return adminDao.testAdminDao(admin);
	}

}
