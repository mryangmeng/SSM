package com.ym.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ym.user.model.User;
import com.ym.user.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("getUser")
	public String test(){
		System.out.println("getUser!!!");
		return "MyJsp";
	}
	@RequestMapping("testUser")
	@ResponseBody
	public Map<String,Object> testUser(){
		User user = new User();
		user.setUserName("testUserName");
		user.setPassWord("testPassWord");
		String a = userService.testUser(user);
		Map<String,Object> ret = new HashMap<String,Object>();
		ret.put("msg", a);
		return ret;
	}
	@RequestMapping("testUserRet")
	public void testUserRet(){
		User user = new User();
		user.setUserName("testUserName");
		user.setPassWord("testPassWord");
		userService.testUserRet(user);
	}
	
	@RequestMapping("testUserExc")
	public void testUserExc(){
		User user = new User();
		user.setUserName("testUserName");
		user.setPassWord("testPassWord");
		try {
			userService.testUserExc(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
