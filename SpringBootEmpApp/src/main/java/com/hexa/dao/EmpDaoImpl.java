package com.hexa.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hexa.entity.Dept;
import com.hexa.entity.Emp;
@Repository("mydao")
public class EmpDaoImpl implements EmpDao{
	
	Logger logger = LoggerFactory.getLogger("empapp");
	
	private SessionFactory sfac;
	
	//setter for Spring IOC to do DI
	@Autowired
	public void setSfac(SessionFactory sfac) {
		logger.info("session factory is injected");
		this.sfac = sfac;
	}


	@Override
	public List<Dept> getDepartments() {
		logger.debug("inside method");
		Session sess = sfac.openSession();
		Query qry= sess.createQuery("from Dept d");
		List<Dept> lst = qry.list();
		sess.close();
		logger.info("fetched size " +lst.size());
		return lst;
	}


	@Override
	public List<Emp> getEmployees() {
		logger.debug("inside method");
		Session sess = sfac.openSession();
		Query qry= sess.createQuery("from Emp e left join fetch e.dept");
		List<Emp> lst = qry.list();
		sess.close();
		logger.info("fetched all employees " +lst.size());
		return lst;
		
	}


	@Override
	public List<Emp> getEmployees(int did) {
		logger.debug("inside method");
		Session sess = sfac.openSession();
		String hql= "from Emp e left join fetch e.dept where e.dept.deptId= ? ";
		Query qry= sess.createQuery(hql);
		qry.setInteger(0, did);
		List<Emp> lst = qry.list();
		sess.close();
		logger.info("fetched employee by deptId " + did +lst.size());
		return lst;
	}


	@Override
	public Emp getEmployee(int eid) throws NotFoundException{
		logger.debug("inside method");
		Session sess = sfac.openSession();
		String hql= "from Emp e left join fetch e.dept where e.empId= ? ";
		Query qry= sess.createQuery(hql);
		qry.setInteger(0, eid);
		Emp emp =(Emp) qry.uniqueResult();
		sess.close();
		if(emp == null) { 
			logger.error("Not found exception raised");
		 throw new NotFoundException("Employee not found for Id "+ eid);
		}
		logger.info(emp.toString());
		return emp;
	}


	@Override
	public int addEmployee(Emp emp) throws IDException{
		logger.debug("inside method");
		Session sess = sfac.openSession();
		Transaction tx =sess.beginTransaction();
		try {
			sess.save(emp);
			tx.commit();
			logger.info("employee inserted");
			return 1;	
		} catch(HibernateException ex) {
			tx.rollback();
			logger.error("IDException raised" +ex.getMessage());
			throw new IDException("Employee id already exist");
		}
		finally {
			sess.close();
		}
	}
}
