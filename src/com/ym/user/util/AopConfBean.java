package com.ym.user.util;

public class AopConfBean {
	
	public AopConfBean() {
		
	}
	public void beforToDo(){
		System.out.println("����ִ��ǰ����AopConfBean------�����ļ�����");
	}
	public void afterToDo(){
		System.out.println("����ִ��֮�����AopConfBean------�����ļ�����");
	}
	public void retToDo(){
		System.out.println("�����з���ֵ------�����ļ�����");
	}
	public void excToDo() {
		System.out.println("�������쳣------�����ļ�����");
	}
}
