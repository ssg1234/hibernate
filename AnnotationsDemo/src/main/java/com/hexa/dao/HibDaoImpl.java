package com.hexa.dao;

import org.springframework.stereotype.Component;

@Component("hibdao")
public class HibDaoImpl implements IDao{
	public HibDaoImpl() {
		System.out.println("hibernate constructor");
	}
	@Override
	public String viewData() {
		
		return "hibernate";
	}
	
}
