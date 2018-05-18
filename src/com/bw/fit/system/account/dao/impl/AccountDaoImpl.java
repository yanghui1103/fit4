package com.bw.fit.system.account.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bw.fit.system.account.dao.AccountDao;
import com.bw.fit.system.account.model.Account;
import com.bw.fit.system.common.dao.DaoTemplete;
import com.bw.fit.system.role.entity.TRole;
@Repository
public class AccountDaoImpl implements AccountDao {

	@Autowired
	private DaoTemplete daoTemplete;
	@Override
	public Account getAccount(String id) {
		return (Account)daoTemplete.getOneData("accountSql.getAccount", id);
	}

	@Override
	public Account getAccountByName(String logName) {
		return (Account)daoTemplete.getOneData("accountSql.getAccountIdByName", logName);
	}

	@Override
	public List<TRole> getRolesByAccount(String logName) {
		return daoTemplete.getListData("accountSql.getRolesByAccount", logName);
	}

}
