package com.ym.user.service;

import com.ym.user.model.Admin;

public interface AdminService {
	/**
	 * @param admin
	 * @return
	 */
	String testAdmin(Admin admin);
	
	String testAdminAop(Admin admin);
}
