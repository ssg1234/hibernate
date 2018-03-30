package com.hexa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@Column(name="stu_id")
	private int stuId;
	
	@Column(name="stu_name", length=45)
	private String stuName;
	
	@Column(name="dept", length=20)
	private String dept;
	
	@Column(name="stu_dob")
	private Date dob;
	
	@Column(name="stu_marks")
	private int marks;

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return stuId + " " + stuName + " " + marks + " " + dept + " " + dob;
	}	
}
