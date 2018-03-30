package com.hexa.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hexa.dao.IDao;
import com.hexa.entity.Student;

@Controller
public class StudentController {
	private Logger logger = LoggerFactory.getLogger("empapp");
	
	@Autowired
	private IDao dao;
	
	@RequestMapping(value="/stufrm", method=RequestMethod.GET)
	public String displayStudentFrm() {
		logger.debug("displaying student form");
		return "StudentFrm";
	}
	@RequestMapping(value="/students", method=RequestMethod.GET)
	public String viewStudents(@RequestParam("cbodept") String dname,
			Model model) {
		logger.debug("inside view Students");
		List<Student> lst = dao.getStudents(dname);
		model.addAttribute("slist", lst);
		logger.info("size of the list" +lst.size());
		return "StudentView";
	}
}
