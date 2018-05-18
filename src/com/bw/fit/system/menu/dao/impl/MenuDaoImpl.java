package com.bw.fit.system.menu.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bw.fit.system.common.dao.DaoTemplete;
import com.bw.fit.system.menu.dao.MenuDao;
@Repository
public class MenuDaoImpl implements MenuDao {

	@Autowired
	private DaoTemplete daoTemplete;
	
	
}
