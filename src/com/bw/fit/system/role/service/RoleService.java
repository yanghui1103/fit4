package com.bw.fit.system.role.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.role.model.Role;

public interface RoleService {

	/****
	 * 作废角色
	 * @param id
	 * @return
	 * @throws RbackException
	 */
	public JSONObject delete(String id) throws RbackException;
	/*****
	 * 增加
	 * @param role
	 * @return
	 * @throws RbackException
	 */
	public JSONObject insert(Role role) throws RbackException;
	
}
