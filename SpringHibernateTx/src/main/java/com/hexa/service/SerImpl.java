package com.hexa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hexa.dao.AccountDao;
import com.hexa.entity.Account;
@Service("myser")
public class SerImpl implements ISer {
	
	@Autowired
	private AccountDao dao;
	
	@Transactional(readOnly=false)
	@Override
	public int addAccounts(List<Account> lst) {
		for(Account acc: lst) {
			dao.addAccount(acc);
		}
		return 1;
	}
	@Transactional(readOnly=false)
	@Override
	public int transferFund(int from, int to, double amt) {
		Account facc = dao.getAccount(from);
		Account tacc = dao.getAccount(to);
		if(facc.getBal() < amt)
		return 0;
		
		facc.setBal(facc.getBal()-amt);
		tacc.setBal(tacc.getBal()+amt);
		dao.updateAccount(facc);
		dao.updateAccount(tacc);
		return 1;
		
	}

}
