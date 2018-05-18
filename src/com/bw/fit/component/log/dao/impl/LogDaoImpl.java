package com.bw.fit.component.log.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bw.fit.system.common.dao.DaoTemplete;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.component.log.dao.LogDao;
import com.bw.fit.component.log.model.LogInfo;

/****
 * 日志组件：持久层实现类
 * @author yangh
 *
 */
@Repository
public class LogDaoImpl implements LogDao {

	@Autowired
	private DaoTemplete daoTemplete ;

	@Override
	public void insert(LogInfo l) throws RbackException {
		// TODO Auto-generated method stub
		
	}
	
	
}
