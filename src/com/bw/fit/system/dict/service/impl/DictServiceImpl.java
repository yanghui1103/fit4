package com.bw.fit.system.dict.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bw.fit.system.dict.dao.DictDao;
import com.bw.fit.system.dict.model.DataDict;
import com.bw.fit.system.dict.model.Dict;
import com.bw.fit.system.dict.model.treeHandler.DataDictJsonTreeHandler;
import com.bw.fit.system.dict.service.DictService;

@Service
public class DictServiceImpl implements DictService {

	@Autowired
	private DictDao dictDao ;
	
	@Override
	public DataDict getDictsByParentValue(String value) {
		return null ;
		
	}

	
}
