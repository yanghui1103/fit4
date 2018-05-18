package com.bw.fit.system.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bw.fit.system.account.dao.AccountDao;
import com.bw.fit.system.account.model.Account;
import com.bw.fit.system.account.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao ;
	
	@Override
	public Account getAccountByLogName(String logName) {
		return accountDao.getAccountByName(logName);
	}

}
