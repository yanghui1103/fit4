package com.bw.fit.system.role.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.common.util.PubFun;
import com.bw.fit.system.role.dao.RoleDao;
import com.bw.fit.system.role.entity.TRole;
import com.bw.fit.system.role.model.Role;
import com.bw.fit.system.role.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	
	@Override
	public JSONObject delete(String id) throws RbackException {
		JSONObject json = new JSONObject();
		try{
			roleDao.delete(id);
			PubFun.returnSuccessJson(json);
		}catch(RbackException ex){
			json = new JSONObject();
			PubFun.returnFailJson(json, ex.getMsg());
			throw ex;
		}finally{
			return json;
		}
	}

	@Override
	public JSONObject insert(Role role) throws RbackException {
		JSONObject json = new JSONObject();
		try{
			TRole t = new TRole();
			PubFun.copyProperties(t, role);
			roleDao.insert(t);
			PubFun.returnSuccessJson(json);
		}catch(RbackException ex){
			json = new JSONObject();
			PubFun.returnFailJson(json, ex.getMsg());
			throw ex;
		}finally{
			return json;
		}
	}

}
