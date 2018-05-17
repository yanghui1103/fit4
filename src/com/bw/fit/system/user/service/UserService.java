package com.bw.fit.system.user.service;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.user.model.User;

public interface UserService {

	/***
	 * 新增用户
	 * @param user
	 * @return
	 * @throws RbackException
	 */
	public JSONObject add(User user) throws RbackException ;
}
