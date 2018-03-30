package com.hexa.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.hexa.entity.Student;

public class FileDaoImpl implements Empdao{
	private String fname;
	
	
	public void setFname(String fname) {
		this.fname = fname;
	}

	@Override
	public List<Student> getStudents() {
		List<Student> lst = new ArrayList<Student>();
		String str = null;
		String [] arr =null;
		Student stu =null;
		try(
		BufferedReader br = new BufferedReader(new FileReader(fname))){
			while((str = br.readLine()) != null)
            {
                arr = str.split(",");
                stu = new Student(Integer.parseInt(arr[0]),
                		arr[1],Integer.parseInt(arr[2]));
                lst.add(stu);
            }
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return lst;
	}

}
