package com.hexa.client;


import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hexa.dao.IDao;


public class ClientA {
	private static ApplicationContext ctx;
	static{
		
		ctx = new AnnotationConfigApplicationContext(JdbcConfig.class);
	}

	public static void main(String[] args) {
		System.out.println("inside main");
		IDao dao = ctx.getBean("mydao", IDao.class);
		
		System.out.println("find by student Id");
		Map<String, Object> map1 =dao.getStudentAsMap(1004);
		System.out.println(map1.get("stu_id"));
		System.out.println(map1.get("stu_name"));
		System.out.println(map1.get("stu_marks"));
		System.out.println(map1.get("dept"));
		System.out.println(map1.get("stu_dob"));
		System.out.println("********************************");
		System.out.println("-------------------------------");
		
		
		System.out.println("view all student by dept");
		List<Map<String, Object>> lst = dao.getStudentsAsMap("ece");
		for(Map map: lst) {
			System.out.println(map.get("stu_id"));
			System.out.println(map.get("stu_name"));
			System.out.println(map.get("stu_marks"));
			System.out.println(map.get("dept"));
			System.out.println(map.get("stu_dob"));
			System.out.println("********************************");
		
		}
		
	}
}
