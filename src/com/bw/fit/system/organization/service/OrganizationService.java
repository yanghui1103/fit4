package com.bw.fit.system.organization.service;

import java.util.*;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.organization.model.Organization;

public interface OrganizationService {

	/****
	 * 新增组织
	 * @param org
	 * @return
	 * @throws RbackException
	 */
	public JSONObject add(Organization org) throws RbackException ;
}
