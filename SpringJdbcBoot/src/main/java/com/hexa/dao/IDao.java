package com.hexa.dao;

import java.util.List;
import java.util.Map;

import com.hexa.entity.Student;

public interface IDao {
	List<Map<String, Object>> getStudentsAsMap(String dept);
	Map<String, Object> getStudentAsMap(int sid);
	int updateMarks(int sid, int marks);
	List<Student> getStudents(String dept);
	Student getStudent(int sid);
}
