package com.hexa.client;

import java.text.Annotation;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hexa.entity.Account;
import com.hexa.service.ISer;



public class testAddAccount {

	
		private static ApplicationContext ctx;
		static {
			ctx = new AnnotationConfigApplicationContext(HibernateConfig.class);
			
		}
		public static void main(String[] args) {
			ISer ser =ctx.getBean("myser", ISer.class);
			Account acc1 =new Account(1004, "sam", 5000);
			Account acc2 = new Account(1005, "peter", 15000);
			List<Account> lst = new ArrayList<Account>();
			lst.add(acc1);
			lst.add(acc2);
			ser.addAccounts(lst);
			System.out.println("transaction done");
 	}
}
