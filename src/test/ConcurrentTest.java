package test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.junit.Test;

import com.ym.user.util.Runable;

public class ConcurrentTest {
	ExecutorService fixedThreadPool = Executors.newFixedThreadPool(100);
	
	@Test
	public void test(){
		CountDownLatch cdl = new CountDownLatch(50);
		for(int i=0;i<=50;i++){
			fixedThreadPool.execute(new Runable(1, cdl));
			try {
				cdl.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
