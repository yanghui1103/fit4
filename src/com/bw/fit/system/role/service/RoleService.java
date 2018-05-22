package com.bw.fit.system.role.service;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.model.RbackException;

public interface RoleService {

	/****
	 * 作废角色
	 * @param id
	 * @return
	 * @throws RbackException
	 */
	public JSONObject delete(String id) throws RbackException;
}
