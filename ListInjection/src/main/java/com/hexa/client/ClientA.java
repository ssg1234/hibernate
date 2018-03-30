package com.hexa.client;


import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.hexa.service.ISer;


public class ClientA {
	private static ApplicationContext ctx;
	static{
		
		ctx = new ClassPathXmlApplicationContext("beans.xml");
	}

	public static void main(String[] args) {
		System.out.println("inside main");
		ISer ser = ctx.getBean("myser", ISer.class);
		Set<String> lst = ser.getCities();
		lst.forEach(System.out::println);
	}

}
