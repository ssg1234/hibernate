package com.hexa.dao;


import org.springframework.stereotype.Repository;
//@Component("jdbcdao")
@Repository("jdbcdao")
public class JdbcDaoImpl implements IDao {
	public JdbcDaoImpl() {
		System.out.println("jdbc dao constructor");
	}
	@Override
	public String viewData() {
		
		return "jdbc";
	}
	

}
