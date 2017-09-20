package com.ym.user.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class InvokeProxyTest implements InvocationHandler {
	private Object obj;			  
	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	private void beforMethod(Method m){
		System.out.println("InvokeProxyTest    方法"+m.getName()+"执行前！ log");
	}
	
	private void afterMethod(Method m){
		System.out.println("InvokeProxyTest    方法"+m.getName()+"执行后！ log");
	}
	
	@Override
	public Object invoke(Object proxy, Method m, Object[] arg)
			throws Throwable {
		beforMethod(m);
		m.invoke(obj, arg);
		afterMethod(m);
		return null;
	}

}
