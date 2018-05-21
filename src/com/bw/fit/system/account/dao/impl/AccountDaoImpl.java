package com.bw.fit.system.account.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bw.fit.system.account.dao.AccountDao;
import com.bw.fit.system.account.model.Account;
import com.bw.fit.system.common.dao.DaoTemplete;
import com.bw.fit.system.common.util.PubFun;
import com.bw.fit.system.organization.entity.TOrganization;
import com.bw.fit.system.role.entity.TRole;
import com.bw.fit.system.user.model.User;
import com.bw.fit.system.user.service.UserService;
@Repository
public class AccountDaoImpl implements AccountDao {

	@Autowired
	private DaoTemplete daoTemplete;
	@Autowired
	private UserService userService;
	@Override
	public Account getAccount(String id) {
		return (Account)daoTemplete.getOneData("accountSql.getAccount", id);
	}

	@Override
	public Account getAccountByName(String logName) {
		Account account = new Account();
		account =  (Account)daoTemplete.getOneData("accountSql.getAccountIdByName", logName);
		String tempId = account.getId();
		User user = userService.get(account.getUserId());
		PubFun.copyProperties(account, user);
		account.setId(tempId);
		TOrganization org = getOrgByAccount(logName);
		account.setCurrentOrgId(org.getId());
		return account; 
	}

	@Override
	public List<TRole> getRolesByAccount(String logName) {
		return daoTemplete.getListData("accountSql.getRolesByAccount", logName);
	}

	@Override
	public TOrganization getOrgByAccount(String logName) {
		return (TOrganization)daoTemplete.getOneData("accountSql.getOrgByAccount", logName);
	}

	@Override
	public List<Account> getAccounts(Account account) {
		return daoTemplete.getListData("accountSql.getAccounts", account);
	}

}
