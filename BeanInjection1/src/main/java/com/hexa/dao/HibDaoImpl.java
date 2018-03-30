package com.hexa.dao;

public class HibDaoImpl implements IDao{
	public HibDaoImpl() {
		System.out.println("hibernate constructor");
	}
	@Override
	public String viewData() {
		
		return "hibernate";
	}
	
}
