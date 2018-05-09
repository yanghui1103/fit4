package com.bw.fit.system.account.dao;

import com.bw.fit.system.account.model.Account;

public interface AccountDao {

	public Account getAccount(String id);
	
	public String getAccountIdByName(String logName);
}
