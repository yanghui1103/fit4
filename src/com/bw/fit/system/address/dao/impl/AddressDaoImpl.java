package com.bw.fit.system.address.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bw.fit.system.address.dao.AddressDao;
import com.bw.fit.system.address.entity.VAddress;
import com.bw.fit.system.common.dao.DaoTemplete;
import com.bw.fit.system.position.model.Position;
@Repository
public class AddressDaoImpl implements AddressDao{
	@Autowired
	private DaoTemplete daoTemplete;
	@Override
	public List<VAddress> getAddress(String addressType, String underOrgId) {
		
		Map<String,String> map = new HashMap<>();
		map.put("addressType",addressType);
		map.put("underOrgId",underOrgId);
		return daoTemplete.getListData("addressSql.getAddress", map);
	}
	@Override
	public VAddress get(String id) {
		return (VAddress)daoTemplete.getOneData("addressSql.get", id);
	}

}
