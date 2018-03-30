package com.hexa.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hexa.dao.IDao;
//@Component("myser")
@Service("myser")
public class SerImpl implements ISer,InitializingBean,DisposableBean {
		public SerImpl() {
			System.out.println("service constructor");
		}
	private  IDao dao;
	
	@Autowired
	//@Qualifier("jdbcdao")
	@Qualifier("hibdao")
	public void setDao(IDao dao) {
		System.out.println("dao is injected");
		this.dao = dao;
	}

	@Override
	public String getData() {
		
		return dao.viewData();
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("destroy");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("After properties set");
	}
	@PostConstruct
	public void myinit() {
		System.out.println("post Construct");
	}
	
	@PreDestroy
	public void myDestroy() {
		System.out.println("pre destroy");
	}
}
