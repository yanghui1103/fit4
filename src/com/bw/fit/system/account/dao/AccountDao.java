package com.bw.fit.system.account.dao;

import java.util.List;

import com.bw.fit.system.account.model.Account;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.organization.entity.TOrganization;
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
	/****
	 * 获取其所有的角色
	 * @param logName
	 * @return
	 */
	public List<TRole> getRolesByAccount(String logName);
	/****
	 *查询账号所属组织
	 * @param logName
	 * @return
	 */
	public TOrganization getOrgByAccount(String logName);
	/*****
	 * 根据查询条件,查询到账户资料
	 * @param account
	 * @return
	 */
	public List<Account> getAccounts(Account account);
	/*****
	 * 删除帐户 
	 * @param id
	 * @throws RbackException
	 */
	public void delete(String id) throws RbackException ;
}
