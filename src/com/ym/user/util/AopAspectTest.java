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
	@Pointcut("execution(* com.ym.user..*(..))")   //�е���ʽ
	public void function() {}   
	
	
	@Before("function()")  										//����������е���ʽ��Ҳ��������������滻
	public void beforToDo(){
		System.out.println("����ִ��ǰ����AopAspectTest------�ļ�Aspect����");
	}
	@After("function()")
	public void afterToDo(){
		System.out.println("����ִ��֮�����AopAspectTest------�ļ�Aspect����");
	}
	@AfterReturning("execution(* com.ym.user.service..*(..))")
	public void retToDo(){
		System.out.println("�����з���ֵAopAspectTest------�ļ�Aspect����");
	}
	@AfterThrowing("execution(* com.ym.user.service..*(..))")
	public void excToDo() {
		System.out.println("�������쳣AopAspectTest------�ļ�Aspect����");
	}
}
