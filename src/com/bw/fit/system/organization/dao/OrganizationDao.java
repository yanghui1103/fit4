package com.bw.fit.system.organization.dao;

import java.util.List;

import com.bw.fit.system.organization.model.Organization;

public interface OrganizationDao {

	/*****
	 * 根据组织字段条件获取组织
	 * @param org 组织
	 * @return
	 */
	public List<Organization> getOrganizations(Organization org );
}
