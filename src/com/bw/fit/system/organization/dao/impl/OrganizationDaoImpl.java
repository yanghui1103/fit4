package com.bw.fit.system.organization.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bw.fit.system.common.dao.DaoTemplete;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.organization.dao.OrganizationDao;
import com.bw.fit.system.organization.model.Organization;
@Repository
public class OrganizationDaoImpl implements OrganizationDao {

	@Autowired
	private DaoTemplete daoTemplete;
	
	@Override
	public List<Organization> getOrganizations(Organization org) {
		return daoTemplete.getListData("organizationSql.getOrganizations", org);
	}

	@Override
	public void insert(Organization org) throws RbackException {
		daoTemplete.insert("organizationSql.insert", org);
	}

	@Override
	public void update(Organization org) throws RbackException {
		daoTemplete.update("organizationSql.update", org);
	}

	@Override
	public void delete(String id) throws RbackException {
		daoTemplete.update("organizationSql.delete", id);
	}

	@Override
	public Organization get(String id) {
		return (Organization)daoTemplete.getOneData("organizationSql.get", id);
	}

}
