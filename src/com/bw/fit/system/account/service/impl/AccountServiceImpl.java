package com.bw.fit.system.account.service.impl;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bw.fit.system.account.dao.AccountDao;
import com.bw.fit.system.account.model.Account;
import com.bw.fit.system.account.service.AccountService;
import com.bw.fit.system.menu.model.Menu;
import com.bw.fit.system.role.dao.RoleDao;
import com.bw.fit.system.role.entity.TRole;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao ;
	@Autowired
	private RoleDao roleDao ;
	
	@Override
	public Account getAccountByLogName(String logName) {
		return accountDao.getAccountByName(logName);
	}

	@Override
	public List<Menu> getMenusOfThisAccount(String logName) {
		List<Menu> menus = new ArrayList<>();
		List<TRole> roles = accountDao.getRolesByAccount(logName);
		for(TRole t:roles){
			List<Menu> ms = roleDao.getMenusByRole(t.getId());
			for(Menu m:ms){
				menus.add(m);
			}
		}
		return menus.stream().distinct().collect(Collectors.toList());
	}

}
