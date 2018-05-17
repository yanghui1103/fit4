package com.bw.fit.system.account.dao;

import java.util.List;

import com.bw.fit.system.account.model.Account;
import com.bw.fit.system.role.entity.TRole;

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
	public Account getAccountByName(String logName);
	
	public List<TRole> getRolesByAccount(String logName);
}
