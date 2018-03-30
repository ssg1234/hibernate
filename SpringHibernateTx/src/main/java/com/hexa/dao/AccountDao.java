package com.hexa.dao;

import com.hexa.entity.Account;

public interface AccountDao {
	 int addAccount(Account acc);
	 int updateAccount(Account acc);
	 Account getAccount(int aid);
}
