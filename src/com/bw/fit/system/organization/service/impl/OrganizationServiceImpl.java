package com.bw.fit.system.organization.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.common.util.PubFun;
import com.bw.fit.system.organization.dao.OrganizationDao;
import com.bw.fit.system.organization.model.Organization;
import com.bw.fit.system.organization.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationDao organizationDao ;
	
	
	@Override
	public JSONObject add(Organization org) throws RbackException {
		JSONObject json = new JSONObject();
		try{
			organizationDao.insert(org);
			PubFun.returnSuccessJson(json);
		}catch(RbackException ex){
			json = new JSONObject();
			PubFun.returnFailJson(json, ex.getMsg());
		}finally{
			return json;
		}
	}


	@Override
	public JSONObject delete(String id) throws RbackException {
		JSONObject json = new JSONObject();
		try{
			organizationDao.delete(id);
			PubFun.returnSuccessJson(json);
		}catch(RbackException ex){
			json = new JSONObject();
			PubFun.returnFailJson(json, ex.getMsg());
		}finally{
			return json;
		}
	}


}
