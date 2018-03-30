package com.hexa.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hexa.dao.IDao;
import com.hexa.service.ISer;

public class ClientA {
	private static ApplicationContext ctx;
	static{
		
		ctx = new ClassPathXmlApplicationContext("beans.xml" , "beans2.xml");
	}

	public static void main(String[] args) {
		System.out.println("inside main");
		ISer ser = ctx.getBean("myser", ISer.class);
		boolean res = ser.transferFund(1001, 1002, 5000.0);
		System.out.println("fund transfered" +res);
		
		
	    IDao dao = ctx.getBean("mydao", IDao.class);
	    System.out.println(dao.getAccount((1001)));
	    System.out.println(dao.getAccount(1002));
	    
		
		
	}

}
