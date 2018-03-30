package com.hexa.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hexa.dao.AccountDao;
import com.hexa.service.ISer;

public class TransferFund {

	private static ApplicationContext ctx;
	static {
		ctx = new AnnotationConfigApplicationContext(HibernateConfig.class);
		
	}
	public static void main(String[] args) {
		ISer ser =ctx.getBean("myser", ISer.class);
		ser.transferFund(1001, 1002, 3000);
		System.out.println("tranferred money");
		AccountDao dao = ctx.getBean("mydao", AccountDao.class);
		System.out.println(dao.getAccount(1001));
		System.out.println(dao.getAccount(1002));

	}

}
