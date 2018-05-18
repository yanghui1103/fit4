package com.bw.fit.system.account.service;

import com.bw.fit.system.account.model.Account;

public interface AccountService {

	/****
	 * 根据登录名获取账号信息 
	 * @param logName
	 * @return
	 */
	public Account getAccountByLogName(String logName);
}
