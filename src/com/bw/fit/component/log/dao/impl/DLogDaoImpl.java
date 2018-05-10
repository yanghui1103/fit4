package com.bw.fit.component.log.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bw.fit.system.common.dao.DaoTemplete;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.component.log.dao.DLogDao;
import com.bw.fit.component.log.entity.TLogInfo;
import com.bw.fit.component.log.model.LogInfo;

/****
 * 日志组件：持久层实现类
 * @author yangh
 *
 */
@Repository
public class DLogDaoImpl implements DLogDao {

	@Autowired
	private DaoTemplete daoTemplete ;
	@Override
	public void notice(TLogInfo l) throws RbackException {
		daoTemplete.insert("logSql.createLog", l);
	}

	@Override
	public TLogInfo getLogInfoById(String fdid) {
		return (TLogInfo) daoTemplete.getOneData("logSql.getLogInfoById", fdid);
	}

	@Override
	public List<String> getFdidByInfo(TLogInfo l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TLogInfo> getLogAll(TLogInfo f) {
		List<TLogInfo> list = daoTemplete.getListData("logSql.getLogAll", f);
		return list ;
	}

}
