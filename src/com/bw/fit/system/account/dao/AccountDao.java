package com.bw.fit.system.account.dao;

import com.bw.fit.system.account.model.Account;

public interface AccountDao {

	/*****
	 * 获取账号信息
	 * @param id
	 * @return
	 */
	public Account getAccount(String id);
	/*****
	 * 根据登录名，获取账号
	 * @param logName
	 * @return
	 */
	public Account getAccountIdByName(String logName);
}
