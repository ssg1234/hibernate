package com.hexa.dao;

import java.util.List;

import com.hexa.entity.Student;

public interface IDao {
	Student getStudent(int sid);
	List<Student> getStudents(String dept);
	int addStudent(Student stu);
	int removeStudent(int sid);
	int updateStudent(Student stu);
}
