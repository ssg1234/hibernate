package com.hexa.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.hexa.dao.Empdao;
import com.hexa.entity.Student;

public class SerImpl implements Iser {
	private Empdao dao;
	
	//setter for spring IOC to do DI
	public void setDao(Empdao dao) {
		this.dao = dao;
	}


	@Override
	public List<Student> orderByMarks() {
		Comparator<Student> c = 
				(s1,s2)->{Integer m1=s1.getMarks();
							Integer m2 =s2.getMarks();
							return m1.compareTo(m2);
				};
				
		List<Student> lst =dao.getStudents().stream()
				.sorted(c).collect(Collectors.toList());
		return lst;
	}

}
