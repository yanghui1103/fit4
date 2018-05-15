package com.bw.fit.system.position.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bw.fit.system.dict.dao.DictDao;
import com.bw.fit.system.dict.model.DataDict;
import com.bw.fit.system.position.dao.PositionDao;
import com.bw.fit.system.position.model.Position;
import com.bw.fit.system.position.service.PositionService;
@Service
public class PositionServiceImpl implements PositionService{
	@Autowired
	private PositionDao positionDao ;
	

}
