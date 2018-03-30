package com.hexa.dao;

public class JdbcDaoImpl implements IDao {
	public JdbcDaoImpl() {
		System.out.println("jdbc dao constructor");
	}
	@Override
	public String viewData() {
		
		return "jdbc";
	}
	

}
