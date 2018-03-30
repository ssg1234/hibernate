package com.hexa.client;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hexa.dao.EmpDao;
import com.hexa.entity.Dept;



public class ClientA {
	private static ApplicationContext ctx;
	static{
		
		ctx = new AnnotationConfigApplicationContext(HibernateConfig.class);
	}
	public static void main(String[] args) {
		System.out.println("inside main");
		EmpDao dao = ctx.getBean("mydao", EmpDao.class);
		List<Dept> lst = dao.getDepartments();
		lst.forEach(System.out::println);

	}

}
