package com.ym.user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.ym.user.model.Admin;
import com.ym.user.service.AdminService;
import com.ym.user.util.AopAspectTest;

@Controller
@RequestMapping("admin")
public class AdminController {
	
	//ApplicationContext act =new ClassPathXmlApplicationContext("spring-bean.xml");
	//private AdminService adminService=(AdminService) act.getBean("adminService");
	
	@Autowired
	private AdminService adminService;
	
	@ResponseBody
	@RequestMapping("adminTest")
	public JSONObject testAdmin(){
		JSONObject json = new JSONObject();
		Admin admin= new Admin();
		admin.setAdminId("123123123");
		admin.setAdminName("adminName");
		json.put("key", adminService.testAdmin(admin));
		return json;
	}
	
	@ResponseBody
	@RequestMapping("testAdminAop")
	public JSONObject testAdminAop(){
		JSONObject json = new JSONObject();
		Admin admin = new Admin();
		String a = adminService.testAdminAop(admin);
		json.put("msg",a);
		return json;
	}
	
}
