package com.hexa.client;

//import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.hexa.service.ISer;

public class ClientA {
	private static AbstractApplicationContext ctx;
	static{
		
		ctx = new AnnotationConfigApplicationContext(MyConfig.class);
	}

	public static void main(String[] args) {
		System.out.println("inside main");
		ISer ser = ctx.getBean("myser", ISer.class);
		System.out.println(ser.getData());
		System.out.println("----------demand------");
	    ser = ctx.getBean("myser", ISer.class);
		System.out.println(ser.getData());
		ctx.registerShutdownHook();
	}

}
