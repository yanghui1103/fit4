package com.bw.fit.system.position.dao.impl;

import java.util.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bw.fit.system.common.dao.DaoTemplete;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.position.dao.PositionDao;
import com.bw.fit.system.position.entity.TOrganization2Position;
import com.bw.fit.system.position.model.Position;
@Repository
public class PositionDaoImpl implements PositionDao{
	@Autowired
	private DaoTemplete daoTemplete;
	@Override
	public List<Position> getPositions(Position position,String orgId) {
		Map<String,String> map = new HashMap<>();
		map.put("start_num",String.valueOf(position.getStart_num()));
		map.put("end_num",String.valueOf(position.getEnd_num()));
		map.put("orgId",orgId);
		return daoTemplete.getListData("positionSql.getPositions", map);
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

	@Override
	public void insertOrg2Position(TOrganization2Position organization2Position) throws RbackException {
		daoTemplete.insert("positionSql.insertOrg2Position", organization2Position);
	}

}
