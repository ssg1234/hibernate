package com.hexa.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hexa.entity.Student;
@Repository("studao")
public class DaoImpl implements IDao {

	@Autowired
	private SessionFactory sfac;
	@Override
	public List<Student> getStudents() {
		Session sess = sfac.openSession();
		Query qry = sess.createQuery("from Student s");
		List<Student> lst = qry.list();
		sess.close();
		return lst;
	}

	@Override
	public List<Student> getStudents(String dept) {
		Session sess = sfac.openSession();
		Query qry = sess.createQuery("from Student s where dept=?");
		qry.setString(0, dept);
		List<Student> lst = qry.list();
		sess.close();
		return lst;
		
	}

	@Override
	public Student getStudent(int sid) {
		Session sess = sfac.openSession();
		Student stu = sess.get(Student.class, sid);
		sess.close();
		return stu;
	}

	@Override
	public int addStudent(Student stu) throws IDException {
		Session sess = sfac.openSession();
		Transaction tx = sess.beginTransaction();
		try {
			sess.save(stu);
			tx.commit();
		}catch(HibernateException ex) {
			tx.rollback();
			throw new IDException("ID already exists",ex);
		}finally {
			sess.close();
		}
		return 1;
	}
	
}
