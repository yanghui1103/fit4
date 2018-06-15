package com.bw.fit.component.warn.dao;

import java.util.List;

import com.bw.fit.component.warn.entity.TWarn;

public interface WarnDao {

	/****
	 * 获取通知列表
	 * @param tw
	 * @return
	 */
	public List<TWarn> all(TWarn tw);
	
}
