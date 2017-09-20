package com.ym.user.util;

import java.util.concurrent.CountDownLatch;

public class  Runable implements Runnable{

	private int val = 5;
	
	private int buys;
	
	private CountDownLatch cdl;
	public Runable(int buys,CountDownLatch cdl) {
		this.buys = buys;
		this.cdl = cdl;
	}
	
	@Override
	public void run() {
		cdl.countDown();
		if(buys >val){
			System.out.println("----------����-----���������ڿ��");
		}else{
			val = val - buys;
			System.out.println("ʣ��"+val);
		}
	}
	
}