package com.bw.fit.system.authority.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bw.fit.system.authority.dao.AuthorityDao;
import com.bw.fit.system.authority.entity.TAuthority;
import com.bw.fit.system.common.dao.DaoTemplete;
@Repository
public class AuthorityDaoImpl implements AuthorityDao {
	@Autowired
	private DaoTemplete daoTemplete;
	@Override
	public TAuthority get(String code) {
		return (TAuthority)daoTemplete.getOneData("authoritySql.get", code);
	}

}
