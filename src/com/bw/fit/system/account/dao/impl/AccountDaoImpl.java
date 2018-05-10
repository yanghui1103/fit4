package com.bw.fit.system.account.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bw.fit.system.account.dao.AccountDao;
import com.bw.fit.system.account.model.Account;
import com.bw.fit.system.common.dao.DaoTemplete;
@Repository
public class AccountDaoImpl implements AccountDao {

	@Autowired
	private DaoTemplete daoTemplete;
	@Override
	public Account getAccount(String id) {
		return (Account)daoTemplete.getOneData("accountSql.getAccount", id);
	}

	@Override
	public Account getAccountIdByName(String logName) {
		return (Account)daoTemplete.getOneData("accountSql.getAccountIdByName", logName);
	}

}
