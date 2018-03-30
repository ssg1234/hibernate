package com.hexa.service;

import com.hexa.dao.IDao;

public class SerImpl implements ISer {
		public SerImpl() {
			System.out.println("service constructor");
		}
	private  IDao dao;
	
	public void setDao(IDao dao) {
		System.out.println("dao is injected");
		this.dao = dao;
	}

	@Override
	public String getData() {
		
		return dao.viewData();
	}

}
