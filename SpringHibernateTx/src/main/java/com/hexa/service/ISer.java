package com.hexa.service;

import java.util.List;

import com.hexa.entity.Account;

public interface ISer {
	int addAccounts(List<Account> lst);
	int transferFund(int from, int to, double amt);

}
