package com.hexa.dao;

import java.util.List;

import com.hexa.entity.Student;

public interface IDao {
	List<Student> getStudents();
	List<Student> getStudents(String dept);
	Student getStudent(int sid); 
	int addStudent(Student stu) throws IDException;
}
