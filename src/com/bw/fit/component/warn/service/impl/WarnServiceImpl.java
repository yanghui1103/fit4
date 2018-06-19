package com.bw.fit.component.warn.service.impl;

import java.util.List;
import java.util.Optional;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.component.warn.dao.WarnDao;
import com.bw.fit.component.warn.entity.TWarn;
import com.bw.fit.component.warn.service.WarnService;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.common.util.MailTool;
import com.bw.fit.system.common.util.PubFun;
import com.bw.fit.system.common.util.SmsSender;
import com.bw.fit.system.dict.dao.DictDao;
import com.bw.fit.system.dict.model.DataDict;
import com.bw.fit.system.dict.model.Dict;

@Service
public class WarnServiceImpl implements WarnService {
	@Autowired
	private WarnDao warnDao ;
	@Autowired
	private DictDao dictDao ;
	@Override
	public JSONObject sendWarning(String warningLevel, String warningType,
			String target_number, String subject, String message)  {
		JSONObject json = new JSONObject();
		Dict dict = dictDao.getDictByValue("warnLevel");
		List<DataDict> ds = dictDao.getDictsByParentId(dict.getId());
		Optional<DataDict> t = ds.stream().filter(x->x.getDict_value().equalsIgnoreCase(warningLevel)).findFirst();
		if(!t.isPresent()){
			json = new JSONObject();
			json.put("res", "1");
			json.put("msg", "没有找到预警级别，故无法发送");
			return json ;
		}
		message = "[" + t.get().getDict_name()+"]" +message ;		
		if("sms".equalsIgnoreCase(warningType)){
			try {
				SmsSender.SendSMSString(target_number, message);
				PubFun.returnSuccessJson(json);
			} catch (Exception e) {
				json = new JSONObject();
				json.put("res", "1");
				json.put("msg", e.getLocalizedMessage()); 
			}finally{
				return json ;
			}
		}else if("emain".equalsIgnoreCase(warningType)){ 
			StringBuilder sb = new StringBuilder(message);
			try {
				MailTool.send(subject, sb, new InternetAddress[] { new InternetAddress(target_number) });
				PubFun.returnSuccessJson(json);
			} catch (AddressException e) {
				json = new JSONObject();
				json.put("res", "1");
				json.put("msg", e.getLocalizedMessage()); 
			}finally{
				return json ;
			}
		}else if("ism".equalsIgnoreCase(warningType)){
			/****
			 * 发送即时消息
			 */
			PubFun.returnSuccessJson(json);
			return json ;
		} else{
			json = new JSONObject();
			json.put("res", "1");
			json.put("msg", "预警方式有误，故发送失败");
			return json ;
		}
	}
	@Override
	public List<TWarn> all(TWarn warn) {
		return warnDao.all(warn);
	}
	@Override
	public JSONObject sendWaitWarns(String runner) {
		TWarn tw = new TWarn();
		List<TWarn> allWarn = all(tw);
		return null;
	}

}
