package com.bw.fit.system.dict.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bw.fit.system.common.dao.DaoTemplete;
import com.bw.fit.system.dict.dao.DictDao;
import com.bw.fit.system.dict.model.DataDict;
import com.bw.fit.system.dict.model.Dict;
@Repository
public class DictDaoImpl implements DictDao {

	@Autowired
	private DaoTemplete daoTemplete;
	@Override
	public Dict getDictByValue(String value) {
		return (Dict)daoTemplete.getOneData("dictSql.getDictByValue", value);
	}
	@Override
	public String getIdByDictValue(String value) {
		return (String)daoTemplete.getOneData("dictSql.getIdByDictValue", value);
	}
	@Override
	public List<DataDict> getDictsByParentId(String parentId) {
		return daoTemplete.getListData("dictSql.getDictsByParentId", parentId);
	}

}
