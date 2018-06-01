package com.bw.fit.system.account.service.impl;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.account.dao.AccountDao;
import com.bw.fit.system.account.model.Account;
import com.bw.fit.system.account.service.AccountService;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.common.util.PropertiesUtil;
import com.bw.fit.system.common.util.PubFun;
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
				if(!"".equals(m.getHref())){
					m.setHref(PropertiesUtil.getValueByKey("system.default.url")+m.getHref());
				}
				menus.add(m);
			}
			/****
			 * 加入首页
			 */
		}
		return menus.stream().distinct().collect(Collectors.toList());
	}

	@Override
	public JSONObject delete(String id) throws RbackException {
		JSONObject json = new JSONObject();		
		try {
			accountDao.delete(id);
			PubFun.returnSuccessJson(json);
		} catch (RbackException e) {
			e.printStackTrace();
			json = new JSONObject();		
			PubFun.returnFailJson(json, e.getMsg());
			throw e;
		}finally{
			return json ;
		}
	}

	@Override
	public JSONObject insert(Account account) throws RbackException {
		JSONObject json = new JSONObject();
		
		try {
			account.setLogPwd(PubFun.getUserPasswordShiro(account.getLogName(), PropertiesUtil.getValueByKey("user.default.pwd"),
					"MD5", 10));
			accountDao.insert(account);		
			accountDao.insertAccount2Org(account.getId(), account.getCurrentOrgId());
			String pos = account.getPositionIds();
			if(pos!=null&&!"".equals(pos)){
				String[] poss = pos.split(",");
				for(String s :poss){
					accountDao.insertAccount2Position(account.getId(), s);
				}
			}
			String roles = account.getRoleIds();
			if(!"".equals(roles)){
				String[] roless = roles.split(",");
				for(String s :roless){
					accountDao.insertAccount2Role(account.getId(), s);
				}
			}
			PubFun.returnSuccessJson(json);
		} catch (RbackException e) {
			json = new JSONObject();
			PubFun.returnFailJson(json, e.getMsg());
			e.printStackTrace();
			throw e;
		}
		
		return json ;
	}

}
