package com.hexa.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaxController {
	
	private Logger logger = LoggerFactory.getLogger("empapp");
	
	@RequestMapping("/taxfrm")
	public String displayTaxFrm() {
		logger.debug("inside display frm");
		return "TaxFrm";
	}
	@RequestMapping("/tax")
	public String CalcTax(@RequestParam("txtincome") double income,
					Model model) {
		logger.debug("inside calc tax");
		double tax = 0;
		if(income >1000000) 
		tax = 750000 * 0.1 + (income -1000000) * 0.15;
		
		else if(income > 250000)
			tax = (income - 250000) * 0.1;
			model.addAttribute("taxresult", tax);
			
			logger.info("tax to be paid" + tax);
		return "TaxResult";
	}
}
