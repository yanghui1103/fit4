package com.bw.fit.system.address.dao;

import java.util.List;

import com.bw.fit.system.address.entity.VAddress;

public interface AddressDao {
	/***
	 * 根据underOrgId和addressType获取地址
	 * @param addressType类型
	 * @param underOrgId组织id
	 * @return
	 */
	public List<VAddress> getAddress(String addressType,String underOrgId);
	
	/***
	 * 根据id获取地址
	 * @param id
	 * @return
	 */
	public VAddress get (String id);
}
