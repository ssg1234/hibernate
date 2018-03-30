package com.hexa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hexa.service.ISer;

@SpringBootApplication
public class SpringBootStandAloneApplication 
   					implements CommandLineRunner {
	@Autowired
	private ISer ser;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStandAloneApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println(ser.calcSimple(5000, 2));
		
	}
}
