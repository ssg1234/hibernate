package com.hexa.client;

import java.io.Serializable;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hexa.dao.IDao;
import com.hexa.entity.Student;

public class ViewStudent {
	private static ApplicationContext ctx;
	static{
		
		ctx = new ClassPathXmlApplicationContext("spring-jdbc.xml");
	}

	public static void main(String[] args) {
		System.out.println("inside main");
		IDao dao = ctx.getBean("mydao", IDao.class);
		List<Student> lst =dao.getStudents("ece");
		for(Student stu: lst) {
			System.out.println(stu);
		}
		
		System.out.println("---------view by student id using row mapper---------");
		System.out.println(dao.getStudent(1004));
}
}
	
	
