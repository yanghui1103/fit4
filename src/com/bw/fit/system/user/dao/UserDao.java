package com.bw.fit.system.user.dao;

import java.util.*;

import com.alibaba.fastjson.JSONObject; 
import com.bw.fit.system.user.entity.TUser;

/****
 * 用户持久层
 * @author yangh
 *
 */
public interface UserDao {

	/****
	 * 获取用户列表
	 * @param u
	 * @return
	 */
	public List<TUser> getUsers(TUser u);
	
	public TUser get(String id);
}
