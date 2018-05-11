package com.bw.fit.system.dict.dao;

import com.bw.fit.system.dict.model.Dict;

public interface DictDao {

	public Dict getDictByValue(String value);
}
