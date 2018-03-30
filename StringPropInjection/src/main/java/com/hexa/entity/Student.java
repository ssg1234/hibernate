package com.hexa.entity;

public class Student {
	private int sid;
	private String sname;
	private int marks;
	
	public Student(int sid, String sname, int marks) {
		this.sid = sid;
		this.sname = sname;
		this.marks = marks;
	}

	public int getSid() {
		return sid;
	}

	public String getSname() {
		return sname;
	}

	public int getMarks() {
		return marks;
	}

	@Override
	public String toString() {
		return sid + " " + sname + " " + marks;
	}
	
	
	
	
}
