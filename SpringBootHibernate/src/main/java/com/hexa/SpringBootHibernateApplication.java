package com.hexa;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import com.hexa.dao.IDao;
import com.hexa.entity.Student;

@SpringBootApplication
@EntityScan("com.hexa.entity")
public class SpringBootHibernateApplication 
				implements CommandLineRunner{
	
	@Autowired
	private EntityManagerFactory emf;
	
	@Autowired
	private IDao dao;
	
	@Bean
	public SessionFactory getSessionFactory() {
		return emf.unwrap(SessionFactory.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernateApplication.class, args);
	}
	@Override
	public void run(String... arg0) throws Exception {
		List<Student> lst =dao.getStudents();
		lst.forEach(System.out::println);
		
	}
}
