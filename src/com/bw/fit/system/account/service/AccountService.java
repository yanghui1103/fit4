package com.bw.fit.system.account.service;

import java.util.*;

import com.bw.fit.system.account.model.Account;
import com.bw.fit.system.menu.model.Menu;

public interface AccountService {

	/****
	 * 根据登录名获取账号信息 
	 * @param logName
	 * @return
	 */
	public Account getAccountByLogName(String logName);
	/*****
	 * 根据账号查询拥有的所有菜单
	 * @param logName 账号
	 * @return
	 */
	public List<Menu> getMenusOfThisAccount(String logName);
}
