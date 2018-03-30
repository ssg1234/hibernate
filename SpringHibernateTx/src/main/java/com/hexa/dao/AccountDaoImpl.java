package com.hexa.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hexa.entity.Account;
@Repository("mydao")
public class AccountDaoImpl implements AccountDao {
	@Autowired
	private SessionFactory sfac;
	

	@Override
	public int addAccount(Account acc) {
		Session sess= sfac.getCurrentSession();
		sess.save(acc);
		return 1;
	}

	@Override
	public int updateAccount(Account acc) {
		Session sess= sfac.getCurrentSession();
		sess.update(acc);
		return 1;
	}
	@Transactional(readOnly = true)
	@Override
	public Account getAccount(int aid) {
		Session sess = sfac.openSession();
		Account acc = sess.get(Account.class, aid);
		sess.close();
		return acc;
	}

}
