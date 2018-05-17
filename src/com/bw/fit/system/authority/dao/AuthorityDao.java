package com.bw.fit.system.authority.dao;

import com.bw.fit.system.authority.entity.TAuthority;

public interface AuthorityDao {

	/***
	 * 获取功能权限
	 * @param code
	 * @return
	 */
	public TAuthority get(String code);
}
