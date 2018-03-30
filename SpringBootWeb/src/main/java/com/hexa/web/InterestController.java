package com.hexa.web;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hexa.entity.Interest;

@Controller
public class InterestController {
	Logger logger =LoggerFactory.getLogger("empapp");
	
	@RequestMapping(value="/compfrm", method=RequestMethod.GET)
	public String displayFrm(Model model) {
		
		model.addAttribute("ibean", new Interest());
		return "InterestFrm";
	}
	
	@RequestMapping(value="/calccomp", method=RequestMethod.POST)
	public String calcComp(@Valid @ModelAttribute("ibean") Interest form,
			BindingResult br, Model model) {
		
		if(br.hasErrors())
			return "InterestFrm";
		double res = form.getAmt() * 
				Math.pow((1 + form.getRate()/100),
				form.getYears())- form.getAmt();
		model.addAttribute("ci", res);
		
		return "InterestView";
	}
}
