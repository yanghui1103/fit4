package com.bw.fit.system.user.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.dao.DaoTemplete;
import com.bw.fit.system.user.dao.UserDao; 
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private DaoTemplete daoTemplete ; 
}
