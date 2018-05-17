package com.bw.fit.system.position.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bw.fit.system.common.dao.DaoTemplete;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.position.dao.PositionDao;
import com.bw.fit.system.position.model.Position;
@Repository
public class PositionDaoImpl implements PositionDao{
	@Autowired
	private DaoTemplete daoTemplete;
	@Override
	public List<Position> getPositions(Position position) {
		return daoTemplete.getListData("positionSql.getPositions", position);
	}

	@Override
	public void insert(Position position) throws RbackException {
		daoTemplete.insert("positionSql.insert", position);
	}

	@Override
	public void update(Position position) throws RbackException {
		daoTemplete.update("positionSql.update", position);
	}

	@Override
	public void delete(String id) throws RbackException {
		daoTemplete.update("positionSql.delete", id);
	}

	@Override
	public List<String> getOrgByPositionId(String positionId){
		return daoTemplete.getListData("positionSql.getOrgsByPositionId", positionId);
	}

}
