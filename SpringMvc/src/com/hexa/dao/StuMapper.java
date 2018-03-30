package com.hexa.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hexa.entity.Student;

public class StuMapper implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int idx) 
			throws SQLException {
		Student stu = new Student();
		stu.setSid(rs.getInt("stu_id"));
		stu.setSname(rs.getString("stu_name"));
		stu.setMarks(rs.getInt("stu_marks"));
		stu.setDept(rs.getString("dept"));
		stu.setDob(rs.getDate("stu_dob"));
		return stu;
	}
}
