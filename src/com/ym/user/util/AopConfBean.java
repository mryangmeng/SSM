package com.ym.user.util;

public class AopConfBean {
	
	public AopConfBean() {
		
	}
	public void beforToDo(){
		System.out.println("方法执行前调用AopConfBean------配置文件切面");
	}
	public void afterToDo(){
		System.out.println("方法执行之后调用AopConfBean------配置文件切面");
	}
	public void retToDo(){
		System.out.println("方法有返回值------配置文件切面");
	}
	public void excToDo() {
		System.out.println("方法有异常------配置文件切面");
	}
}
