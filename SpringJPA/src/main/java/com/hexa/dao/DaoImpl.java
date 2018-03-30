package com.hexa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hexa.entity.Student;
@Repository("mydao")
public class DaoImpl implements IDao{
	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public Student getStudent(int sid) {
		Student stu = em.find(Student.class, sid);
		return stu;
	}

	@Override
	public List<Student> getStudents(String dept) {
		Query qry =em.createQuery("from Student s where s.dept=?");
		qry.setParameter(1, dept);
		List<Student> lst = qry.getResultList();
		return lst;
	}
	@Transactional(readOnly=false)
	@Override
	public int addStudent(Student stu) {
		em.persist(stu);
		return 1;
	}
	@Transactional(readOnly=false)
	@Override
	public int removeStudent(int sid) {
		Student stu = em.find(Student.class, sid);
		em.remove(stu);
		return 1;
	}
	@Transactional(readOnly=false)
	@Override
	public int updateStudent(Student stu) {
		em.merge(stu);
		return 0;
	}

}
