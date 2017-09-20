package com.ym.user.util;

import java.lang.reflect.Method;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopAspectTest {
	@Pointcut("execution(* com.ym.user..*(..))")   //切点表达式
	public void function() {}   
	
	
	@Before("function()")  										//这里可以用切点表达式，也可以用这个方法替换
	public void beforToDo(){
		System.out.println("方法执行前调用AopAspectTest------文件Aspect配置");
	}
	@After("function()")
	public void afterToDo(){
		System.out.println("方法执行之后调用AopAspectTest------文件Aspect配置");
	}
	@AfterReturning("execution(* com.ym.user.service..*(..))")
	public void retToDo(){
		System.out.println("方法有返回值AopAspectTest------文件Aspect配置");
	}
	@AfterThrowing("execution(* com.ym.user.service..*(..))")
	public void excToDo() {
		System.out.println("方法有异常AopAspectTest------文件Aspect配置");
	}
}
