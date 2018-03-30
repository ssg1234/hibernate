package com.hexa.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hexa.entity.Dept;

public class EmpDaoImpl implements EmpDao{
	private SessionFactory sfac;
	
	//setter for Spring IOC to do DI
	public void setSfac(SessionFactory sfac) {
		this.sfac = sfac;
	}


	@Override
	public List<Dept> getDepartments() {
		Session sess = sfac.openSession();
		Query qry= sess.createQuery("from"
				+ " Dept d");
		List<Dept> lst = qry.list();
		return lst;
	}

}
