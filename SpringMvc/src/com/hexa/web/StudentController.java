package com.hexa.web;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hexa.dao.IDao;
import com.hexa.entity.Student;

@Controller
public class StudentController {
	@Autowired
	private IDao dao;
	@RequestMapping("/students")
	public String displayStudents(@RequestParam("dname") String dept,
			Model model) {
		List<Student> lst = dao.getStudents(dept);
		model.addAttribute("title", "StudentDetails");
		model.addAttribute("slist", lst);
		return "StudentsView";
	}
}
