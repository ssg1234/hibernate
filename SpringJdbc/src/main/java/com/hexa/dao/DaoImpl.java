package com.hexa.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.hexa.entity.Student;

public class DaoImpl implements IDao {
private JdbcTemplate jtemp;
private RowMapper rmap;


public void setRmap(RowMapper rmap) {
	this.rmap = rmap;
}

//setter for spring IOC to do DI
public void setJtemp(JdbcTemplate jtemp) {
	this.jtemp = jtemp;
}

@Override
public List<Map<String, Object>> getStudentsAsMap(String dept) {
	String sql ="select * from student where dept=?";
	Object[] params = {dept};
	List<Map<String, Object>> lst =jtemp.queryForList(sql,params);
	return lst;
}

@Override
public Map<String, Object> getStudentAsMap(int sid) {
	String sql = "select * from student where stu_id =?";
	Object[] params = {sid};
	Map<String, Object> map = jtemp.queryForMap(sql,params);
	return map;
}

@Override
public int updateMarks(int sid, int marks) {
	String sql = "update student set stu_marks=? where stu_id=?";
	Object[] params= {marks, sid};
	int rows =jtemp.update(sql, params);
	return rows;
}

@Override
public List<Student> getStudents(String dept) {
	String sql ="select * from student where dept=?";
	Object[] params = {dept};
	List<Student> lst = jtemp.query(sql, params, rmap);
	return lst;
}

@Override
public Student getStudent(int sid) {
	String sql = "select * from student where stu_id =?";
	Object[] params = {sid};
	Student stu =(Student) jtemp.queryForObject(sql, params, rmap);
	return stu;
}

}
