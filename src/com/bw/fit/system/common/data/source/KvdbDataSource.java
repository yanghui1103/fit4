package com.bw.fit.system.common.data.source;

import com.bw.fit.system.common.model.RbackException;

public interface KvdbDataSource {

	public void set(String key ,Object value) throws RbackException;
	public String get(String key);
	public void del(String key) throws RbackException;
	
}
