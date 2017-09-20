package test;
import java.lang.reflect.Proxy;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ym.user.dao.AdminDao;
import com.ym.user.dao.impl.AdminDaoImpl;
import com.ym.user.model.Admin;
import com.ym.user.service.AdminService;
import com.ym.user.util.InvokeProxyTest;


public class adminTest {

	@Test
	public void test(){
		AdminDao adminDao = new AdminDaoImpl();
		InvokeProxyTest aoplog = new InvokeProxyTest();
		aoplog.setObj(adminDao);
		//��һ������ ����������classLoader    �ڶ�������   �����ı��������ʵ�ֵĽӿ�     ����������  ��������handler
		AdminDao dao = (AdminDao) Proxy.newProxyInstance(adminDao.getClass().getClassLoader(), adminDao.getClass().getInterfaces(),aoplog);
		dao.testAdminDao(new Admin());
	}
	
	@Test
	public void test1(){
		ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("spring-bean.xml");
		AdminService adminService =(AdminService) cpx.getBean("adminService");
		adminService.testAdmin(new Admin());
		cpx.close();
	}
}
