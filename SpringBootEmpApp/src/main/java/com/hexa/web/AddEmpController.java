package com.hexa.web;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.service.spi.ServiceBinding.ServiceLifecycleOwner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hexa.dao.EmpDao;
import com.hexa.dao.IDException;
import com.hexa.entity.Dept;
import com.hexa.entity.Emp;

@Controller
public class AddEmpController {
	
	@Autowired
	private EmpDao dao;
	
	
	private Logger logger = LoggerFactory.getLogger("empapp");
	@RequestMapping("viewimg")
	public String viewImage(@RequestParam("imgname") String img,
					HttpServletResponse resp) throws IOException {
		
		resp.setContentType("image/jpeg");
		FileInputStream fis = new FileInputStream("d:\\photos\\"+ img);
		byte[] arr = new byte[fis.available()];
		fis.read(arr);
		ServletOutputStream out = resp.getOutputStream();
		out.write(arr);
		fis.close();
		return null;
		}
	
	@RequestMapping("/addfrm")
	public String displayAddFrm(Model model) {
		Emp emp = new Emp();
		Dept dept = new Dept();
		emp.setDept(dept);
		model.addAttribute("ebean", emp);
		model.addAttribute("dmap", getDeptAsMap());
		return "AddEmpFrm";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String processAddEmployee(@Valid @ModelAttribute("ebean") Emp emp,
				BindingResult br,
				@RequestParam("fname") MultipartFile file, Model model) throws IOException,
				IDException{
		
		if(br.hasErrors()) {
		logger.debug("validation failed");
		model.addAttribute("dmap", getDeptAsMap());
		return "AddEmpFrm"; 
		}
		
		emp.setImg(emp.getEmpId()+".jpg");
		FileOutputStream fos =new FileOutputStream("d:\\photos\\"+emp.getImg());
		fos.write(file.getBytes());
		fos.close();
		logger.info("image saved");
		dao.addEmployee(emp);
		logger.info("employee added");
		model.addAttribute("msg", "employee added successfully");
		
		return "Main";
	}
	
	/* 
	 * this method is used by displayAddFrm() and processfrm()
	 * It converts list<Dept> to map<deptid,deptname>
	 */
	
	public Map<Integer, String> getDeptAsMap() {
		List<Dept> lst =dao.getDepartments();
		Map<Integer, String> map =new HashMap<>();
		for(Dept d: lst) {
			map.put(d.getDeptId(), d.getDeptName());
		}
		return map;
	}
	@ExceptionHandler(IDException.class)
	public ModelAndView handleRequest(IDException ex) {
		logger.error(ex.getMessage());
		return new ModelAndView("MyErr", "err", ex.getMessage());
	}
	
	@ExceptionHandler(IOException.class)
	public ModelAndView handleRequest(IOException ex) {
		logger.error(ex.getMessage());
		return new ModelAndView("MyErr", "err", ex.getMessage());
	}
}
