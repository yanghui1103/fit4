package com.bw.fit.system.log.service.impl;

import static com.bw.fit.system.common.util.PubFun.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.dao.DaoTemplete;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.common.util.PubFun;
import com.bw.fit.system.log.dao.DLogDao;
import com.bw.fit.system.log.entity.TLogInfo;
import com.bw.fit.system.log.model.LogInfo;
import com.bw.fit.system.log.service.ILogService;  

@Service
public class ILogServiceImpl implements ILogService {

	@Autowired
	private DLogDao dLogDao ; 
	
	@Override
	public JSONObject notice(TLogInfo l) throws RbackException {
		JSONObject j = new JSONObject();
		returnSuccessJson(j);
		try{
			dLogDao.notice(l);
		}catch(RbackException e){
			j = new JSONObject();
			returnFailJson(j,e.getMsg());
			throw e;
		}finally{
			return j ;
		}
	
	}

	@Override
	public LogInfo getLogInfoById(String fdid) {
		// TODO Auto-generated method stub
		LogInfo logInfo = new LogInfo();		
		TLogInfo t = dLogDao.getLogInfoById(fdid);
		copyProperties(logInfo, t);
		return logInfo ;
	}

	@Override
	public List<String> getFdidByInfo(TLogInfo l) {
		// TODO Auto-generated method stub
		return dLogDao.getFdidByInfo(l);
	}

	@Override
	public List getLogList(LogInfo f) {
		TLogInfo t = new TLogInfo();
		PubFun.copyProperties(t, f);
		List<TLogInfo> tlist = dLogDao.getLogAll(t);
		List<LogInfo> flist = new ArrayList<>();
		if(tlist==null)
			return null ;
		for(TLogInfo tt:tlist){ 
		}
		return flist ;
		
	}

}
