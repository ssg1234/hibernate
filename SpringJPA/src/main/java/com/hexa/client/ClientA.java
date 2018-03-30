package com.hexa.client;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hexa.dao.IDao;
import com.hexa.entity.Student;


public class ClientA {
	private static ApplicationContext ctx;
	static{
		
		ctx = new AnnotationConfigApplicationContext(JPAConfig.class);
	}

	public static void main(String[] args) throws ParseException{
		System.out.println("inside main");
		IDao dao = ctx.getBean("mydao", IDao.class);
		System.out.println(dao.getStudent(1001));
		
		System.out.println("add student");
		Student stu = new Student();
		stu.setStuId(1008);
		stu.setStuName("Ayushi");
		stu.setMarks(90);
		stu.setDept("cse");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dt =sdf.parse("10/06/1995");
		stu.setDob(dt);
		int res = dao.addStudent(stu);
		System.out.println("inserted :" + res + " rows");	
	}
	}
